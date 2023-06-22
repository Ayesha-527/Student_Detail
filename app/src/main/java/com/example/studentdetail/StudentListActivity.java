package com.example.studentdetail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


import com.example.studentdetail.Student;

// Rest of the code...

public class StudentListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentListAdapter adapter;
    private List<Student> studentList;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        recyclerView = findViewById(R.id.recyclerViewStudents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentList = new ArrayList<>();
        databaseHelper = new DatabaseHelper(this);

        loadDataFromDatabase();

        adapter = new StudentListAdapter(studentList, this);
        recyclerView.setAdapter(adapter);
    }

    private void loadDataFromDatabase() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME, null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
            String rollNo = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ROLLNO));
            studentList.add(new Student(name, rollNo));
        }

        cursor.close();
    }
}
