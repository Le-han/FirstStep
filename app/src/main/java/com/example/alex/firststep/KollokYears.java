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

public class KollokYears extends ListActivity {
    private String[] mYearArray = { "2015", "2014", "2013", "2012" };

    // Создадим адаптер
    private ArrayAdapter<String> mYearAdapterKollok;
    //private String mYear;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mYearAdapterKollok = new ArrayAdapter<String>(this, R.layout.lines_style, mYearArray);
        setListAdapter(mYearAdapterKollok);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        switch (position){
            case 0 :
                Intent intent = new Intent(KollokYears.this, Var2015_1.class);
                intent.putExtra("mKeyVar", "Kollok2015"); //передаю по ключу mKey(строка), данные(можно разные типы)
                //intent.putExtra("mNumOfQuestion", 1);
                startActivity(intent);
                break;
            case 1 :
                intent = new Intent(KollokYears.this, Var2015_1.class);
                intent.putExtra("mKeyVar", "Kollok2014"); //передаю по ключу mKey(строка), данные(можно разные типы)
                //intent.putExtra("mNumOfQuestion", "1");
                startActivity(intent);
                break;
            default:
                Toast.makeText(getApplicationContext(), "will work later", Toast.LENGTH_SHORT).show();
        }
    }
}