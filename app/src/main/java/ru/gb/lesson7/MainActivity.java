package ru.gb.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FirstFragment.Controller{

    protected Button firstFragmentStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragmentStartButton = findViewById(R.id.start_first_fragment);

        firstFragmentStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.first_fragment_holder, new FirstFragment())
                        .addToBackStack("First transaction")
                        .commit();
            }
        });

    }

    @Override
    public void startButtonPressed(String message) {
        getSupportFragmentManager()
                .beginTransaction()
                // .add(R.id.second_fragment_holder, new SecondFragment())
                .add(R.id.second_fragment_holder, SecondFragment.getInstance(message))
                .addToBackStack(null)
                .commit();
    }
}