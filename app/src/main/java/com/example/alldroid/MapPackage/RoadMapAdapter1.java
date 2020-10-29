package com.example.alldroid.MapPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alldroid.R;

import java.util.ArrayList;

public class RoadMapAdapter1 extends RecyclerView.Adapter<RoadMapAdapter1.ViewHolder>  {
    ArrayList<MapModel>  mArrayList;
    Context mContext;
    myOnclickListener myOnclickListener;

    public RoadMapAdapter1(ArrayList<MapModel> mArrayList, Context mContext, RoadMapAdapter1.myOnclickListener myOnclickListener) {
        this.mArrayList = mArrayList;
        this.mContext = mContext;
        this.myOnclickListener = myOnclickListener;
    }

    public void setmArrayList(ArrayList<MapModel> mArrayList) {
        this.mArrayList = mArrayList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_map, parent, false);
        return new ViewHolder(view,myOnclickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.status_tv.setText(mArrayList.get(position).getStatus_text());
        holder.status_iv.setImageResource(mArrayList.get(position).getStatus_drawable());


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        myOnclickListener myOnclickListener;
        ImageView status_iv;
        TextView status_tv;
        public ViewHolder(@NonNull View itemView, final myOnclickListener myOnclickListener) {
            super(itemView);
            this.myOnclickListener=myOnclickListener;
            status_iv=itemView.findViewById(R.id.status_image);
            status_tv=itemView.findViewById(R.id.status_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myOnclickListener.myOnClick(getAdapterPosition(),mArrayList);
                }
            });
        }


    }

    interface myOnclickListener{
        void myOnClick(int position,ArrayList<MapModel> mModelArray);
    }

}


