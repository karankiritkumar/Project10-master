package com.example.project4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.project4.R;

public class Page2Activity extends AppCompatActivity
{
    private EditText fnameET, lnameET, ageET;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        this.fnameET = (EditText)this.findViewById(R.id.fnameET);
        this.lnameET = (EditText)this.findViewById(R.id.lnameET);
        this.ageET = (EditText)this.findViewById(R.id.ageET);
    }

    public void onAddStudentButtonPressed(View v)
    {
        String fname = this.fnameET.getText().toString();
        String lname = this.lnameET.getText().toString();
        int age = Integer.parseInt(this.ageET.getText().toString());
        Student s = new Student(fname, lname, age);
        s.display();
    }
}
