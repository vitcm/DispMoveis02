package com.example.dispmoveis02;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String fruitName = getIntent().getStringExtra("fruitName");
        int fruitImageId = getIntent().getIntExtra("fruitImageId", 0);

        TextView textViewTitle = findViewById(R.id.text_fruit_title);
        textViewTitle.setText(fruitName);

        ImageView imageViewFruit = findViewById(R.id.image_fruit);
        imageViewFruit.setImageResource(fruitImageId);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}