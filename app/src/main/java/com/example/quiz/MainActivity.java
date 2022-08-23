package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> data= new ArrayList<>();
        GivenData givenData = new GivenData();

        for (String item: givenData.englishSurahNames)
        {
            data.add(item);
        }
        listView = findViewById(R.id.list1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String text = "You Clicked on Position " + i;
            pos=i;
            Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("positionIndex",String.valueOf(pos));
            startActivity(intent);

        });
    }
    //to restore data on orientation change


}