package com.example.alldroid.QuizPackage;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class FirebaseRepository {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

     public Task<QuerySnapshot> getNotes=db.collection("Questions")
                .get();



}
