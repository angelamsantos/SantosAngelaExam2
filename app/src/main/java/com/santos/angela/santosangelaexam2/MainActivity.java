package com.santos.angela.santosangelaexam2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference root;
    EditText eFname, eLname, eEx1, eEx2;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseDatabase.getInstance();
        root = db.getReference("grade");
        eFname = findViewById(R.id.eFN);
        eLname = findViewById(R.id.eLN);
        eEx1 = findViewById(R.id.eExam1);
        eEx2 = findViewById(R.id.eExam2);
    }

    public void addRecord(View v) {
        String fname = eFname.getText().toString().trim();
        String lname = eLname.getText().toString().trim();
        Long exam1 = Long.parseLong(eEx1.getText().toString().trim());
        Long exam2 = Long.parseLong(eEx2.getText().toString().trim());
        Long average = (exam1 + exam2) / 2;
        Student grade = new Student(fname,lname,average);
        String key = root.push().getKey();
        root.child(key).setValue(grade);
        output = (TextView) findViewById(R.id.tvAverage);
        output.setText(average.toString());
        Toast.makeText(this,"record added to db",Toast.LENGTH_LONG).show();
    }
}
