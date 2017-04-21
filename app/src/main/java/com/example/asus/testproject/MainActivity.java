package com.example.asus.testproject;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextName = (EditText) findViewById(R.id.edit_name);
        EditText editTextRoll = (EditText) findViewById(R.id.edit_roll);
        EditText editTextSubject = (EditText) findViewById(R.id.edit_subject);
        final PersonSQLiteHelperClass personSQLiteHelperClass = new PersonSQLiteHelperClass(this);

        Button buttonOk = (Button) findViewById(R.id.buttonOk);
        Button buttonView = (Button) findViewById(R.id.buttonView);
        Button buttonEdit = (Button) findViewById(R.id.buttonEdit);
        Button buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                personSQLiteHelperClass.writeOnDataBase("nameRasel", "957", "ECE");


            }
        });
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Person> allpersons = new ArrayList<Person>();
                Cursor cursor = personSQLiteHelperClass.getAllMyDataFromDatabase();
                StringBuffer stringBuffer = new StringBuffer();

                while (cursor.moveToNext()) {
                    allpersons.add(new Person(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
                }


                Log.e("totalData", "onClick: " + allpersons.toString());
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personSQLiteHelperClass.updateDatbaseValueUsingId("2", "upadated name", "12", "CSE");
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personSQLiteHelperClass.deleteOneIteam("1");
            }
        });
    }
}
