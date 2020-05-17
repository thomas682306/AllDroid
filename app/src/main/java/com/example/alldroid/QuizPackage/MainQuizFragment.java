package com.example.alldroid.QuizPackage;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDeepLinkBuilder;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alldroid.MainActivity;
import com.example.alldroid.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class MainQuizFragment extends Fragment  {
    MaterialButtonToggleGroup toggleGroup;
    MaterialButton option_A;
    MaterialButton option_B;
    MaterialButton option_C;
    MaterialButton next_btn;
    TextView timer_tv;
    ProgressBar progressBar;
    CountDownTimer mTimer;
    int mId;
    int counter=1;



    private NavController navController;

    public MainQuizFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toggleGroup=view.findViewById(R.id.toggleButton);
        option_A=view.findViewById(R.id.option_A);
        option_B=view.findViewById(R.id.option_B);
        option_C=view.findViewById(R.id.option_C);
        timer_tv=view.findViewById(R.id.timer_tv);
        progressBar=view.findViewById(R.id.progressBar2);
        next_btn=view.findViewById(R.id.next_btn);
        navController = Navigation.findNavController(view);


        mTimer=new CountDownTimer(10000, 150) {
            public void onTick(long millisUntilFinished) {
                enableButtons();
                int time=(int) (millisUntilFinished/1000);
                timer_tv.setText(String.valueOf(time));
                Long percent=millisUntilFinished/100;
                progressBar.setProgress(percent.intValue());

            }
            public void onFinish() {
                disableButtons();
            }
        };

        mTimer.start();

        toggleGroup.setSingleSelection(true);
        toggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                mId=checkedId;
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion(counter);
            }
        });

    }

    void disableButtons(){
        option_A.setEnabled(false);
        option_B.setEnabled(false);
        option_C.setEnabled(false);
        next_btn.setVisibility(View.VISIBLE);
        next_btn.setEnabled(true);
    }

    void enableButtons(){
        option_A.setEnabled(true);
        option_B.setEnabled(true);
        option_C.setEnabled(true);
        next_btn.setVisibility(View.INVISIBLE);
        next_btn.setEnabled(false);
    }

    void nextQuestion(int counter) {
        while (counter < 4) {
            counter++;
            mTimer.start();

        }
        next_btn.setText("View Result");
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_mainQuizFragment_to_quizEndFragment);

            }
        });



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
