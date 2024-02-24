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

public class ExcriseAdapter extends RecyclerView.Adapter<ExcriseAdapter.MyViewHolder> {

    private List<ExcriseModel> data; // Assuming your data is a list of strings

    private OnItemClickListener onItemClickListener;
    private Context context;

    public ExcriseAdapter(Context context, List<ExcriseModel> data,OnItemClickListener onItemClickListener) {
        this.context = context;
        this.data = data;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_excrise, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ExcriseModel item = data.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private boolean isClicked = false;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView no1,symbol,no2,ans1,ans2,ans3;
        private TextView textView;

        public MyViewHolder(View v) {
            super(v);
            no1 = v.findViewById(R.id.no1);
            symbol = v.findViewById(R.id.symbol);
            no2 = v.findViewById(R.id.no2);
            ans1 = v.findViewById(R.id.ans1);
            ans2 = v.findViewById(R.id.ans2);
            ans3 = v.findViewById(R.id.ans3);
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        public void bind(ExcriseModel item) {

            no1.setImageDrawable(itemView.getContext().getDrawable(item.getNo1()));
            symbol.setImageDrawable(itemView.getContext().getDrawable(item.getSymbol()));
            no2.setImageDrawable(itemView.getContext().getDrawable(item.getNo2()));
            ans1.setImageDrawable(itemView.getContext().getDrawable(item.getAns().getAns1()));
            ans2.setImageDrawable(itemView.getContext().getDrawable(item.getAns().getAns2()));
            ans3.setImageDrawable(itemView.getContext().getDrawable(item.getAns().getAns3()));
            ans1.setBackgroundDrawable(itemView.getContext().getDrawable(getRandomBorder()));
            ans2.setBackgroundDrawable(itemView.getContext().getDrawable(getRandomBorder()));
            ans3.setBackgroundDrawable(itemView.getContext().getDrawable(getRandomBorder()));

            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition() != RecyclerView.NO_POSITION) {
                        onItemClickListener.onItemClick(item.getAns().getAns1() == item.getAns().getCorrect());
                    }
                }
            });


            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition() != RecyclerView.NO_POSITION) {
                        onItemClickListener.onItemClick(item.getAns().getAns2() == item.getAns().getCorrect());
                    }
                }
            });


            ans3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(getAdapterPosition() != RecyclerView.NO_POSITION) {
                        onItemClickListener.onItemClick(item.getAns().getAns3() == item.getAns().getCorrect());
                    }
                }
            });
        }
    }


    public static int getRandomBorder() {
        int[] staticIntArray = {R.drawable.red_border, R.drawable.blue_border, R.drawable.green_border};
        Random random = new Random();
        int randomIndex = random.nextInt(staticIntArray.length); // Generates a random index
        return staticIntArray[randomIndex];
    }
}

