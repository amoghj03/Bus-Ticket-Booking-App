package com.minemark.platform.busbookingappui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button search_buses;
    EditText date, from, dest;
    ImageView logout;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        date = findViewById(R.id.date);
        from = findViewById(R.id.from);
        dest = findViewById(R.id.dest);

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish();
            }
        });
        search_buses = findViewById(R.id.search_buses);

        search_buses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fro=from.getText().toString();
                String des=dest.getText().toString();
                String dat=date.getText().toString();
                if (fro.equals("") || des.equals("") || dat.equals("")) {
                    Toast.makeText(getApplicationContext(), "FILL ALL THE FIELDS", Toast.LENGTH_LONG).show();
                    }
                else {
                    if (fro.equals(des))
                    {
                        Toast.makeText(getApplicationContext(), "FROM AND DESTINATION CAN'T BE SAME", Toast.LENGTH_LONG).show();
                    }
                    else {
                        if (des.equals("mangalore") || des.equals("bangalore")|| des.equals("mandya") || des.equals("bellary")  || des.equals("raichur") || des.equals("hospet") || des.equals("coorg")) {
                            if(fro.equals("mangalore") || fro.equals("bangalore") || fro.equals("mandya") || fro.equals("bellary")  || fro.equals("raichur") || fro.equals("hospet") || fro.equals("coorg")){
                                Bundle b = new Bundle();
                                b.putString("from", from.getText().toString());
                                b.putString("dest", dest.getText().toString());
                                b.putString("date", date.getText().toString());
                                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                                intent.putExtras(b);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "NO BUSES AVAILABLE", Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "NO BUSES AVAILABLE", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}