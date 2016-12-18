package com.example.loginactivity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText editTextName,editTextUserName,editTextPassword;
    Button btnCreateAccount;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);


        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();


        // Get Refferences of Views
        editTextName = (EditText) findViewById(R.id.Registername);
        editTextUserName=(EditText)findViewById(R.id.Registeruser);
        editTextPassword=(EditText)findViewById(R.id.registerpassword);

        btnCreateAccount=(Button)findViewById(R.id.createbtn);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String Name=editTextName.getText().toString();
                String UserName=editTextUserName.getText().toString();
                String Password=editTextPassword.getText().toString();

                // check if any of the fields are vaccant
                if(Name.equals("")||UserName.equals("")||Password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Create Account Successful", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    final Dialog dialog = new Dialog(signup.this);
                    dialog.setContentView(R.layout.dialog);

                    dialog.show();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}