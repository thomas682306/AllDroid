package com.example.alldroid.AdisPackage;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.alldroid.R;

import java.util.List;

public class homerecview_adapter extends RecyclerView.Adapter<homerecview_adapter.ViewHolder> {

    Context context;
    List<Imageinfo> MainImageUploadInfoList;
    ViewPager2 vp2;

    public homerecview_adapter(Context context, List<Imageinfo> TempList, ViewPager2 vp2) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;

        this.vp2=vp2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_homerecyclerview, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Imageinfo UploadInfo = MainImageUploadInfoList.get(position);

        //Loading image from Glide library.
        Glide.with(context).load(UploadInfo.getUrl()).into(holder.imageView);

        if(position== MainImageUploadInfoList.size()-2){
            vp2.post(runnable);
        }
    }


    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView_listitem_home);
        }
    }
    private Runnable runnable= new Runnable() {
        @Override
        public void run() {
            MainImageUploadInfoList.addAll(MainImageUploadInfoList);
            notifyDataSetChanged();
        }
    };
}

