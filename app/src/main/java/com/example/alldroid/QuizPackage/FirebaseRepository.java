package com.example.alldroid.QuizPackage;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FirebaseRepository {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

     public Task<QuerySnapshot> getNotes=db.collection("Questions")
                .get();


}
