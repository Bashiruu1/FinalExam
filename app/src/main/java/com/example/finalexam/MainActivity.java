package com.example.finalexam;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button computeButton;
    EditText totalStudents;
    EditText aStudents;
    EditText bStudents;
    EditText cStudents;
    EditText dStudents;
    EditText fStudents;
    int total_students;
    float a_students;
    float b_students;
    float c_students;
    float d_students;
    float f_students;
    final String title = "The percentages of grade distribution are:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalStudents = findViewById(R.id.total_students);
        aStudents = findViewById(R.id.a_students);
        bStudents = findViewById(R.id.b_students);
        cStudents = findViewById(R.id.c_students);
        dStudents = findViewById(R.id.d_students);
        fStudents = findViewById(R.id.f_students);
        computeButton = findViewById(R.id.computer_btn);

        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(totalStudents.getText())) {
                    totalStudents.setError("Please enter a total number of students");
                } else if (TextUtils.isEmpty(aStudents.getText())) {
                    aStudents.setError("Please enter a total number of A students");
                } else if (TextUtils.isEmpty(bStudents.getText())) {
                    bStudents.setError("Please enter a total number of B students");
                } else if (TextUtils.isEmpty(cStudents.getText())) {
                    cStudents.setError("Please enter a total number of C students");
                } else if (TextUtils.isEmpty(dStudents.getText())) {
                    dStudents.setError("Please enter a total number of D students");
                } else if (TextUtils.isEmpty(fStudents.getText())) {
                    fStudents.setError("Please enter a total number of F students");
                }
                total_students = Integer.valueOf(totalStudents.getText().toString());
                a_students = 100 * Float.valueOf(aStudents.getText().toString())/total_students;
                b_students = 100 * Float.valueOf(bStudents.getText().toString())/total_students;
                c_students = 100 * Float.valueOf(cStudents.getText().toString())/total_students;
                d_students = 100 * Float.valueOf(dStudents.getText().toString())/total_students;
                f_students = 100 * Float.valueOf(fStudents.getText().toString())/total_students;
                viewData();

                Intent intent = new Intent(MainActivity.this, BarGraph.class);
                intent.putExtra("Total", total_students);
                intent.putExtra("A", a_students);
                intent.putExtra("B", b_students);
                intent.putExtra("C", c_students);
                intent.putExtra("D", d_students);
                intent.putExtra("F", f_students);
                Toast.makeText(MainActivity.this, String.valueOf(a_students), Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }

    public void viewData() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("A's: " + a_students + "%" + "\n");
        stringBuffer.append("B's: " + b_students +"%" + "\n");
        stringBuffer.append("C's: " + c_students +"%" + "\n");
        stringBuffer.append("D's: " + d_students +"%" + "\n");
        stringBuffer.append("F's: " + f_students +"%" + "\n");

        display(stringBuffer.toString());
    }

    public void display(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
