package com.minemark.platform.busbookingappui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {
    EditText username,password,confirm;
    Button register;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        confirm=findViewById(R.id.confirm);
        register=findViewById(R.id.register);
        myDB=new DBHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String conf=confirm.getText().toString();

                if(user.equals("") || pass.equals("") || conf.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"FILL ALL THE FIELDS",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pass.equals(conf))
                    {
                       Boolean usercheckResult = myDB.checkusername(user);
                       if(usercheckResult==false)

                       {
                           if(validatePass(pass)) {
                               Boolean regResult = myDB.insertData(user, pass);
                               if (regResult == true) {
                                   Toast.makeText(getApplicationContext(), "REGISTRATION SUCCESSFUL", Toast.LENGTH_LONG).show();
                                   Intent intent = new Intent(getApplicationContext(), login.class);
                                   startActivity(intent);
                               } else {
                                   Toast.makeText(getApplicationContext(), "REGISTRATION UNSUCCESSFUL", Toast.LENGTH_LONG).show();
                               }
                           }
                           else
                           {
                               Toast.makeText(getApplicationContext(), "INCREASE THE STRENGHT OF THE PASSWORD", Toast.LENGTH_LONG).show();

                           }
                       }
                       else{
                           Toast.makeText(getApplicationContext(),"USER ALREADY EXIST",Toast.LENGTH_LONG).show();
                       }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"PASSWORD DID NOT MATCH",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public boolean validatePass(String pass){
        Pattern pattern;
        Matcher matcher;
        String pat="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=!-])(?=\\S+$).{8,}$";
        pattern=Pattern.compile(pat);
        matcher=pattern.matcher(pass);
        return matcher.matches();
    }
}