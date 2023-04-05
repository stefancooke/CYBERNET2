

package com.example.cybernet;


        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

        import com.google.firebase.auth.FirebaseAuth;

public class ScoreActivity extends AppCompatActivity {

    private TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTextView = findViewById(R.id.score_textview);

        // Get the score and question length from the Intent

        // Display the score
        Intent intent = getIntent();
        int score = intent.getIntExtra("SCORE_KEY", 0);
        int numQuestions = intent.getIntExtra("NumQuestions", 0);


        String scoreText = "You scored " + score + " out of " + numQuestions;
        scoreTextView.setText(scoreText);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Quizzes.class);
        startActivity(intent);
        finish();
    }










}

