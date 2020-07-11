package com.muneiah.roomdatabase;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ctx;
    List<Student_Entity> list;

    public MyAdapter(Context ctx, List<Student_Entity> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.row_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.n.setText(list.get(position).getName());
        holder.r.setText(list.get(position).getRollNumber());
        holder.d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // MainActivity.dataBase.studentDAO().deleteData(list.get(position)); //normal db
                //live db
                MainActivity.myViewModel.delete(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView n,r,e,d;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            n=itemView.findViewById(R.id.nam);
            r=itemView.findViewById(R.id.rollnam);
            e=itemView.findViewById(R.id.edit);
            d=itemView.findViewById(R.id.delete);
            e.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nn=n.getText().toString();
                    String rr=r.getText().toString();
                    Intent i=new Intent(ctx,UpdateActivity.class);
                    i.putExtra("name",nn);
                    i.putExtra("roll",rr);
                    ctx.startActivity(i);

                }
            });

        }
    }
}
