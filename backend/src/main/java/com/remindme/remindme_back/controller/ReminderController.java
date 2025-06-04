package com.remindme.remindme_back.controller;

import com.remindme.remindme_back.model.Reminder;
import com.remindme.remindme_back.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:9000", methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE}) // TODO fix in production
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping("/Reminders")
    public String addReminder(@RequestBody Reminder reminder) throws ExecutionException, InterruptedException {
        return reminderService.addReminder(reminder);
    }

    @GetMapping("/Reminders/{name}")
    public Reminder getReminder(@PathVariable String name) throws ExecutionException, InterruptedException {
        return reminderService.getReminder(name);
    }

    @DeleteMapping("Reminders/{name}")
    public String deleteReminder(@PathVariable String name) throws ExecutionException, InterruptedException {
        return reminderService.removeReminder(name);
    }
}
