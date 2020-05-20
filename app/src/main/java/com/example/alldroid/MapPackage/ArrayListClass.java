package com.example.alldroid.MapPackage;

import androidx.transition.Transition;

import com.example.alldroid.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayListClass {
    private static ArrayList<MapComponentModel> intermediateArray = new ArrayList<>();
    private static ArrayList<MapComponentModel> beginnerArray= new ArrayList<>();
    private static ArrayList<MapComponentModel> professionalArray= new ArrayList<>();

    public static ArrayList<MapComponentModel> getintermediateArray() {
        intermediateArray.add(new MapComponentModel("Picasso/Glide", R.drawable.ic_galler_picasso));
        intermediateArray.add(new MapComponentModel("Firebase", R.drawable.ic_logo_built_black));
        intermediateArray.add(new MapComponentModel("Architecture", R.drawable.ic_engineer));
        intermediateArray.add(new MapComponentModel("Navigation", R.drawable.ic_navigation));
        intermediateArray.add(new MapComponentModel("Room", R.drawable.ic_database));
        intermediateArray.add(new MapComponentModel("Retrofit", R.drawable.ic_retrofit));

        return intermediateArray;
    }

    public static ArrayList<MapComponentModel> getbeginnerArray(){
        beginnerArray.add(new MapComponentModel("Java/Kotlin",R.drawable.java));
        beginnerArray.add(new MapComponentModel("Layout Basics",R.drawable.ic_layoutbasics));
        beginnerArray.add(new MapComponentModel("Basic Views",R.drawable.ic_basicviews));
        beginnerArray.add(new MapComponentModel("Notifications",R.drawable.ic_notifications));
        beginnerArray.add(new MapComponentModel("Intents",R.drawable.ic_intents));
        beginnerArray.add(new MapComponentModel("Advanced Views",R.drawable.ic_advancedviews));

        return beginnerArray;
    }
    public static ArrayList<MapComponentModel> getProfessionalArray(){
        professionalArray.add(new MapComponentModel("Complex Database Desgn",R.drawable.ic_man_data));
        professionalArray.add(new MapComponentModel("Concurrency",R.drawable.ic_concurrency));
        professionalArray.add(new MapComponentModel("Unit/UI Testing",R.drawable.ic_testing));
        professionalArray.add(new MapComponentModel("Dagger",R.drawable.ic_knife));
        professionalArray.add(new MapComponentModel("Network Caching",R.drawable.ic_man_data));
        professionalArray.add(new MapComponentModel("Debugging",R.drawable.ic_debugging));

        return professionalArray;
    }
}
