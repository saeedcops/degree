package com.cops.dgree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;


public class gridlist extends AppCompatActivity {
    GridView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lst=(GridView)findViewById(R.id.ls);
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MainActivity.subject);
        lst.setAdapter(adp);
        TextView setname=(TextView)findViewById(R.id.sname);
        setname.setText("Student name :"+String.valueOf(MainActivity.name));
    }
}
