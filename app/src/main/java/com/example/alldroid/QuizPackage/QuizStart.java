package com.example.alldroid.QuizPackage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alldroid.MainActivity;
import com.example.alldroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class QuizStart extends Fragment {
    MaterialButton readyButton;
    NavController navController;
    ProgressBar progressBar;
    FirebaseRepository firebaseRepository;

    private List<QuestionsModel> allQuestionList = new ArrayList<>();

    public QuizStart() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //instance of firebase repository
        firebaseRepository= new FirebaseRepository();
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event

                //need to add a dialog to handle back clicks
                Intent intent= new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_quiz_start, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        readyButton=view.findViewById(R.id.ready_button);
        navController = Navigation.findNavController(view);
        progressBar=view.findViewById(R.id.load_question_progress);


        //setting the button's visibility before start
        readyButton.setVisibility(View.VISIBLE);
        readyButton.setEnabled(true);
        progressBar.setVisibility(View.GONE);


        readyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setting the button's visibility after click
                readyButton.setEnabled(false);
                readyButton.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);


                //load the questions onto a list
                firebaseRepository.getNotes.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        allQuestionList=task.getResult().toObjects(QuestionsModel.class);
                        progressBar.setVisibility(View.GONE);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("key", (Serializable) allQuestionList);

                        //travelling to quiz and passing list as serializable bundle
                        navController.navigate(R.id.action_quizStart_to_mainQuizFragment,bundle);

                    }
                });



            }
        });
    }


}
