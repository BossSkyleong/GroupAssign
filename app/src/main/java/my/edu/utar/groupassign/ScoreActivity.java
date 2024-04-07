package my.edu.utar.groupassign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        int correctAns = getIntent().getIntExtra("score",0);

        int totalScore = correctAns * 100;

        TextView scoreTextView = findViewById(R.id.score);
        scoreTextView.setText(String.valueOf(totalScore));
    }
}