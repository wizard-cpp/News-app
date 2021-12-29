package com.example.newsnow;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private OnNoteListner myOnNoteListenr;
    private List<ModelClass> userList;


    public Adapter (List<ModelClass>userList,OnNoteListner onNoteListner){this.userList=userList;
    this.myOnNoteListenr=onNoteListner;}
    @NonNull

    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return  new ViewHolder(view,myOnNoteListenr);
    }

    @Override
    public void onBindViewHolder(@NonNull  Adapter.ViewHolder holder, int position) {
     Bitmap resource= userList.get(position).getImageView1();
     String title=userList.get(position).getTextview1();

     holder.setData(resource,title);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imageView;
        private TextView textView;
        OnNoteListner onNoteListner;

        public ViewHolder(@NonNull  View itemView,OnNoteListner onNoteListner) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
             this.onNoteListner=onNoteListner;



        }


        public void setData(Bitmap resource, String title) {
            new Thread(new Runnable() {
                public void run() {
                    imageView.post(new Runnable() {
                        public void run() {
                            imageView.setImageBitmap(resource);
                        }
                    });
                }
            }).start();

            textView.setText(title);
        }

        @Override
        public void onClick(View view) {
            onNoteListner.onNoteClick(getAdapterPosition());

        }
    }
    public interface OnNoteListner{
        void onNoteClick(int position);       }
}
