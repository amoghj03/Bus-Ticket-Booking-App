package com.minemark.platform.busbookingappui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText username,password;
    Button login;
    DBHelper myDB;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        myDB= new DBHelper(this);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username.getText().toString();
                String pass=password.getText().toString();
                if(user.equals("") || pass.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "PLEASE ENTER THE CREDENTIALS", Toast.LENGTH_SHORT).show();
                }
                else{
                   Boolean result = myDB.checkusernamepassword(user,pass);
                   if(result == true)
                   {
                       Toast.makeText(getApplicationContext(),"LOGIN SUCCESSFUL",Toast.LENGTH_LONG).show();
                       Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                       startActivity(intent);
                       finish();
                   }
                   else{
                       Toast.makeText(getApplicationContext(),"EITHER USERNAME OR PASSWORD IS WRONG",Toast.LENGTH_LONG).show();
                   }
                }

            }
        });
        signup=findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),signup.class);
                startActivity(intent);
            }
        });
    }
}