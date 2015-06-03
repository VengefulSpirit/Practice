package com.dreamer.practice.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dreamer.practice.R;
import com.dreamer.practice.bean.SimpleCelebrity;
import com.squareup.picasso.Picasso;

import net.wujingchao.android.view.SimpleTagImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreamer on 2015/5/26.
 */
public class SimpleCelebrityListAdapter extends RecyclerView.Adapter<SimpleCelebrityListAdapter.SimpleCelebrityHolder> {
    private static final String TAG = "SimpleCelebrityListAdapter";
    List<SimpleCelebrity> simpleCelebrityList;

    Context context;


    public SimpleCelebrityListAdapter() {
        this.simpleCelebrityList = new ArrayList<SimpleCelebrity>();
    }

    public SimpleCelebrityListAdapter(Context context) {
        this.context = context;
        this.simpleCelebrityList = new ArrayList<SimpleCelebrity>();
    }

    public void addSimpleCelebrities(List<SimpleCelebrity> simpleCelebrityList,int type) {
        //this.simpleCelebrityList.addAll(simpleCelebrityList);
        int size = simpleCelebrityList.size();
        for (int i = 0; i < size; i++){
            simpleCelebrityList.get(i).setType(type);
            this.simpleCelebrityList.add(simpleCelebrityList.get(i));
        }
        this.notifyItemRangeInserted(0, size - 1);
    }

    public void clearSimpleCelebrities() {
        int size = this.simpleCelebrityList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                simpleCelebrityList.remove(0);
            }
            this.notifyItemRangeRemoved(0, size);
        }
    }

    @Override
    public SimpleCelebrityHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celebrity_item, viewGroup, false);
        return new SimpleCelebrityHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleCelebrityHolder viewHolder, final int i) {
        final SimpleCelebrity simpleCelebrity = simpleCelebrityList.get(i);
        //Picasso.with(context).setIndicatorsEnabled(false);
        Picasso.with(context).load(simpleCelebrity.getAvatars().getLarge()).into(viewHolder.celebrity);
        if (simpleCelebrity.getType()==1)
            viewHolder.celebrity.setTagText("导演");
        else if (simpleCelebrity.getType()==2)
            viewHolder.celebrity.setTagText("主演");
        viewHolder.name.setText(simpleCelebrity.getName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //Toast.makeText(context,context.getResources().getString(R.string.click)+(i+1), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return simpleCelebrityList.size();
    }

    class SimpleCelebrityHolder extends RecyclerView.ViewHolder {
        public SimpleTagImageView celebrity;
        public TextView name;

        public SimpleCelebrityHolder(View itemView) {
            super(itemView);
            celebrity = (SimpleTagImageView) itemView.findViewById(R.id.celebrity);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
