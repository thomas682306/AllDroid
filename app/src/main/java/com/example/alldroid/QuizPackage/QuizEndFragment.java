package com.example.alldroid.QuizPackage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.alldroid.MainActivity;
import com.example.alldroid.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;


public class QuizEndFragment extends Fragment {
    MaterialButton exit_btn;
    MaterialTextView anwered_correct_tv,anwered_wrong_tv,percent_tv;
    ProgressBar progressBar;
    LottieAnimationView lottieAnimationView;

    public QuizEndFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_end, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        exit_btn=view.findViewById(R.id.exit_btn);
        anwered_correct_tv=view.findViewById(R.id.answered_correct);
        anwered_wrong_tv=view.findViewById(R.id.answered_wrong);
        progressBar=view.findViewById(R.id.progressBar);
        percent_tv=view.findViewById(R.id.percent);
        lottieAnimationView=view.findViewById(R.id.lottieAnimationView);

        double correct=getArguments().getInt("correct_answer_Count");
        double wrong=getArguments().getInt("wrong_answer_count");
        double total=getArguments().getInt("total_answer_count");

        Log.d("tag",String.valueOf(correct));
        Log.d("tag",String.valueOf(wrong));
        Log.d("tag",String.valueOf(total));

        double progressvalue= correct/total*100;


        Log.d("tag",String.valueOf(progressvalue));


        Toast.makeText(getActivity().getApplicationContext(),String.valueOf(progressvalue),Toast.LENGTH_SHORT).show();
        progressBar.setProgress((int) progressvalue);
        percent_tv.setText((progressvalue +"%"));

        if(progressvalue<40){
            lottieAnimationView.setAnimation("something_wrong.json");
        }
        else if(progressvalue>40&& progressvalue<80){
            lottieAnimationView.setAnimation("thumbs_up.json");

        }
        else {
            lottieAnimationView.setAnimation("crown.json");

        }
        anwered_wrong_tv.setText(wrong+" Questions were answered incorrectly");
        anwered_correct_tv.setText(correct+" Questions were answered correctly");


        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
}
