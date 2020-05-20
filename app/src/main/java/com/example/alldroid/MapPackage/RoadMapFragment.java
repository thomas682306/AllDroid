package com.example.alldroid.MapPackage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alldroid.R;

import java.util.ArrayList;

public class RoadMapFragment extends Fragment implements RoadMapAdapter1.myOnclickListener {
    NavController navController;
    RecyclerView recyclerView;
    ArrayList<MapModel> myArrayList= new ArrayList<>();
    RoadMapAdapter1 roadMapAdapter1 ;
    public RoadMapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addToList(myArrayList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_road_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.map_recycler);
        navController= Navigation.findNavController(view);


        roadMapAdapter1= new RoadMapAdapter1(myArrayList,getActivity(),this);
        recyclerView.setAdapter(roadMapAdapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        roadMapAdapter1.notifyDataSetChanged();


    }

    @Override
    public void myOnClick(int position, ArrayList<MapModel> mModelArray) {
        if(mModelArray.get(position).isWebView()){
            Bundle bundle = new Bundle();
            bundle.putString("url",mModelArray.get(position).getUrl());
            navController.navigate(R.id.action_roadMapFragment_to_webViewFragment,bundle);
        }

        else{
            //travel to components with firebase

        }
    }

    void addToList(ArrayList<MapModel> mArrayList){
        mArrayList.add(new MapModel("Newbie to Beginner",R.drawable.ic_newbie,false, "Beginner"));
        mArrayList.add(new MapModel("Beginner to Intermediate",R.drawable.ic_progress,false, "Intermediate"));
        mArrayList.add(new MapModel("Intermediate to Professional",R.drawable.ic_pro,false, "Professional"));

        mArrayList.add(new MapModel("Master Git",R.drawable.ic_github_logo,true, "https://medium.com/better-programming/how-to-use-git-in-android-studio-part-1-a8a554006aad"));
        mArrayList.add(new MapModel("Learn about Google's Material Guidlines",R.drawable.ic_material,true, "https://material.io/"));
        mArrayList.add(new MapModel("Learn a backend Framework",R.drawable.ic_backend,true, "https://medium.com/@Kaperskyguru/top-5-backend-frameworks-a14a390151d2"));



    }
}
