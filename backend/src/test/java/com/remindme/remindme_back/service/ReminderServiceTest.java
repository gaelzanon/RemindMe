package com.remindme.remindme_back.service;

import com.remindme.remindme_back.model.Reminder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReminderServiceTest {

    @Autowired
    private ReminderService reminderService;

    @AfterAll
    static void cleanUp(@Autowired ReminderService reminderService) throws ExecutionException, InterruptedException {
        reminderService.removeReminder("Test1");
        reminderService.removeReminder("Test2");
    }

    @Test
    void addReminder() throws ExecutionException, InterruptedException {
        Reminder test1 = new Reminder("Test1", Instant.now(), 60);

        assertNotNull(reminderService.addReminder(test1));
    }

    @Test
    void getReminder() throws  ExecutionException, InterruptedException {
        Reminder test2 = new Reminder("Test2", Instant.now(), 60);
        reminderService.addReminder(test2);

        assertEquals(test2.getName(), reminderService.getReminder("Test2").getName());
    }

    @Test
    void removeReminder() throws ExecutionException, InterruptedException {
        new Reminder("Test3", Instant.now(), 60);

        assertNotNull(reminderService.removeReminder("Test3"));
    }
}