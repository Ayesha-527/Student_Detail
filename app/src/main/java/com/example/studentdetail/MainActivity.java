package com.example.studentdetail;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonStudentEntry;

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
    }

    private void openStudentEntryActivity() {
        Intent intent = new Intent(this, StudentEntryActivity.class);
        startActivity(intent);
    }
}
