package com.minemark.platform.busbookingappui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    CardView cardView,cardView2;
    Toolbar toolbar;
    EditText date1,from1,dest1;
    String time,destination,from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        Bundle b=getIntent().getExtras();
        time=b.getString("date");
        from=b.getString("from");
        destination=b.getString("dest");
        date1=findViewById(R.id.date1);
        date1.setText(time);
        date1.setEnabled(false);
        from1=findViewById(R.id.from1);
        from1.setText(from);
        from1.setEnabled(false);
        dest1=findViewById(R.id.dest1);
        dest1.setText(destination);
        dest1.setEnabled(false);
        cardView = findViewById(R.id.cardView);
        cardView2= findViewById(R.id.cardView2);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b= new Bundle();
                b.putString("from",from);
                b.putString("dest",destination);
                b.putString("date",time);
                Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                intent.putExtras(b);
                startActivity(intent);
            }

        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);

            }

        });
        toolbar = findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });

    }
}
