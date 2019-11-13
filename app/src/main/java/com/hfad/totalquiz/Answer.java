package com.hfad.totalquiz;

import android.widget.Button;

public class Answer
{
    private String content;
    private Boolean isTrue;
    private Button button;

    public Answer(Boolean bool,String c)
    {
        isTrue = bool;
        content = c;
    }

    public void setAnswerToButton(Button b)
    {
        button = b;
        button.setText(content);
    }

    public String getContent() {
        return content;
    }

    public Boolean getIfTrue() {
        return isTrue;
    }

    public Button getButton() {
        return button;
    }
}
