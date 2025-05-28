package com.remindme.remindme_back.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.remindme.remindme_back.model.Reminder;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ReminderService {

    private static final String COLLECTION_NAME = "Reminders";

    public String addReminder(Reminder reminder) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> future = dbFirestore.collection(COLLECTION_NAME).document(reminder.getName()).set(reminder);

        return future.get().getUpdateTime().toString();
    }

    public Reminder getReminder(String name) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference docRef = dbFirestore.collection(COLLECTION_NAME).document(name);

        ApiFuture<DocumentSnapshot> future = docRef.get();

        DocumentSnapshot document = future.get();

        Reminder reminder = null;
        if (document.exists()) {
            reminder = document.toObject(Reminder.class);

            return reminder;
        } else {
            return null;
        }
    }

    public String removeReminder(String name) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> future = dbFirestore.collection("Reminders").document(name).delete();

        return future.get().getUpdateTime().toString();
    }
}
