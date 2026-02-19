package com.example.parisien.day;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DayPlanController {

    private final DayPlanService dayPlanService;

    public DayPlanController(DayPlanService dayPlanService) {
        this.dayPlanService = dayPlanService;
    }

    @GetMapping("/days")
    public List<DayPlan> days() {
        return dayPlanService.getPlans();
    }

    @PostMapping("/days/{day}/submit")
    public DayItineraryResponse submit(@PathVariable int day, @Valid @RequestBody DayChoiceRequest req) {
        return dayPlanService.submit(day, req);
    }
}
