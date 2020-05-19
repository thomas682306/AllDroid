package com.example.alldroid.QuizPackage;

import android.content.DialogInterface;
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

import com.airbnb.lottie.LottieAnimationView;
import com.example.alldroid.MainActivity;
import com.example.alldroid.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainQuizFragment extends Fragment  {
    MaterialButtonToggleGroup toggleGroup;
    MaterialButton option_A,option_B,option_C,next_btn;
    private static final String TAG = "MainQuizFragment";
    TextView timer_tv,question_number_tv,question_tv;
    static int CORRECT_ANSWER_COUNT,WRONG_ANSWER_COUNT;

    ProgressBar progressBar;
    CountDownTimer mTimer;
    int mId=0, counter;

    ArrayList<QuestionsModel>mModel;
    NavController navController;
    private LottieAnimationView lottieView;

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
        CORRECT_ANSWER_COUNT=0;
        WRONG_ANSWER_COUNT=0;
        counter=0;

        toggleGroup=view.findViewById(R.id.toggleButton);
        option_A=view.findViewById(R.id.option_A);
        option_B=view.findViewById(R.id.option_B);
        option_C=view.findViewById(R.id.option_C);
        timer_tv=view.findViewById(R.id.timer_tv);
        lottieView=view.findViewById(R.id.lottieCorrect_or_wrong);
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
                mId=0;
                if(toggleGroup.getCheckedButtonId()!=-1) {
                    mId = toggleGroup.getCheckedButtonId();
                }

            }
        });

        setQuestions();
        mTimer.start();


        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter<mModel.size()) {
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
        question_number_tv.setText(String.valueOf(counter+1));
        question_tv.setText(mModel.get(counter).getQuestion());
        option_A.setText(mModel.get(counter).getOptionA());
        option_B.setText(mModel.get(counter).getOptionB());
        option_C.setText(mModel.get(counter).getOptionC());
    }

    void checkAnswer(View view,@NonNull int id){
        if(id!=0) {
            MaterialButton materialButton = view.findViewById(id);
            String option = materialButton.getText().toString().trim();
            String answer = mModel.get(counter).getAnswer();

            if (answer.equalsIgnoreCase(option)) {
                lottieView.setVisibility(View.VISIBLE);
                lottieView.setAnimation("tick.json");
                lottieView.playAnimation();
                CORRECT_ANSWER_COUNT++;

            } else {
                lottieView.setVisibility(View.VISIBLE);
                lottieView.setAnimation("wrong_three.json");
                lottieView.playAnimation();
                WRONG_ANSWER_COUNT++;

            }
        }

        else{

            WRONG_ANSWER_COUNT++;
        }

    }

    void enableButton(){
        option_A.setEnabled(true);
        option_B.setEnabled(true);
        option_C.setEnabled(true);
        next_btn.setVisibility(View.GONE);
        next_btn.setEnabled(false);
        lottieView.setVisibility(View.INVISIBLE);

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

                final MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getActivity());
                builder.setMessage("Are you sure, you want to exit the quiz ?")
                        .setTitle("Leave Quiz ")
                        .setIcon(R.drawable.ic_exit_to_app_black_24dp)
                        .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                leaveFragment();
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();




            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }


    void leaveFragment(){
        Intent intent= new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();

    }
}
