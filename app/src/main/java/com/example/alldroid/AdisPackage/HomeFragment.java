package com.example.alldroid.AdisPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.alldroid.QuizPackage.FirebaseRepository;
import com.example.alldroid.QuizPackage.QuizActivity;
import com.example.alldroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapePath;
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
    private List<topic> dt=new ArrayList<>();
    TextView topicoftheday,descoftopicoftheweek;
    public List<siteandlink> siteandlinkdata=new ArrayList<>();
    Bundle bundle;
    ProgressBar pbar_home;
    ViewPager2 vp2_home;
    homerecview_adapter madapt;

    // Creating List of ImageUploadInfo class.
    List<Imageinfo> list = new ArrayList<>();


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
        pbar_home=view.findViewById(R.id.probar_homefragment);
        pbar_home.setVisibility(View.VISIBLE);


        vp2_home=view.findViewById(R.id.recyclerview_homefragment);


        mfire.getimages.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                list= task.getResult().toObjects(Imageinfo.class);
                madapt= new homerecview_adapter(getContext(),list);
                vp2_home.setAdapter(madapt);
//                vp2_home.setPageTransformer(new ZoomOutPageTransformer());
                vp2_home.setClipToPadding(false);
                vp2_home.setClipChildren(false);
                vp2_home.setOffscreenPageLimit(3);
                vp2_home.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
                CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
                compositePageTransformer.addTransformer(new MarginPageTransformer(40));
                compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                    @Override
                    public void transformPage(@NonNull View page, float position) {
                        float r=1-Math.abs(position);
                        page.setScaleY(0.85f+ r*0.15f);
                    }
                });
                vp2_home.setPageTransformer(compositePageTransformer);
            }
        });






        mfire.gettopic.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                sampledata= task.getResult().toObjects(topic.class);
                topicoftheday.setText(sampledata.get(0).getTopic());
                descoftopicoftheweek.setText(sampledata.get(0).getDescription());
                pbar_home.setVisibility(View.INVISIBLE);
            }
        });




        topicofthedaycardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfire.getlinks.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        siteandlinkdata=task.getResult().toObjects(siteandlink.class);
                        bundle=new Bundle();
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
