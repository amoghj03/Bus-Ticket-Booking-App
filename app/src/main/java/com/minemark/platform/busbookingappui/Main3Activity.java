package com.minemark.platform.busbookingappui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    Button book;
    GridLayout mainGrid;
    EditText date2,from2,dest2;
    Toolbar toolbar2;
    String seat;
    Number total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);
        Bundle b=getIntent().getExtras();
        String time=b.getString("date");
        String from=b.getString("from");
        String destination=b.getString("dest");
        date2=findViewById(R.id.date2);
        date2.setText(time);
        date2.setEnabled(false);
        from2=findViewById(R.id.from2);
        from2.setText(from);
        from2.setEnabled(false);
        dest2=findViewById(R.id.dest2);
        dest2.setText(destination);
        dest2.setEnabled(false);
        book=findViewById(R.id.book);
        toolbar2 = findViewById(R.id.toolbar2);
        toolbar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
            }
        });
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setToggleEvent(mainGrid);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),last.class);
                startActivity(intent);
            }
        });
    }

    private void setToggleEvent(GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1 ) {
                        cardView.setCardBackgroundColor(Color.parseColor("#00FF00"));
                    } else {
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    }
                }
            });
        }
    }
}
