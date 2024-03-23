package com.example.dispmoveis02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruta> fruits;
    private Context context;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String fruitName, int imageResourceId);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public FruitAdapter(Context context, List<Fruta> fruits) {
        this.context = context;
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fruta, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruta fruit = fruits.get(position);
        holder.bind(fruit);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(fruit.getName(), fruit.getImageResourceId()); // Passa o ID da imagem
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_fruit_name);
            imageView = itemView.findViewById(R.id.image_fruit);

            // Define o clique do item
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        Fruta fruit = fruits.get(position);
                        listener.onItemClick(fruit.getName(), fruit.getImageResourceId());
                    }
                }
            });
        }

        public void bind(Fruta fruit) {
            textViewName.setText(fruit.getName());
            imageView.setImageResource(fruit.getImageResourceId());
        }
    }
}