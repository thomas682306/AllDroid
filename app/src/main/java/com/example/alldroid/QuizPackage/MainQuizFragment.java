package com.example.alldroid.QuizPackage;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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

import java.util.ArrayList;
import java.util.List;

public class MainQuizFragment extends Fragment  {
    MaterialButtonToggleGroup toggleGroup;
    MaterialButton option_A,option_B,option_C,next_btn;
    private static final String TAG = "MainQuizFragment";
    TextView timer_tv,question_number_tv,question_tv,dialog_text;
    static int CORRECT_ANSWER_COUNT=0,WRONG_ANSWER_COUNT=0;

    ProgressBar progressBar;
    CountDownTimer mTimer;
    int mId, counter=0;

    ArrayList<QuestionsModel>mModel;
    NavController navController;

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
        //find view by ids
        toggleGroup=view.findViewById(R.id.toggleButton);
        option_A=view.findViewById(R.id.option_A);
        option_B=view.findViewById(R.id.option_B);
        option_C=view.findViewById(R.id.option_C);
        timer_tv=view.findViewById(R.id.timer_tv);
        dialog_text=view.findViewById(R.id.dialog_text);
        progressBar=view.findViewById(R.id.progressBar2);
        next_btn=view.findViewById(R.id.next_btn);
        question_number_tv=view.findViewById(R.id.question_number_tv);
        question_tv=view.findViewById(R.id.question_tv);
        navController = Navigation.findNavController(view);


        //assign array to serialized array
        mModel= (ArrayList<QuestionsModel>) getArguments().getSerializable("key");


        mTimer=new CountDownTimer(5000, 200) {
            public void onTick(long millisUntilFinished) {

                int time=(int) (millisUntilFinished/1000);
                timer_tv.setText(String.valueOf(time));
                Long percent=millisUntilFinished/100;
                progressBar.setProgress(percent.intValue());


            }

            public void onFinish() {
                //disablebuttons

                checkAnswer(view,mId);
                disableButton();
                //enable nextbutton
                //check write answer and give toast
                //increment respective fields
                counter++;

            }
        };
        toggleGroup.setSingleSelection(true);
        toggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if(toggleGroup.getCheckedButtonId()!=-1)
                mId=toggleGroup.getCheckedButtonId();
            }
        });

        setQuestions();
        mTimer.start();


        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter<mModel.size()) {
                    dialog_text.setVisibility(View.INVISIBLE);
                    setQuestions();
                    mTimer.start();
                }
                else{
                    next_btn.setText("View Result");
                    next_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("correct_answer_Count", CORRECT_ANSWER_COUNT);
                            bundle.putInt("wrong_answer_count", WRONG_ANSWER_COUNT);
                            bundle.putInt("total_answer_count", mModel.size());

                            navController.navigate(R.id.action_mainQuizFragment_to_quizEndFragment,bundle);
                        }
                    });
                }
            }
        });



    }

    void setQuestions(){
        enableButton();
        question_tv.setText(mModel.get(counter).getQuestion());
        option_A.setText(mModel.get(counter).getOptionA());
        option_B.setText(mModel.get(counter).getOptionB());
        option_C.setText(mModel.get(counter).getOptionC());
    }

    void checkAnswer(View view,@NonNull int id){

        Log.d("tag",String.valueOf(mId) );
        MaterialButton materialButton= view.findViewById(id);
        String option=materialButton.getText().toString().trim();
        String answer=mModel.get(counter).getAnswer();

        if(answer.equalsIgnoreCase(option)){
            dialog_text.setVisibility(View.VISIBLE);
            dialog_text.setText("Your Answer is Correct");
            CORRECT_ANSWER_COUNT++;

        }

        else {
            dialog_text.setVisibility(View.VISIBLE);
            dialog_text.setText("Whoops Wrong answer");
            WRONG_ANSWER_COUNT++;

        }

    }

    void enableButton(){
        option_A.setEnabled(true);
        option_B.setEnabled(true);
        option_C.setEnabled(true);
        next_btn.setVisibility(View.GONE);
        next_btn.setEnabled(false);

    }
    void disableButton(){
        option_A.setEnabled(false);
        option_B.setEnabled(false);
        option_C.setEnabled(false);
        next_btn.setVisibility(View.VISIBLE);
        next_btn.setEnabled(true);
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
