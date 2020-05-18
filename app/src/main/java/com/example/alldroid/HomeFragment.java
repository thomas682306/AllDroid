package com.example.alldroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alldroid.QuizPackage.QuizActivity;
import com.google.android.material.button.MaterialButton;

public class HomeFragment extends Fragment {

    CardView topicofthedaycardview;
    MaterialButton start_quiz_btn;
    NavController navController;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        start_quiz_btn=view.findViewById(R.id.start_quiz_button);
        topicofthedaycardview=view.findViewById(R.id.cardView_homefragment);
        navController = Navigation.findNavController(view);
        topicofthedaycardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_homeFragment_to_topicOfDayDetails);
            }
        });

        start_quiz_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), QuizActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

    }
}
