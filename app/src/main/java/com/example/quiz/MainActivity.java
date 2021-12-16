package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tvCategory;
    private Button btQuestion;
    private Button btAnswer1;
    private Button btAnswer2;
    private Button btAnswer3;
    private Button btAnswer4;
    private Button btProgress1;
    private Button btProgress2;
    private Button btProgress3;
    private Button btProgress4;
    private Button btProgress5;
    private Button btContinue;

    private List<String> answers;
    private QuizQuestion question;
    private int questionStatus = 0;
    private String category = "";
    QuestionPool questionPool = new QuestionPool();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        tvCategory = findViewById(R.id.tvCategory);
        btQuestion = findViewById(R.id.btQuestion);
        btAnswer1 = findViewById(R.id.btAnswer1);
        btAnswer2 = findViewById(R.id.btAnswer2);
        btAnswer3 = findViewById(R.id.btAnswer3);
        btAnswer4 = findViewById(R.id.btAnswer4);
        btProgress1 = findViewById(R.id.btProgress1);
        btProgress2 = findViewById(R.id.btProgress2);
        btProgress3 = findViewById(R.id.btProgress3);
        btProgress4 = findViewById(R.id.btProgress4);
        btProgress5 = findViewById(R.id.btProgress5);
        btContinue = findViewById(R.id.btContinue);

        btQuestion.setOnClickListener(v -> onDisplayQuestion(v));
        btContinue.setOnClickListener(v -> onContinue(v));

        OnClick click = new OnClick();

        btAnswer1.setOnClickListener(click);
        btAnswer2.setOnClickListener(click);
        btAnswer3.setOnClickListener(click);
        btAnswer4.setOnClickListener(click);
    }

    public void onDisplayQuestion(View v){
        btQuestion.setEnabled(false);
        if(questionStatus == 0){
            category = questionPool.getRandomCategory();

        }
        tvCategory.setText("Category: "+ category);
        List<QuizQuestion> questions = questionPool.getQuestionsByCategory(category);

            question = questions.get(questionStatus);
            answers = question.getAnswers();

            btQuestion.setText(question.getQuestion());
            btAnswer1.setText(answers.get(0));
            btAnswer2.setText(answers.get(1));
            btAnswer3.setText(answers.get(2));
            btAnswer4.setText(answers.get(3));

    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            onAnswerClick(view);
        }
    }

    public void onAnswerClick(View v){
        Button userAnswer = (Button) findViewById(v.getId());

        btContinue.setEnabled(true);
        btAnswer1.setEnabled(false);
        btAnswer2.setEnabled(false);
        btAnswer3.setEnabled(false);
        btAnswer4.setEnabled(false);

        if(userAnswer.getText().toString() == answers.get(question.getCorrectAnswer())){
            ViewCompat.setBackgroundTintList(userAnswer, ColorStateList.valueOf(Color.GREEN));
            switch (questionStatus){
                case 0: ViewCompat.setBackgroundTintList(btProgress1, ColorStateList.valueOf(Color.GREEN));break;
                case 1: ViewCompat.setBackgroundTintList(btProgress2, ColorStateList.valueOf(Color.GREEN));break;
                case 2: ViewCompat.setBackgroundTintList(btProgress3, ColorStateList.valueOf(Color.GREEN));break;
                case 3: ViewCompat.setBackgroundTintList(btProgress4, ColorStateList.valueOf(Color.GREEN));break;
                case 4: ViewCompat.setBackgroundTintList(btProgress5, ColorStateList.valueOf(Color.GREEN));break;
                default: break;
            }

        }else{
            ViewCompat.setBackgroundTintList(userAnswer, ColorStateList.valueOf(Color.RED));
            switch (questionStatus){
                case 0:ViewCompat.setBackgroundTintList(btProgress1, ColorStateList.valueOf(Color.RED));break;
                case 1:ViewCompat.setBackgroundTintList(btProgress2, ColorStateList.valueOf(Color.RED));break;
                case 2:ViewCompat.setBackgroundTintList(btProgress3, ColorStateList.valueOf(Color.RED));break;
                case 3:ViewCompat.setBackgroundTintList(btProgress4, ColorStateList.valueOf(Color.RED));break;
                case 4:ViewCompat.setBackgroundTintList(btProgress5, ColorStateList.valueOf(Color.RED));break;
                default: break;
            }
        }

    }

    public void onContinue(View v){

        ViewCompat.setBackgroundTintList(btAnswer1, ColorStateList.valueOf(Color.BLACK));
        ViewCompat.setBackgroundTintList(btAnswer2, ColorStateList.valueOf(Color.BLACK));
        ViewCompat.setBackgroundTintList(btAnswer3, ColorStateList.valueOf(Color.BLACK));
        ViewCompat.setBackgroundTintList(btAnswer4, ColorStateList.valueOf(Color.BLACK));
        btAnswer1.setEnabled(true);
        btAnswer2.setEnabled(true);
        btAnswer3.setEnabled(true);
        btAnswer4.setEnabled(true);

        if(questionStatus >= 4)
        {
            //category = questionPool.getRandomCategory();
            questionStatus = 0;
            btQuestion.setEnabled(true);
            category = questionPool.getRandomCategory();
            ViewCompat.setBackgroundTintList(btProgress1, ColorStateList.valueOf(Color.BLACK));
            ViewCompat.setBackgroundTintList(btProgress2, ColorStateList.valueOf(Color.BLACK));
            ViewCompat.setBackgroundTintList(btProgress3, ColorStateList.valueOf(Color.BLACK));
            ViewCompat.setBackgroundTintList(btProgress4, ColorStateList.valueOf(Color.BLACK));
            ViewCompat.setBackgroundTintList(btProgress5, ColorStateList.valueOf(Color.BLACK));

        }else{
            questionStatus++;
        }
        btContinue.setEnabled(false);
        onDisplayQuestion(v);
    }

}