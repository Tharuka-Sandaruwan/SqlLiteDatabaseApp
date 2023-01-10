package com.example.sqllitedatabaseapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper =new DatabaseHelper(this);
        viewAllIds();
    }

    public void viewAllIds(){
        Cursor result= databaseHelper.getIds();
        List<String> list = new ArrayList<String>();
        list.add("Select ID");
        if(result.getCount()>0){
            while (result.moveToNext()){
                list.add(result.getString(0));
            }
        }
        Spinner spinnerId = (Spinner) findViewById(R.id.spinnerId);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerId.setAdapter(dataAdapter);
    }
}