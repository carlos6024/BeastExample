package com.example.ceval.beastexample1.views.MeetABroViews;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ceval.beastexample1.R;
import com.example.ceval.beastexample1.activites.BaseActivity;
import com.example.ceval.beastexample1.entites.Brother;

import java.util.ArrayList;

public class BrotherAdapter extends RecyclerView.Adapter<BrotherViewHolder> implements View.OnClickListener {

    private LayoutInflater layoutInflater;
    private BaseActivity activity;
    private onBrotherClickedListener listener;
    private ArrayList<Brother> brothers;


    public BrotherAdapter(onBrotherClickedListener listener, BaseActivity activity) {
        this.listener = listener;
        this.activity = activity;
        layoutInflater = activity.getLayoutInflater();
        brothers = new ArrayList<>();
    }

    public ArrayList<Brother> getBrothers() {
        return brothers;
    }

    @Override
    public BrotherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_brothers_display,parent,false);
        view.setOnClickListener(this);
        return new BrotherViewHolder(view);

    }

    @Override
    public void onBindViewHolder(BrotherViewHolder holder, int position) {
        holder.populate(activity,brothers.get(position));
    }

    @Override
    public int getItemCount() {
        return brothers.size();
    }

    @Override
    public void onClick(View view) {
        if(view.getTag() instanceof  Brother){
            Brother brother = (Brother) view.getTag();
            listener.onBrotherClicked(brother);
        }

    }

    public interface onBrotherClickedListener{
        void onBrotherClicked(Brother brother);
    }
}
