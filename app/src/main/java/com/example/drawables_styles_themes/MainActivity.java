package com.example.drawables_styles_themes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//TODO: Task 4: Themes and Final Touches
//https://google-developer-training.github.io/android-developer-fundamentals-course-practicals/en/Unit%202/51_p_themes,_custom_styles,_drawables.html?q=
public class MainActivity extends AppCompatActivity {

    private int scoreT1 = 0, scoreT2 = 0;
    private TextView textViewScoreT1, textViewScoreT2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewScoreT1 = findViewById(R.id.team1_score);
        textViewScoreT2 = findViewById(R.id.team2_score);

    }


    public void decreaseScore(View view) {
        //Get the ID of the button that was clicked
        switch (view.getId()){
            //Team 1
            case R.id.minus_team1:
                //Decrement the score and update the TextView
                scoreT1--;
                textViewScoreT1.setText(String.valueOf(scoreT1));
                break;
            //Team 2
            case R.id.minus_team2:
                //Decrement the score and update the TextView
                scoreT2--;
                textViewScoreT2.setText(String.valueOf(scoreT2));
        }
    }


    public void increaseScore(View view) {
        //Get the ID of the button that was clicked
        switch (view.getId()){
            //Team 1
            case R.id.plus_team1:
                //Increment the score and update the TextView
                scoreT1++;
                textViewScoreT1.setText(String.valueOf(scoreT1));
                break;
            //Team 2
            case R.id.plus_team2:
                //Increment the score and update the TextView
                scoreT2++;
                textViewScoreT2.setText(String.valueOf(scoreT2));
        }
    }
}