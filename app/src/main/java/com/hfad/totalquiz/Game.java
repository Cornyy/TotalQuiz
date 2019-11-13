package com.hfad.totalquiz;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class Game
{
    private int category;
    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<Answer> answers = new ArrayList<>();
    private DBConnect db;
    int questionNumber;


    public Game(int Category,DBConnect data)
    {
       this.category = Category;
       db = data;
    }
    public String drawQuestion()
    {
        SQLiteDatabase dbR = db.getReadableDatabase();
        Cursor cursor = dbR.query(DBConnect.questionsTableKey,new String[]{DBConnect.contentKey},
                DBConnect.categoryIdKey + " = ?",new String[]{Integer.toString(category)},null,null,null);

            while (cursor.moveToNext()) {
                questions.add(cursor.getString(cursor.getColumnIndex(DBConnect.contentKey)));
            }

        Random random = new Random();
            questionNumber = random.nextInt(questions.size());
        dbR.close();
        return questions.get(questionNumber);

    }
    public ArrayList<Answer> getAnswers(String question)
    {
        SQLiteDatabase dbR = db.getReadableDatabase();

        String rawQuery = "SELECT firstBad,secondBad,thirdBad,trueAnswer FROM " + DBConnect.questionsTableKey + " a INNER JOIN " + DBConnect.answersTableKey
                + " b ON a.answerId = b.id" + " WHERE a.content = '" + question + "'";
        Cursor c = dbR.rawQuery(rawQuery,null);
        while (c.moveToNext())
        {
            for(int i = 0;i<4;i++)
            {
                if(i!=3) {
                    answers.add(new Answer(false, c.getString(i)));
                }
                else
                {
                    answers.add(new Answer(true, c.getString(i)));
                }
            }
        }
        return answers;
    }

}
