package com.example.onlinelibary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecViewAdapter extends RecyclerView.Adapter<BooksRecViewAdapter.ViewHolder>{

    private ArrayList<Book> books=new ArrayList<>();
    private Context context;

    public BooksRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_books_rec_view,null);
        ViewHolder holeder=new ViewHolder(view);
        return holeder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.bookNmae.setText(books.get(position).getName());

        holder.bookNmae.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,BookActivity.class);
                intent.putExtra("bookId",books.get(position).getId());
                context.startActivity(intent);
            }
        });
        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageURL())
                .into(holder.bookImage);

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView bookImage;
        private TextView bookNmae;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookImage=(ImageView) itemView.findViewById(R.id.bookImageId);
            bookNmae=(TextView) itemView.findViewById(R.id.bookNameId);
        }
    }

    public void setBooks(ArrayList<Book> books){
        this.books=books;
        notifyDataSetChanged();
    }
}
