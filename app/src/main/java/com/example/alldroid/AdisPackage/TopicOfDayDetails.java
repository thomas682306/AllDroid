package com.example.alldroid.AdisPackage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alldroid.AdisPackage.AdisFirebaseRepo;
import com.example.alldroid.AdisPackage.adapter_recyclerview_topicoftheday;
import com.example.alldroid.AdisPackage.siteandlink;
import com.example.alldroid.QuizPackage.FirebaseRepository;
import com.example.alldroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TopicOfDayDetails extends Fragment {


    RecyclerView recyclerView_topicofthedayfragment;
    public List<siteandlink> loaddata=new ArrayList<>();




    public TopicOfDayDetails() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_topic_of_day_details, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loaddata= (ArrayList<siteandlink>) getArguments().getSerializable("links");



        recyclerView_topicofthedayfragment=view.findViewById(R.id.recyclerview_topicofthedaydescriptionfragment);
        adapter_recyclerview_topicoftheday rviewadapter=new adapter_recyclerview_topicoftheday();
        rviewadapter.setMdata(loaddata);


        recyclerView_topicofthedayfragment.setHasFixedSize(true);
        recyclerView_topicofthedayfragment.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_topicofthedayfragment.setAdapter(rviewadapter);


    }
}
