package com.example.alldroid.MapPackage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alldroid.R;

import java.util.ArrayList;

public class RoadMapComponents extends Fragment implements RoadMapAdapter2.myOnclickListner2 {

    RecyclerView recyclerView;
    RoadMapAdapter2 roadMapAdapter2;
    ArrayList<MapComponentModel> mArrayList;


    public RoadMapComponents() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_road_map_components, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.components_recyclerview);
        mArrayList= (ArrayList<MapComponentModel>) getArguments().getSerializable("array");
        roadMapAdapter2 = new RoadMapAdapter2(mArrayList,getActivity(),this);
        recyclerView.setAdapter(roadMapAdapter2);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        roadMapAdapter2.notifyDataSetChanged();


    }

    @Override
    public void onPause() {
        super.onPause();
        mArrayList.clear();
    }

    @Override
    public void onclick(int position) {
        Toast.makeText(getActivity(),"click works",Toast.LENGTH_SHORT).show();
    }
}
