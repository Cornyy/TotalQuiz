package com.hfad.totalquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnect extends SQLiteOpenHelper
{
    public static final int DBVersion = 1;
    public static final String DBName = "TotalQuizTest9c.db";
    public static final String idKey = "id";
    public static final String firstBadKey = "firstBad";
    public static final String secondBadKey = "secondBad";
    public static final String thirdBadKey = "thirdBad ";
    public static final String trueKey = "trueAnswer";
    public static final String nameKey = "name";
    public static final String contentKey = "content";
    public static final String categoryIdKey = "categoryId";
    public static final String answerIdKey = "answerId";
    public static final String answersTableKey = "answers";
    public static final String categoriesTableKey = "categories";
    public static final String questionsTableKey = "questions";
    private static final String createTableCategories = "create table " + categoriesTableKey +
            "( "+ idKey + " integer primary key autoincrement," +
             nameKey +" text not null)";
    private static final String createTableQuestions = "create table " + questionsTableKey +
            "( "+ idKey + " integer primary key autoincrement," +
            contentKey +" text not null," +
            categoryIdKey + " integer not null," +
            answerIdKey + " integer not null," +
            "foreign key( " + answerIdKey + ") references "+ answersTableKey+ "( "+idKey+")," +
            "foreign key( " + categoryIdKey + ") references "+ categoriesTableKey + "( "+idKey+ "))";

    private static final String createTableAnswers= "create table " + answersTableKey +
            "( "+ idKey + " integer primary key autoincrement," +
            firstBadKey + " text not null," +
            secondBadKey + " text not null," +
            thirdBadKey + " text not null," +
            trueKey + " text not null" +
            ")";

    public DBConnect(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }


    public void setDefault(SQLiteDatabase db)
    {

            ContentValues valueCategory1 = new ContentValues();
            ContentValues valueCategory2 = new ContentValues();
            valueCategory1.put(nameKey,"Sport");
            valueCategory2.put(nameKey,"Muzyka");
            ContentValues valueAnswers1  = new ContentValues();
            ContentValues valueAnswers2  = new ContentValues();
            ContentValues valueAnswers3  = new ContentValues();
            ContentValues valueAnswers4  = new ContentValues();
            ContentValues valueAnswers5  = new ContentValues();
            ContentValues valueAnswers6  = new ContentValues();
            ContentValues valueAnswers7  = new ContentValues();
            ContentValues valueAnswers8  = new ContentValues();
            ContentValues valueAnswers9  = new ContentValues();
            ContentValues valueAnswers10  = new ContentValues();
            valueAnswers1.put(firstBadKey,"Real Madrit");
            valueAnswers1.put(secondBadKey,"Manchester United");
            valueAnswers1.put(thirdBadKey,"FC Barcelona");
            valueAnswers1.put(trueKey,"Bayern Monachium");
            valueAnswers2.put(firstBadKey,"Bajm");
            valueAnswers2 .put(secondBadKey,"Ewelina Lisowska");
            valueAnswers2 .put(thirdBadKey,"Doda");
            valueAnswers2 .put(trueKey,"Perfect");
            valueAnswers3 .put(firstBadKey,"Piłka nożna");
            valueAnswers3 .put(secondBadKey,"Rzut młotem");
            valueAnswers3 .put(thirdBadKey,"Siatkówka");
            valueAnswers3 .put(trueKey,"Pływanie");
            valueAnswers4 .put(firstBadKey,"One Direction");
            valueAnswers4 .put(secondBadKey,"Green Day");
            valueAnswers4 .put(thirdBadKey,"Scorpions");
            valueAnswers4 .put(trueKey,"The Beatles");
            valueAnswers5 .put(firstBadKey,"1996");
            valueAnswers5 .put(secondBadKey,"2012");
            valueAnswers5 .put(thirdBadKey,"2004");
            valueAnswers5 .put(trueKey,"2008");
            valueAnswers6 .put(firstBadKey,"na fortepianie");
            valueAnswers6 .put(secondBadKey,"na gitarze");
            valueAnswers6 .put(thirdBadKey,"na trąbce");
            valueAnswers6 .put(trueKey,"na akordeonie");
            valueAnswers7 .put(firstBadKey,"Ewa Farna");
            valueAnswers7 .put(secondBadKey,"Margharet");
            valueAnswers7 .put(thirdBadKey,"Ewelina Lisowska");
            valueAnswers7 .put(trueKey,"Sylwia Grzeszczak");
            valueAnswers8 .put(firstBadKey,"sześć");
            valueAnswers8 .put(secondBadKey,"jeden");
            valueAnswers8 .put(thirdBadKey,"zero");
            valueAnswers8 .put(trueKey,"cztery");
            valueAnswers9 .put(firstBadKey,"Austrii");
            valueAnswers9 .put(secondBadKey,"Francji");
            valueAnswers9 .put(thirdBadKey,"Portugalii");
            valueAnswers9 .put(trueKey,"Hiszpanii");
            valueAnswers10 .put(firstBadKey,"z żoną");
            valueAnswers10 .put(secondBadKey,"z matką");
            valueAnswers10 .put(thirdBadKey,"ze szwagrem");
            valueAnswers10 .put(trueKey,"z dziewczyną");

            ContentValues valueQuestions1  = new ContentValues();
            ContentValues valueQuestions2  = new ContentValues();
            ContentValues valueQuestions3  = new ContentValues();
            ContentValues valueQuestions4  = new ContentValues();
            ContentValues valueQuestions5  = new ContentValues();
            ContentValues valueQuestions6  = new ContentValues();
            ContentValues valueQuestions7  = new ContentValues();
            ContentValues valueQuestions8  = new ContentValues();
            ContentValues valueQuestions9  = new ContentValues();
            ContentValues valueQuestions10  = new ContentValues();
            valueQuestions1.put(contentKey,"W jakim klubie gra Robert Lewandowski?");
            valueQuestions1.put(categoryIdKey,1);
            valueQuestions1.put(answerIdKey,1);
            valueQuestions2.put(contentKey, "Kto napisał piosenkę \"nie płacz ewka\"?");
            valueQuestions2.put(categoryIdKey,2);
            valueQuestions2.put(answerIdKey,2);
            valueQuestions3.put(contentKey,"Z jakiej dyscypliny słynie Otylia Jędrzejczak?");
            valueQuestions3.put(categoryIdKey,1);
            valueQuestions3.put(answerIdKey,3);
            valueQuestions4.put(contentKey,"Do jakiego zespołu nalezał Paul McCartney?");
            valueQuestions4.put(categoryIdKey,2);
            valueQuestions4.put(answerIdKey,4);
            valueQuestions5.put(contentKey,"Austria i Szwajcaria były gospodarzami Mistrzostw Europy w piłce nożnej w roku... ?");
            valueQuestions5.put(categoryIdKey,1);
            valueQuestions5.put(answerIdKey,5);
            valueQuestions6.put(contentKey,"Z gry, na jakim instrumencie słynie Czesław Mozil?");
            valueQuestions6.put(categoryIdKey,2);
            valueQuestions6.put(answerIdKey,6);
            valueQuestions7.put(contentKey,"Najlepszą artystką 2012 roku na Eska Music Awards została...?");
            valueQuestions7.put(categoryIdKey,2);
            valueQuestions7.put(answerIdKey,7);
            valueQuestions8.put(contentKey,"Ile razy zespół San Antonio Spurs zdobywał tytuł mistrza ligi NBA ?");
            valueQuestions8.put(categoryIdKey,1);
            valueQuestions8.put(answerIdKey,8);
            valueQuestions9.put(contentKey,"Walka z bykami jest narodowym sportem w...?");
            valueQuestions9.put(categoryIdKey,1);
            valueQuestions9.put(answerIdKey,9);
            valueQuestions10.put(contentKey,"Z kim Sydney Polak w swoim utworze Otwiera Wino?");
            valueQuestions10.put(categoryIdKey,2);
            valueQuestions10.put(answerIdKey,10);
            db.insert(categoriesTableKey,null,valueCategory1);
            db.insert(categoriesTableKey,null,valueCategory2);
            db.insert(answersTableKey,null,valueAnswers1);
            db.insert(answersTableKey,null,valueAnswers2);
            db.insert(answersTableKey,null,valueAnswers3);
            db.insert(answersTableKey,null,valueAnswers4);
            db.insert(answersTableKey,null,valueAnswers5);
            db.insert(answersTableKey,null,valueAnswers6);
            db.insert(answersTableKey,null,valueAnswers7);
            db.insert(answersTableKey,null,valueAnswers8);
            db.insert(answersTableKey,null,valueAnswers9);
            db.insert(answersTableKey,null,valueAnswers10);
            db.insert(questionsTableKey,null,valueQuestions1);
            db.insert(questionsTableKey,null,valueQuestions2);
            db.insert(questionsTableKey,null,valueQuestions3);
            db.insert(questionsTableKey,null,valueQuestions4);
            db.insert(questionsTableKey,null,valueQuestions5);
            db.insert(questionsTableKey,null,valueQuestions6);
            db.insert(questionsTableKey,null,valueQuestions7);
            db.insert(questionsTableKey,null,valueQuestions8);
            db.insert(questionsTableKey,null,valueQuestions9);
            db.insert(questionsTableKey,null,valueQuestions10);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableCategories);
        db.execSQL(createTableAnswers);
        db.execSQL(createTableQuestions);
        setDefault(db);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
