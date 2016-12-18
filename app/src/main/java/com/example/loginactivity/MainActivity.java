package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogIn, btnRegister;
    LoginDataBaseAdapter loginDataBaseAdapter;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a instance of SQLite Database
       loginDataBaseAdapter=new  LoginDataBaseAdapter(this);
       loginDataBaseAdapter=loginDataBaseAdapter.open();

       final EditText editTextUserName=(EditText) findViewById(R.id.username);
       final  EditText editTextPassword=(EditText) findViewById(R.id.password);
       Button btnSignIn=(Button) findViewById(R.id.login);
       Button btnSignUp = (Button)findViewById(R.id.register);
       btnSignUp.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               // TODO Auto-generated method stub

               /// Create Intent for SignUpActivity  abd Start The Activity
               Intent intentSignUP = new Intent(getApplicationContext(),signup.class);
               startActivity(intentSignUP);
           }
       });


       btnSignIn.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v) {
               // get The User name and Password
               String userName= editTextUserName.getText().toString();
               String password= editTextPassword.getText().toString();

               // fetch the Password form database for respective user name
               String storedPassword= loginDataBaseAdapter.getSinlgeEntry(userName);

               // check if the Stored password matches with  Password entered by user
               if(password.equals(storedPassword))
               {
                   Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();

               }
               else
               {
                   Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
               }
           }
       });

   }




    }

