package com.example.dispmoveis02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Fruta> frutas = new ArrayList<>();
        frutas.add(new Fruta("Maçã", R.drawable.maca));
        frutas.add(new Fruta("Banana", R.drawable.banana));
        frutas.add(new Fruta("Pitaya", R.drawable.pitaya));
        frutas.add(new Fruta("Morango", R.drawable.morango));

        fruitAdapter = new FruitAdapter(this, frutas);
        recyclerView.setAdapter(fruitAdapter);

        fruitAdapter.setOnItemClickListener(new FruitAdapter.OnItemClickListener() {
            public void onItemClick(String fruitName, int fruitImageId) {
                Toast.makeText(MainActivity.this, "Fruta selecionada: " + fruitName, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("fruitName", fruitName);
                intent.putExtra("fruitImageId", fruitImageId);
                startActivity(intent);
            }
        });
    }
}