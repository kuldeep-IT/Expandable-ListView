package com.example.expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.simpleExpandableListView);

        CustomExpandableListViewAdapter customExpandableListViewAdapter = new CustomExpandableListViewAdapter(MainActivity.this);

        expandableListView.setAdapter(customExpandableListViewAdapter);
    }
}
