package com.example.alldroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alldroid.Adapters.adapter_recyclerview_topicoftheday;
import com.example.alldroid.entityitems.siteandlink;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopicOfDayDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopicOfDayDetails extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView recyclerView_topicofthedayfragment;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TopicOfDayDetails() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopicOfDayDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static TopicOfDayDetails newInstance(String param1, String param2) {
        TopicOfDayDetails fragment = new TopicOfDayDetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_topic_of_day_details, container, false);
         ArrayList<siteandlink> data=new ArrayList<>();
         data.add(new siteandlink("Youtube","https://www.youtube.com/"));
         data.add(new siteandlink("Codelabs","https://codelabs.developers.google.com/codelabs/android-training-create-recycler-view/index.html?index=..%2F..android-training#0"));


         recyclerView_topicofthedayfragment=view.findViewById(R.id.recyclerview_topicofthedaydescriptionfragment);
        adapter_recyclerview_topicoftheday rviewadapter=new adapter_recyclerview_topicoftheday(data,getContext());
        recyclerView_topicofthedayfragment.setHasFixedSize(true);
        recyclerView_topicofthedayfragment.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView_topicofthedayfragment.setAdapter(rviewadapter);
        return view;
    }
}
