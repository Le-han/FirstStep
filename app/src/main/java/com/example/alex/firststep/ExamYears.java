package com.example.alex.firststep;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.alex.firststep.R;

public class ExamYears extends ListActivity {
    private String[] mYearArray = { "2015", "2014", "2013", "2012" };

    // Создадим адаптер
    private ArrayAdapter<String> mYearAdapterExam;
    //private String mYear;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mYearAdapterExam = new ArrayAdapter<String>(this, R.layout.activity_exam_years, mYearArray);
        setListAdapter(mYearAdapterExam);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        Intent intent;
        switch (position){
            case 0 :
                /*
                Intent intent = new Intent(ExamYears.this, Var2015_1.class);
                intent.putExtra("mKeyVar", "2015"); //передаю по ключу mKey(строка), данные(можно разные типы)
                intent.putExtra("mNumOfQuestion", 1);
                startActivity(intent);*/
                Toast.makeText(getApplicationContext(), "Не нашел вариант колка за 2015 год, пожалуйста, отправьте его нам в ВК", Toast.LENGTH_SHORT).show();
                break;
            case 1 :
                intent = new Intent(ExamYears.this, Var2015_1.class);
                intent.putExtra("mKeyVar", "Exam2014"); //передаю по ключу mKey(строка), данные(можно разные типы)
                //intent.putExtra("mNumOfQuestion", "1");
                startActivity(intent);
                break;
            default:
                Toast.makeText(getApplicationContext(), "will work later", Toast.LENGTH_SHORT).show();
        }
    }
}