package com.hfad.totalquiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity
{
    private String Category = "";
    private Game game;
    TextView textViewQuestion;
    public static final String Category_Number = "CategoryNumber";
    private ArrayList<Answer> answers = new ArrayList<>();
    DBConnect dbConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        textViewQuestion = (TextView) findViewById(R.id.QuestionField);
       dbConnect = new DBConnect(getApplicationContext(),DBConnect.DBName,null,DBConnect.DBVersion);
        createGame();
    }

    private void createGame()
    {
        int categoryNumber = getIntent().getIntExtra(Category_Number,0);
        if(categoryNumber == 1)
        {
            game = new Game(1,dbConnect);
        }
        else if(categoryNumber == 2)
        {
            game = new Game(2,dbConnect);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Błąd w tworzeniu gry",Toast.LENGTH_SHORT).show();
            finish();
        }
        String question = game.drawQuestion();
       textViewQuestion.setText(question);
        answers = game.getAnswers(question);
        setAnswers();
    }
    private void setAnswers()
    {
        Button firstAnswer = (Button)findViewById(R.id.buttonFirstAnswer);
        Button secondAnswer = (Button)findViewById(R.id.buttonSecondAnswer);
        Button thirdAnswer = (Button)findViewById(R.id.buttonThirdAnswer);
        Button fourthAnswer = (Button)findViewById(R.id.buttonFourthAnswer);

        Collections.shuffle(answers);

        answers.get(0).setAnswerToButton(firstAnswer);
        answers.get(1).setAnswerToButton(secondAnswer);
        answers.get(2).setAnswerToButton(thirdAnswer);
        answers.get(3).setAnswerToButton(fourthAnswer);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void buttonCheckAnswerOnClick(View view)
    {
        Button button = (Button)view;
         for(int i = 0;i<4;i++)
         {
             if(answers.get(i).getContent() == button.getText())
             {
                 if(answers.get(i).getIfTrue()==true)
                 {
                     button.setBackgroundColor(getColor(R.color.colorTrue));
                     blockButtons();
                     showTrueOrFalseMessage("Dobrze!");
                 }
                 else
                 {
                     button.setBackgroundColor(getColor(R.color.colorFalse));
                     getTrueAnswer();
                     blockButtons();
                     showTrueOrFalseMessage("Źle!");
                 }
             }
         }
    }
    private void blockButtons()
    {
        for(int i = 0;i<4;i++)
        {
            answers.get(i).getButton().setClickable(false);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getTrueAnswer()
    {
        for(int i = 0;i<4;i++)
        {
            if(answers.get(i).getIfTrue()==true)
            {
                answers.get(i).getButton().setBackgroundColor(getColor(R.color.colorTrue));
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showTrueOrFalseMessage(String message)
    {
        TextView textView = (TextView) findViewById(R.id.goodOrFalseField);
        if (message == "Źle!")
        {
            textView.setTextColor(getColor(R.color.colorFalse));
            textView.setText(message);
        }
        else
        {
            textView.setTextColor(getColor(R.color.colorTrue));
            textView.setText(message);
        }
        textView.setVisibility(View.VISIBLE);
        showBackButton();
    }
    private void showBackButton()
    {
        Button button = (Button)findViewById(R.id.buttonBackFromGame);
        button.setVisibility(View.VISIBLE);
    }

    public void buttonBackFromGameOnClick(View view)
    {
        finish();
    }
}
