package com.remindme.remindme_back.model;

import java.time.Instant;
import java.time.LocalDateTime;

public class Reminder {

    private String name;
    private int id;
    private Instant current_time;
    private int time_interval;

    public Reminder() {
    }

    public Reminder(String name, Instant current_time, int time_interval) {
        this.name = name;
        this.current_time = current_time;
        this.time_interval = time_interval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(Instant current_time) {
        this.current_time = current_time;
    }

    public int getTime_interval() {
        return time_interval;
    }

    public void setTime_interval(int time_interval) {
        this.time_interval = time_interval;
    }
}

