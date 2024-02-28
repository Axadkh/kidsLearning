package com.ali.kidslearing.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ali.kidslearing.R;

import java.util.List;
import java.util.Random;


public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.MyViewHolder> {

    private List<String> data; // Assuming your data is a list of strings

    private Context context;


    public QuizAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.quiz_layout, parent, false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String item = data.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title,score;
        private TextView textView;

        public MyViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.title);
            score = v.findViewById(R.id.score);

        }

        @SuppressLint("UseCompatLoadingForDrawables")
        public void bind(String item) {
            int index = getAdapterPosition()+1;
            title.setText("Quiz"+index);
            score.setText(item);

        }
    }


}

