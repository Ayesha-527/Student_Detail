package com.example.studentdetail;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonStudentEntry;
    private Button buttonStudentList; // Add a reference to the Student List button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStudentEntry = findViewById(R.id.buttonStudentEntry);
        buttonStudentEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudentEntryActivity();
            }
        });

        buttonStudentList = findViewById(R.id.buttonStudentList); // Initialize the Student List button
        buttonStudentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStudentListActivity(); // Call the method to open the Student List activity
            }
        });
    }

    private void openStudentEntryActivity() {
        Intent intent = new Intent(this, StudentEntryActivity.class);
        startActivity(intent);
    }

    private void openStudentListActivity() {
        Intent intent = new Intent(this, StudentListActivity.class);
        startActivity(intent);
    }
}

