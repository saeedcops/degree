package com.cops.dgree;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText subnum,getsname;
    TextView total,per,grade,max,min;
    Button btncalc;
    int maxdgree=0,mindgree=100,totaldgree=0;
    AlertDialog.Builder message;
    public static List<String>subject=new ArrayList<String>();
    public static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getsname=(EditText)findViewById(R.id.getsname);
        subnum=(EditText)findViewById(R.id.txtsubnum);
        total=(TextView)findViewById(R.id.tvtotal);
        per=(TextView)findViewById(R.id.tvper);
        grade=(TextView)findViewById(R.id.tvgrade);
        max=(TextView)findViewById(R.id.tvmax);
        min=(TextView)findViewById(R.id.tvmin);
        btncalc=(Button)findViewById(R.id.btncalc);

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int no=Integer.parseInt(subnum.getText().toString());
                for(int i=0;i<no;i++){
                    LayoutInflater lay=LayoutInflater.from(MainActivity.this);
                    View view=lay.inflate(R.layout.show,null);
                    final EditText subname=(EditText)view.findViewById(R.id.txtsubname);
                    final EditText subdgree=(EditText)view.findViewById(R.id.txtdgree);
                    name=getsname.getText().toString();
                    message=new AlertDialog.Builder(MainActivity.this);
                    message.setView(view);
                    message.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int SUBDGREE=Integer.parseInt(subdgree.getText().toString());
                            String subgrade;
                            //CHECK FOR subject GRADE
                            if(SUBDGREE<50)subgrade="F";
                            else if(SUBDGREE<65)subgrade="D";
                            else if(SUBDGREE<75)subgrade="C";
                            else if(SUBDGREE<85)subgrade="B";
                            else subgrade="A";
                            subject.add(subname.getText().toString()+"  "+SUBDGREE+"  "+subgrade);
                            String GRADE=null;
                            int PER=0;
                            totaldgree+=SUBDGREE;
                            PER=totaldgree/no;

                            //CHECK FOR All GRADE
                            if(PER<50)GRADE="F";
                            else if(PER<65)GRADE="D";
                            else if(PER<75)GRADE="C";
                            else if(PER<85)GRADE="B";
                            else GRADE="A";

                            //CHECK FOR MAX DEGREE
                            if(SUBDGREE>maxdgree)maxdgree=SUBDGREE;

                            //CHECK FOR MIN DEGREE
                            if(SUBDGREE<mindgree)mindgree=SUBDGREE;

                            //RETURN RESULT
                            total.setText("Total is : "+String.valueOf(totaldgree));
                            per.setText("Per is : "+ String.valueOf(PER)+ " %");
                            grade.setText("Grade is : "+String.valueOf(GRADE));
                            max.setText("Max : "+ String.valueOf(maxdgree));
                            min.setText("Min : "+String.valueOf(mindgree));

                        }
                    });
                    message.create();
                    message.show();
                }

            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent (MainActivity.this,gridlist.class));

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
