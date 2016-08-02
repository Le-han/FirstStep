package com.example.alex.firststep;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alex.firststep.R;


public class Var2015_1 extends AppCompatActivity {
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";

    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    //функциональности подсматривания ответа
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    private int mAnswerIsTrue;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.V2015_1_1, R.string.A2015_1_1),
            new Question(R.string.V2015_1_2, R.string.A2015_1_2),
            new Question(R.string.V2015_1_3, R.string.A2015_1_3),
            new Question(R.string.V2015_1_4, R.string.A2015_1_4),
            new Question(R.string.V2015_1_5, R.string.A2015_1_5),
            new Question(R.string.V2015_1_6, R.string.A2015_1_6),
            new Question(R.string.V2015_1_7, R.string.A2015_1_7),
            new Question(R.string.V2015_1_8, R.string.A2015_1_8),
            new Question(R.string.V2015_1_9, R.string.A2015_1_9),
            new Question(R.string.V2015_1_10,R.string.A2015_1_10),

    };;

    private int mCurrentIndex = 0;

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
    /* В этой версии проверять на правильность не надо
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    } */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_var2015_1);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        //PREV
        mPrevButton = (ImageButton)findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v){
                if ((mCurrentIndex - 1) % mQuestionBank.length >= 0) {
                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                    //mIsCheater = false;
                    int question = mQuestionBank[mCurrentIndex].getTextResId();
                    mQuestionTextView.setText(question);
                    mAnswerTextView.setVisibility(View.INVISIBLE);
                    mShowAnswer.setVisibility(View.VISIBLE);
                    updateQuestion();
                } else {
                    Toast.makeText(Var2015_1.this, R.string.error_prev, Toast.LENGTH_SHORT).show();
                }
            }
        });
        //NEXT
        mNextButton = (ImageButton)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                mAnswerTextView.setVisibility(View.INVISIBLE);
                mShowAnswer.setVisibility(View.VISIBLE);
                updateQuestion();
            }
        });
        //SHOW ANSWER
        mAnswerTextView = (TextView)findViewById(R.id.answer_text_view);
        mShowAnswer =(Button)findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question curQuestion = mQuestionBank[mCurrentIndex];
                mAnswerIsTrue = curQuestion.isAnswerTrue();
                mAnswerTextView.setText(mAnswerIsTrue);

                mAnswerTextView.setVisibility(View.VISIBLE);
                mShowAnswer.setVisibility(View.INVISIBLE);
            }
        });
        /*
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        */
        updateQuestion();
    }
}