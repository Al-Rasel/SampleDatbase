package com.example.asus.testproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ASUS on 4/21/2017.
 */

public class PersonSQLiteHelperClass extends SQLiteOpenHelper {

    private static String DATABASENAME = "Person.db";
    private static String TABLENAME = "personalInfo";
    private static String COL_1 = "ID";
    private static String COL_2 = "NAME";
    private static String COL_3 = "ROLL";
    private static String COL_4 = "SUBJECT";

    public PersonSQLiteHelperClass(Context context) {
        super(context, DATABASENAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLENAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, ROLL TEXT, SUBJECT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
        onCreate(sqLiteDatabase);
    }

    public void writeOnDataBase(String name, String roll, String subject) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues valuesOfPerson = new ContentValues();
        valuesOfPerson.put(COL_2, name);
        valuesOfPerson.put(COL_3, roll);
        valuesOfPerson.put(COL_4, subject);

        sqLiteDatabase.insert(TABLENAME, null, valuesOfPerson);
    }

    public Cursor getAllMyDataFromDatabase() {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLENAME,null);
        return cursor;
    }

    public void updateDatbaseValueUsingId(String id,String name,String roll,String subject){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues valuesOfPerson = new ContentValues();
        valuesOfPerson.put(COL_1,id);
        valuesOfPerson.put(COL_2, name);
        valuesOfPerson.put(COL_3, roll);
        valuesOfPerson.put(COL_4, subject);

        sqLiteDatabase.update(TABLENAME,valuesOfPerson,"ID = ?" ,new String[]{id});
    }
    public void deleteOneIteam(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLENAME,"ID = ?",new String[]{id});
    }

}
