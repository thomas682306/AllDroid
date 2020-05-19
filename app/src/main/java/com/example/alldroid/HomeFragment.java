package com.example.alldroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alldroid.AdisPackage.AdisFirebaseRepo;
import com.example.alldroid.AdisPackage.siteandlink;
import com.example.alldroid.AdisPackage.topic;
import com.example.alldroid.QuizPackage.FirebaseRepository;
import com.example.alldroid.QuizPackage.QuizActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    CardView topicofthedaycardview;
    MaterialButton start_quiz_btn;
    NavController navController;
    FirebaseRepository mfire;
    private List<topic> sampledata=new ArrayList<>();
    TextView topicoftheday,descoftopicoftheweek;
    public List<siteandlink> siteandlinkdata=new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mfire= new FirebaseRepository();

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
        topicoftheday=view.findViewById(R.id.topicoftheday_home);
        descoftopicoftheweek=view.findViewById(R.id.desc_topicoftheweek_home);



        mfire.gettopic.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                sampledata= task.getResult().toObjects(topic.class);
                Log.d("TAG", sampledata.get(0).getTopic());
                topicoftheday.setText(sampledata.get(0).getTopic());
                descoftopicoftheweek.setText(sampledata.get(0).getDescription());
            }
        });




        topicofthedaycardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfire.getlinks.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        siteandlinkdata=task.getResult().toObjects(siteandlink.class);
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("links", (Serializable) siteandlinkdata);
                        navController.navigate(R.id.action_homeFragment_to_topicOfDayDetails, bundle);

                    }
                });
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
