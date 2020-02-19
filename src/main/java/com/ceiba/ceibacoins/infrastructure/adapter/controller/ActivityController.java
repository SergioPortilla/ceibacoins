package com.ceiba.ceibacoins.infrastructure.adapter.controller;

import com.ceiba.ceibacoins.application.caseuse.ActivityService;
import com.ceiba.ceibacoins.domain.model.Activity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public @ResponseBody
    List<Activity> getAllActivities() { return activityService.findAllActivities();}
}
