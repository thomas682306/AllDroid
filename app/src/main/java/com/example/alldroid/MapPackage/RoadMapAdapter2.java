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

public class RoadMapAdapter2 extends RecyclerView.Adapter<RoadMapAdapter2.mViewHolder> {
    ArrayList<MapComponentModel>  mArrayList;
    Context mContext;
    myOnclickListner2 onclickListner2;
    public RoadMapAdapter2(ArrayList<MapComponentModel> mArrayList, Context mContext, myOnclickListner2 myOnclickListner2) {
        this.mArrayList = mArrayList;
        this.mContext = mContext;
        this.onclickListner2=myOnclickListner2;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_map_components, parent, false);
        return new RoadMapAdapter2.mViewHolder(view,onclickListner2);
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {
        holder.status_tv.setText(mArrayList.get(position).getStatus());
        holder.status_iv.setImageResource(mArrayList.get(position).getResourceId());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    class mViewHolder extends RecyclerView.ViewHolder {
        myOnclickListner2 onclickListner2;
        ImageView status_iv;
        TextView status_tv;
        public mViewHolder(@NonNull View itemView, final myOnclickListner2 onclickListner2) {
            super(itemView);
            status_iv=itemView.findViewById(R.id.component_image);
            status_tv=itemView.findViewById(R.id.component_text);
            this.onclickListner2=onclickListner2;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onclickListner2.onclick(getAdapterPosition());
                }
            });
        }
    }

    interface myOnclickListner2{
        void onclick(int position);
    }

}
