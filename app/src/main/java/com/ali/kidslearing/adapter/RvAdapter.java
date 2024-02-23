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

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

    private List<MathModel> data; // Assuming your data is a list of strings
    private Context context;

    public RvAdapter(Context context, List<MathModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MathModel item = data.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView no1,symbol,no2,ans;
        private TextView textView;

        public MyViewHolder(View v) {
            super(v);
            no1 = v.findViewById(R.id.no1);
            symbol = v.findViewById(R.id.symbol);
            no2 = v.findViewById(R.id.no2);
            ans = v.findViewById(R.id.ans);
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        public void bind(MathModel item) {

            no1.setImageDrawable(itemView.getContext().getDrawable(item.getNo1()));
            symbol.setImageDrawable(itemView.getContext().getDrawable(item.getSymbol()));
            no2.setImageDrawable(itemView.getContext().getDrawable(item.getNo2()));
            ans.setImageDrawable(itemView.getContext().getDrawable(item.getAns()));


        }
    }
}

