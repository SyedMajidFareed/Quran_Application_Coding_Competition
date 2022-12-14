package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    String pos;
    int convtdpos;
    int sspPos;
    int endssp;
    ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent1 = getIntent();
        pos = intent1.getStringExtra("positionIndex");
        convtdpos = Integer.valueOf(pos);
        ArrayList<String> data2 = new ArrayList<>();
        GivenData data1= new GivenData();
        Quranic q = new Quranic();
        sspPos = data1.SSP[convtdpos];
        endssp = data1.SSP[convtdpos+1] - 1;
        for(int i=sspPos-1;i<endssp;i++)
        {
            data2.add(q.QuranArabicText[i]);
        }

        listView1 = findViewById(R.id.list2);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data2);
        listView1.setAdapter(arrayAdapter1);
    }


}