package com.donation.raakto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Suvashis on 4/9/2015.
 */
public class RaaktoService extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Raakto.db";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String AGE = "age";
    public static final String BLOOD_GROUP = "bloodGroup";
    public static final String PASSWORD = "password";
    public static final String COUNTRY= "country";
    public static final String STATE = "state";
    public static final String CITY = "city";
    public static final String TABLE_NAME = "donorDetails";


    public RaaktoService(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + ID + "integer primary key, " + NAME + " text, " + EMAIL + " text, " + PHONE_NUMBER + " text, " + AGE + " text, " + BLOOD_GROUP + " text, " + PASSWORD + " text, " + COUNTRY + " text, " + STATE + " text, " + CITY + " text)");

    }


    public boolean saveData(String name, String email, String phoneNumber, String age, String bloodGroup, String password, String country, String state, String city) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(EMAIL, email);
        contentValues.put(PHONE_NUMBER, phoneNumber);
        contentValues.put(AGE, age);
        contentValues.put(BLOOD_GROUP, bloodGroup);
        contentValues.put(PASSWORD, password);
        contentValues.put(COUNTRY, country);
        contentValues.put(STATE, state);
        contentValues.put(CITY, city);

        db.insert(TABLE_NAME, null, contentValues);

        return true;
    }

    public boolean upDateData(Integer id, String name, String email, String phoneNumber, String age, String bloodGroup, String country, String state, String city) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(EMAIL, email);
        contentValues.put(PHONE_NUMBER, phoneNumber);
        contentValues.put(AGE, age);
        contentValues.put(BLOOD_GROUP, bloodGroup);
        contentValues.put(COUNTRY, country);
        contentValues.put(STATE, state);
        contentValues.put(CITY, city);

        db.update(TABLE_NAME, contentValues," id = ? ",new String[]{Integer.toString(id)});

        return true;
    }

    public ArrayList getAreaList() {
        ArrayList areaList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor response = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        response.moveToFirst();
        while (response.isAfterLast() == false){
            areaList.add(response.getString(response.getColumnIndex(CITY)));
            response.moveToNext();
        }
        return areaList;
    }

    public ArrayList getDonorList(String areaName, String bloodGroup) {
        ArrayList donorList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor donors = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + CITY + " = " + areaName + " && " + BLOOD_GROUP + " = " + bloodGroup, null);
        donors.moveToFirst();
        while (donors.isAfterLast() == false){
            donorList.add(donors.getString( donors.getColumnIndex(NAME)));
            donors.moveToNext();
        }
        return donorList;
    }

    public boolean logIn(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor userDetails = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + EMAIL + " = " + email + " && " + PASSWORD + " = " + password, null);
        String tempEmail = userDetails.getString(userDetails.getColumnIndex(EMAIL));
        if (tempEmail == null || tempEmail.equals("")){
            return false;
        }

        return true;
    }

    public boolean logOut() {
        return true;
    }

}
