package com.example.parisien.play;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayService {

    private final List<PlayAnswer> store = new ArrayList<>();

    public PlayAnswer save(PlayAnswer answer) {
        store.add(answer);
        return answer;
    }
    public List<PlayAnswer> findAll() {
        return store;
    }
    public PlayAnswer findLast() {
        if (store.isEmpty()) {
            return null;
        }
        return store.get(store.size() - 1);
    }
    public ResultResponse summarize(PlayAnswer a) {
        ParisScore s = new ParisScore();

        // morningChoice 해석
        if ("LOUVRE".equals(a.getMorningChoice())) s.addCulture(2);
        if ("BAKERY_SLEEPIN".equals(a.getMorningChoice())) s.addSlow(2);

        // lunchChoice 해석
        if ("FAMOUS_RESTAURANT".equals(a.getLunchChoice())) s.addFood(2);
        if ("BISTRO_RANDOM".equals(a.getLunchChoice())) s.addFree(2);

        // dinnerChoice 해석
        if ("EIFFEL_NIGHT".equals(a.getDinnerChoice())) s.addLandmark(2);
        if ("SEINE_WALK".equals(a.getDinnerChoice())) s.addSlow(2);

        // 결과 문장 만들기(가장 높은 축 1~2개로 타입 결정)
        String title;
        String subtitle;

        int max = Math.max(s.getCulture(), Math.max(s.getSlow(), Math.max(s.getFood(), Math.max(s.getLandmark(), s.getFree()))));

        if (max == s.getSlow()) {
            title = "너의 파리는 ‘느린 감성’ 타입";
            subtitle = "동선 짧게, 여백 있게, 밤 산책이 잘 맞아요.";
            return new ResultResponse(title, subtitle, List.of(
                    "오전: 1~2개만 고정하고 나머진 자유",
                    "점심: 줄 서는 맛집보다 근처 분위기 좋은 곳",
                    "저녁: 센강/동네 산책을 메인 이벤트로"
            ));
        }

        if (max == s.getCulture()) {
            title = "너의 파리는 ‘문화 몰입’ 타입";
            subtitle = "뮤지엄/전시 중심으로 하루를 설계하면 만족도가 높아요.";
            return new ResultResponse(title, subtitle, List.of(
                    "오전: 오픈런 1곳 + 근처 카페",
                    "점심: 박물관 근처로 이동 최소화",
                    "저녁: 체력 회복(짧은 야경/숙소 근처)"
            ));
        }

        if (max == s.getFood()) {
            title = "너의 파리는 ‘식도락 중심’ 타입";
            subtitle = "식사 퀄리티가 여행 만족도를 좌우해요.";
            return new ResultResponse(title, subtitle, List.of(
                    "오전: 시장/베이커리로 가볍게 시작",
                    "점심: 1일 1맛집만 ‘확실히’",
                    "저녁: 와인바/브라세리로 마무리"
            ));
        }

        if (max == s.getLandmark()) {
            title = "너의 파리는 ‘랜드마크 설계’ 타입";
            subtitle = "핵심 스팟을 효율적으로 찍고 여유는 그 사이에 둬요.";
            return new ResultResponse(title, subtitle, List.of(
                    "오전: 핵심 1개 + 이동 최소 동선",
                    "점심: 사진/휴식 포함",
                    "저녁: 야경 스팟을 1개만 고정"
            ));
        }

        title = "너의 파리는 ‘즉흥 탐험’ 타입";
        subtitle = "계획은 최소, 현장 감각으로 채우는 여행이 맞아요.";
        return new ResultResponse(title, subtitle, List.of(
                "오전: 동네 하나 정하고 걷기",
                "점심: 끌리는 곳 들어가기(예약 강박 금지)",
                "저녁: ‘좋아 보이는 거리’에서 마무리"
        ));
    }

}

