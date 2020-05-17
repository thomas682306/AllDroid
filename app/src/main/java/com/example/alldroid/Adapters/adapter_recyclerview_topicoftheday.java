package com.example.alldroid.Adapters;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alldroid.R;
import com.example.alldroid.entityitems.siteandlink;

import java.util.ArrayList;

public class adapter_recyclerview_topicoftheday extends RecyclerView.Adapter<adapter_recyclerview_topicoftheday.topicoftheday_viewholder>  {


    ArrayList<siteandlink> mdata;
    Context context;

    public adapter_recyclerview_topicoftheday(ArrayList<siteandlink> mdata, Context context) {
        this.mdata = mdata;
        this.context = context;
    }

    @NonNull
    @Override
    public topicoftheday_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_recyclerviewfromtopicofthedaydescriptionfragment,parent,false);
        return new topicoftheday_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull topicoftheday_viewholder holder, int position) {
        holder.site.setText(mdata.get(position).getSitename());
        holder.link.setText(mdata.get(position).getLink());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class topicoftheday_viewholder extends RecyclerView.ViewHolder {

        TextView site,link;
        public topicoftheday_viewholder(@NonNull View itemView) {
            super(itemView);
            site=itemView.findViewById(R.id.sitenameid);
            link=itemView.findViewById(R.id.linkid);
        }
    }
}
