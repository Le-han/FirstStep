package com.example.alex.firststep;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    private String[] mMenuArray = {"Коллоквиум", "Экзамен", "О программе", "Выход" };

    // Создадим адаптер
    private ArrayAdapter<String> mMenuAdapter;
    private String mMonth;
    private ArrayAdapter<String> m_lapList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        m_lapList = (ArrayAdapter<String>)getListAdapter();
        mMenuAdapter = new ArrayAdapter<String>(this, R.layout.lines_style, mMenuArray);
        setListAdapter(mMenuAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        switch (position){
            case 0 :
                Intent intent = new Intent(MainActivity.this, KollokYears.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(getApplicationContext(), "will work later", Toast.LENGTH_SHORT).show();//lol
        }

    }
}