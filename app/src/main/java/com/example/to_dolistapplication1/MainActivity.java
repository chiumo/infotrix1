package com.example.to_dolistapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    EditText inputText1;
    Button btnAdd, btnUpdate;

    ArrayList<String>  foods = new ArrayList<String>();
    ArrayAdapter myAdapter1;

    Integer indexVal;
    String item;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.listView1);
        btnAdd = (Button) findViewById(R.id.button);
        btnUpdate = (Button) findViewById(R.id.button2);
       inputText1 = (EditText) findViewById(R.id.editText);



        //setup listview
       foods.add("ham");
       foods.add("Bread");

        myAdapter1= new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1,foods);
        listView1.setAdapter(myAdapter1);



        //Add item
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todo = inputText1.getText().toString();
                foods.add(todo);
                myAdapter1.notifyDataSetChanged();
                inputText1.setText("");
            }
        });



        //select item
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + "has been selected";
                indexVal = i;
                Toast.makeText(MainActivity.this,item,Toast.LENGTH_SHORT).show();
            }
        });


        //update
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String todo = inputText1.getText().toString();
                foods.set(indexVal,todo);
                myAdapter1.notifyDataSetChanged();


            }
        });

        //Deleted
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + "has been deleted";
                Toast.makeText(MainActivity.this,item,Toast.LENGTH_SHORT).show();

                foods.remove(i);
                myAdapter1.notifyDataSetChanged();
                return true;
            }
        });


    }
}