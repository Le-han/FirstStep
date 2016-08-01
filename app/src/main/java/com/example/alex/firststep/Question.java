package com.example.alex.firststep;

public class Question {

    private int mTextResId;
    private String mAnswer;

    public Question(int textResId, String answerTrue) {
        mTextResId = textResId;
        mAnswer = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public String isAnswerTrue() {
        return mAnswer;
    }

    public void setAnswerTrue(String answerTrue) {
        mAnswer = answerTrue;
    }
}