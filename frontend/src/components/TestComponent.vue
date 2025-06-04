<template>
  <div>
    <q-card>
      <q-card-section>
        <div class="text-h6">{{ reminder.name }}</div>
        <q-separator></q-separator>
        <div><b>Start time:</b> {{ reminder.current_time }}</div>
        <div><b>Interval:</b> {{ reminder.time_interval }}</div>
      </q-card-section>
    </q-card>

    <div>
      <q-btn @click="newReminder" color="primary" label="New reminder"></q-btn>
    </div>

    <div>
      <q-btn
        @click="deleteReminder"
        color="deep-orange"
        label="Delete reminder"
      ></q-btn>
    </div>
  </div>
</template>

<script setup lang="ts">
import { computed, ref } from "vue";
import axios from "axios";

defineProps(["reminder"]);

let reminder = { name: ref(), current_time: ref(), time_interval: ref() };

const testReminder = {
  name: "Test2",
  current_time: "2025-06-02T13:48:54.349447Z",
  time_interval: 60,
};

function getReminder() {
  axios
    .get("http://localhost:8080/api/Reminders/Test2")
    .then((response: any) => {
      reminder = response.data;
      console.log("Obtained reminder: " + reminder);
    })
    .catch((err) => {
      console.log(err);
    });
}

function newReminder() {
  console.log("New Reminder");
  axios
    .post("http://localhost:8080/api/Reminders", testReminder)
    .then((response: any) => {
      console.log(response);
      getReminder();
    })
    .catch((err) => {
      console.log(err);
    });
}

function deleteReminder() {
  axios
    .delete("http://localhost:8080/api/Reminders/Test2")
    .then((response: any) => {
      reminder = response.data;
      console.log("Deleted reminder: " + reminder);
      getReminder();
    })
    .catch((err) => {
      console.log(err);
    });
}

getReminder();
</script>
