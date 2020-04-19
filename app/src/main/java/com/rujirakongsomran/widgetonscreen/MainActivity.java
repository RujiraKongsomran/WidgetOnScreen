package com.rujirakongsomran.widgetonscreen;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    Button btnSave;
    EditText etTitle, etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
        // Init Paper
        Paper.init(this);

        etTitle = (EditText) findViewById(R.id.etTitle);
        etContent = (EditText) findViewById(R.id.etContent);
        btnSave = (Button) findViewById(R.id.btnSave);


        btnSave.setOnClickListener(btnSaveListener);

    }

    // Listener
    View.OnClickListener btnSaveListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Paper.book().write("title", etTitle.getText().toString());
            Paper.book().write("content", etContent.getText().toString());

            Toast.makeText(MainActivity.this, "Save!!!", Toast.LENGTH_SHORT).show();
        }
    };
}
