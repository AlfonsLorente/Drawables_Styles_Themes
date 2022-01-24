package com.example.drawables_styles_themes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

//TODO: Task 4.3: Themes and Final Touches
//https://google-developer-training.github.io/android-developer-fundamentals-course-practicals/en/Unit%202/51_p_themes,_custom_styles,_drawables.html?q=
public class MainActivity extends AppCompatActivity {
    static final String STATE_SCORE_1 = "Team 1 score";
    static final String STATE_SCORE_2 = "Team 2 score";

    private int scoreT1 = 0, scoreT2 = 0;
    private TextView textViewScoreT1, textViewScoreT2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewScoreT1 = findViewById(R.id.team1_score);
        textViewScoreT2 = findViewById(R.id.team2_score);
        if (savedInstanceState != null) {
            scoreT1 = savedInstanceState.getInt(STATE_SCORE_1);
            scoreT2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            textViewScoreT1.setText(String.valueOf(scoreT1));
            textViewScoreT2.setText(String.valueOf(scoreT2));
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Check if the correct item was clicked
        if(item.getItemId()==R.id.night_mode){}
        //Get the night mode state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        //Set the theme mode for the restarted activity
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        recreate();

        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        //Save the scores
        bundle.putInt(STATE_SCORE_1, scoreT1);
        bundle.putInt(STATE_SCORE_2, scoreT2);
        super.onSaveInstanceState(bundle);
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