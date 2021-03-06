package com.example.eyeapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int ADMIN = 0;
    public static final int TEACHER = 1;
    public static final int PARENT = 2;

    public static final String id = "id";
    public static final String name = "name";
    public static final String email = "email";
    public static final String password = "password";
    public static final String identityId = "identityId";
    public static final String type = "type";
    public static final String motherId = "mother_id";
    public static final String fatherId = "father_id";
    public static final String level = "level";
    public static final String section = "section";
    public static final String schoolId = "school_id";
    public static final String subject = "subject";
    public static final String teacherId = "teacher_id";

    public static final String user = "user";
    public static final String school = "school";
    public static final String student = "student";
    public static final String teacher = "teacher";

    String user_statement = "CREATE TABLE " + user + " ("
            + id + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            + name + " TEXT ,"
            + email + " TEXT ,"
            + identityId + " TEXT ,"
            + password + " TEXT ,"
            + type + " INTEGER );";

    String school_statement = "CREATE TABLE " + school + " ("
            + id + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            + name + " TEXT );";

    String student_statement = "CREATE TABLE " + student + " ("
            + id + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            + name + " TEXT ,"
            + motherId + " TEXT ,"
            + fatherId + " TEXT ,"
            + level + " TEXT ,"
            + section + " TEXT ,"
            + schoolId + " INTEGER );";

    String teacher_statement = "CREATE TABLE " + teacher + " ("
            + id + " INTEGER PRIMARY KEY AUTOINCREMENT , "
            + teacherId + " INTEGER ,"
            + name + " TEXT ,"
            + subject + " TEXT ,"
            + section + " TEXT ,"
            + schoolId + " INTEGER );";

    public DatabaseHelper(Context context) {
        super(context, "school.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(user_statement);
        sqLiteDatabase.execSQL(school_statement);
        sqLiteDatabase.execSQL(student_statement);
        sqLiteDatabase.execSQL(teacher_statement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + user_statement);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + school_statement);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + student_statement);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + teacher_statement);
    }
}
