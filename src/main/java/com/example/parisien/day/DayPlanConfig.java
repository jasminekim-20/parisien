package com.example.parisien.day;

import com.example.parisien.place.Place;
import com.example.parisien.place.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class DayPlanConfig {

    enum Cat { RESTAURANT, CAFE, NIGHT_VIEW, ATTRACTION, WALK_PARK, MUSEUM }

    @Bean
    public List<DayPlan> dayPlans(PlaceService ps) {
        List<Place> all = ps.findAll();

        // 1) 분류 bucket
        Map<Cat, List<Place>> b = Arrays.stream(Cat.values())
                .collect(Collectors.toMap(c -> c, c -> new ArrayList<>(), (x,y)->x, LinkedHashMap::new));
        for (Place p : all) b.get(classify(p)).add(p);

        // 2) 중복 방지
        Set<String> used = new HashSet<>();

        // 3) Day1~5 생성
        List<DayPlan> out = new ArrayList<>();
        for (int day = 1; day <= 5; day++) {
            out.add(makeDay(day, b, used, all));
        }
        return out;
    }

    private DayPlan makeDay(int day, Map<Cat, List<Place>> b, Set<String> used, List<Place> all) {
        // 아침: 브런치 vs 산책/피크닉
        DaySlot morning = new DaySlot(
                Slot.MORNING,
                opt(day,"m","a","여유로운 브런치", pickUnique(b, used, Cat.CAFE,      all)),
                opt(day,"m","b","산책/피크닉",     pickUnique(b, used, Cat.WALK_PARK, all))
        );

        // 점심: 핫플 명소 vs 전시/뮤지엄
        DaySlot lunch = new DaySlot(
                Slot.LUNCH,
                opt(day,"l","a","핫플 명소 코스",  pickUnique(b, used, Cat.ATTRACTION, all)),
                opt(day,"l","b","전시/뮤지엄",     pickUnique(b, used, Cat.MUSEUM,     all))
        );

        // 저녁: 레스토랑 vs 야경 스팟
        DaySlot dinner = new DaySlot(
                Slot.DINNER,
                opt(day,"d","a","레스토랑 제대로",  pickUnique(b, used, Cat.RESTAURANT, all)),
                opt(day,"d","b","야경 스팟/산책",   pickUnique(b, used, Cat.NIGHT_VIEW, all))
        );

        return new DayPlan(day, "Day " + day, List.of(morning, lunch, dinner));
    }

    private DayOption opt(int day, String slot, String ab, String label, Place p) {
        return new DayOption("d"+day+"-"+slot+"-"+ab, label, p);
    }

    // ✅ 핵심: used에 없는 place만 고름 (없으면 가까운 카테고리로 fallback)
    private Place pickUnique(Map<Cat, List<Place>> b, Set<String> used, Cat want, List<Place> all) {
        Place p = popFirstUnused(b.get(want), used);
        if (p != null) return p;

        // fallback (의미 가까운 순서)
        if (want == Cat.RESTAURANT) { p = popFirstUnused(b.get(Cat.CAFE), used); if (p != null) return p; }
        if (want == Cat.NIGHT_VIEW) {
            p = popFirstUnused(b.get(Cat.WALK_PARK), used); if (p != null) return p;
            p = popFirstUnused(b.get(Cat.ATTRACTION), used); if (p != null) return p;
        }
        if (want == Cat.WALK_PARK) { p = popFirstUnused(b.get(Cat.ATTRACTION), used); if (p != null) return p; }
        if (want == Cat.MUSEUM) { p = popFirstUnused(b.get(Cat.ATTRACTION), used); if (p != null) return p; }

        // 마지막: 전체 중 unused 하나
        for (Place x : all) {
            if (x != null && x.getId() != null && used.add(x.getId())) return x;
        }
        // 진짜로 다 쓴 경우(장소 수가 15개 미만이면 발생 가능)
        return all.get(0);
    }

    private Place popFirstUnused(List<Place> list, Set<String> used) {
        if (list == null) return null;
        for (Place p : list) {
            if (p != null && p.getId() != null && !used.contains(p.getId())) {
                used.add(p.getId());
                return p;
            }
        }
        return null;
    }

    // -------- 분류(짧게) --------
    private Cat classify(Place p) {
        String t = safe(p.getType()).toUpperCase(Locale.ROOT);
        String n = safe(p.getName()).toLowerCase(Locale.ROOT);

        if ("RESTAURANT".equals(t)) return Cat.RESTAURANT;
        if ("CAFE".equals(t)) return Cat.CAFE;
        if ("PARK".equals(t)) return Cat.WALK_PARK;
        if ("MUSEUM".equals(t)) return Cat.MUSEUM;

        if (isMuseum(n)) return Cat.MUSEUM;
        if (isCafe(n)) return Cat.CAFE;
        if (isWalk(n)) return Cat.WALK_PARK;
        if (isNight(n)) return Cat.NIGHT_VIEW;

        return Cat.ATTRACTION;
    }

    private boolean isCafe(String n){ return n.contains("cafe")||n.contains("coffee")||n.contains("brunch")||n.contains("bakery"); }
    private boolean isMuseum(String n){ return n.contains("museum")||n.contains("musée")||n.contains("musee")||n.contains("gallery")||n.contains("bibli"); }
    private boolean isWalk(String n){ return n.contains("park")||n.contains("garden")||n.contains("jardin")||n.contains("promenade")||n.contains("square"); }
    private boolean isNight(String n){ return n.contains("eiffel")||n.contains("seine")||n.contains("pont")||n.contains("bridge")||n.contains("view")||n.contains("panorama")||n.contains("rooftop")||n.contains("montmartre"); }

    private String safe(String s){ return s==null? "" : s; }
}
