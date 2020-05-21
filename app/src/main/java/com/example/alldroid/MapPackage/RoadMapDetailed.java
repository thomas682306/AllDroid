package com.example.alldroid.MapPackage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alldroid.R;

public class RoadMapDetailed extends Fragment {

    RecyclerView recyclerView;
    TextView map_detail_heading;
    TextView map_detail_description;

    public RoadMapDetailed() {
//         Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_road_map_detailed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.map_detailed_recyclerview);
        map_detail_heading=view.findViewById(R.id.map_detailed_heading);
        map_detail_description=view.findViewById(R.id.map_detailed_description);



    }
}
