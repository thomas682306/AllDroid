package com.example.alldroid.MapPackage;

import com.example.alldroid.R;

import java.util.ArrayList;

public class ArrayListClass {
    private static ArrayList<MapComponentModel> intermediateArray = new ArrayList<>();

    public static ArrayList<MapComponentModel> getintermediateArray() {
        intermediateArray.add(new MapComponentModel("Picasso/Glide", R.drawable.ic_galler_picasso));
        intermediateArray.add(new MapComponentModel("Firebase", R.drawable.ic_logo_built_black));
        intermediateArray.add(new MapComponentModel("Architecture", R.drawable.ic_engineer));
        intermediateArray.add(new MapComponentModel("Navigation", R.drawable.ic_navigation));
        intermediateArray.add(new MapComponentModel("Room", R.drawable.ic_database));
        intermediateArray.add(new MapComponentModel("Retrofit", R.drawable.ic_retrofit));

        return intermediateArray;
    }
}
