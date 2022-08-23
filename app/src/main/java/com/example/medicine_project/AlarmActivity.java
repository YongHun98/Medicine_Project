package com.example.medicine_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AlarmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Spinner spn = (Spinner) findViewById(R.id.medi_count_list);

        ArrayAdapter<CharSequence> spn_adapter = ArrayAdapter.createFromResource(this, R.array.medi_count, android.R.layout.simple_spinner_item);
        spn_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(spn_adapter);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
                Toast.makeText(parent.getContext(), "선택된 용량은 " + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> arg0){

            }
        });
    }
}