package com.example.medicine_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class PopupActivity extends Activity {
    Button btn_modify;
    Button btn_delete;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_modify);

        btn_modify = (Button) findViewById(R.id.btn_modify);
        btn_modify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlarmActivity.class);
                //intent.putExtra("drugName", drugstr); 이거 안해도 되는건가
                startActivity(intent);
            }
        });
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //리스트에서 삭제
            }
        });
    }
}