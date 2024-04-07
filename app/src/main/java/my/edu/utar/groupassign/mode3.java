package my.edu.utar.groupassign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class mode3 extends AppCompatActivity {

    private mode3_1[] quizQuestions;
    private TextView textQues;
    private ImageView quesImage;
    private TextView[] choice;

    private int currQues = 0;
    private int correctAnswers = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode3_main);

        textQues = findViewById(R.id.textQues);
        quesImage = findViewById(R.id.quesImage);

        choice = new TextView[4]; // Initialize the choice array

        choice[0] = findViewById(R.id.Ans1);
        choice[1] = findViewById(R.id.Ans2);
        choice[2] = findViewById(R.id.Ans3);
        choice[3] = findViewById(R.id.Ans4);

        // Set OnClickListener for each choice TextView
        for (int i = 0; i < choice.length; i++) {
            final int finalI = i;
            choice[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onOptionClick(finalI);
                }
            });
        }

        quizQuestions = new mode3_1[]{
                new mode3_1("What is the traditional Japanese garment worn for formal occasions?",
                        new String[]{"Lederhosen","Sari", "Hanbok", "Kimono" },
                        3, R.drawable.kimono),
                new mode3_1("Which Japanese city is famous for its cherry blossom festival?",
                        new String[]{"Tokyo", "Kyoto", "Osaka", "Hiroshima"},
                        1, R.drawable.kyoto),

                new mode3_1("Which Mexican holiday celebrates the Day of the Dead?",
                        new String[]{"Cinco de Mayo", "Día de la Independencia", "Dia de los Muertos", "Las Posadas"},
                        2, R.drawable.coco),

                new mode3_1("What is the traditional Brazilian dance characterized by its fast-paced rhythm and colorful costumes?",
                        new String[]{"Tango", "Flamenco", "Rumba", "Samba"},
                        3, R.drawable.samba),

                new mode3_1("Which Brazilian city hosts the famous Carnival festival?",
                        new String[]{"Salvador", "Rio de Janeiro", "São Paulo", "Recife"},
                        1, R.drawable.rio),

                new mode3_1("What is the famous ancient Egyptian structure with a lion's body and a human head?",
                        new String[]{"Great Sphinx of Giza", "Pyramids of Giza", "Karnak Temple", "Luxor Temple"},
                        0, R.drawable.eygpt),

                new mode3_1("What is the traditional name for a Mexican bullfighting arena?",
                        new String[]{"Plaza de Toros", "Corrida de Toros", "Matador Arena", "Torero Plaza"},
                        0, R.drawable.bull),

                new mode3_1("What is the traditional food of Japan made from fermented soybeans?",
                        new String[]{"Sushi", "Natto", "Ramen", "Tempura"},
                        1, R.drawable.natto),

                new mode3_1("Which festival in India is known for its colorful celebration of spring and the triumph of good over evil?",
                        new String[]{"Diwali", "Navratri", "Holi", "Eid"},
                        2, R.drawable.holi),

                new mode3_1("What is the traditional Korean dress called?",
                        new String[]{"Yukata", "Cheongsam", "Ao Dai", "Hanbok"},
                        3, R.drawable.hanbok)

        };

        displayQuestion(currQues);

    }

    private void displayQuestion(int getQuestion) {
        mode3_1 currQues = quizQuestions[getQuestion];
        textQues.setText(currQues.getQuestion());
        quesImage.setImageResource(currQues.getImageId());

        String[] options = currQues.getOptions();
        for (int i = 0; i < options.length; i++) {
            choice[i].setText(options[i]);
        }
    }

    public void onOptionClick(int selectedOption) {
        int correctOption = quizQuestions[currQues].getCorrectAns();
        if (selectedOption == correctOption) {
            correctAnswers++;
        }
        nextQuestion();
    }

    private void nextQuestion() {
        currQues++;

        if (currQues < quizQuestions.length) {
            displayQuestion(currQues);
        } else {
            endQuiz();
        }
    }

    private void endQuiz() {
        Toast.makeText(this, "Hooray! You have answered all questions", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("score",correctAnswers);
        startActivity(intent);
    }
}



