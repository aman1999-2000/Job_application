package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    TextInputLayout fullname_var,username_var,email_var,phonenumber_var,password_var;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference referencence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        fullname_var=findViewById(R.id.fullname_field);
        username_var=findViewById(R.id.username_field);
        email_var=findViewById(R.id.Email_field);
        phonenumber_var=findViewById(R.id.phonenumber_field);
        password_var=findViewById(R.id.password_field);
    }

    public void loginbuttonclick(View view) {
        Intent intent = new Intent(getApplication(), login.class);
        startActivity(intent);
        finish();
    }
    public void registerbuttonclick(View view) {
        String fullname_ = fullname_var.getEditText().getText().toString();
        String username_ = fullname_var.getEditText().getText().toString();
        String email_ = fullname_var.getEditText().getText().toString();
        String phonenumber_ = fullname_var.getEditText().getText().toString();
        String password_ = fullname_var.getEditText().getText().toString();
        if (!fullname_.isEmpty()) {
            fullname_var.setError(null);
            fullname_var.setErrorEnabled(false);
            if (!username_.isEmpty()) {
                username_var.setError(null);
                username_var.setErrorEnabled(false);
                if (!email_.isEmpty()) {
                    email_var.setError(null);
                    email_var.setErrorEnabled(false);
                    if (!phonenumber_.isEmpty()) {
                        phonenumber_var.setError(null);
                        phonenumber_var.setErrorEnabled(false);
                        if (!password_.isEmpty()) {
                            password_var.setError(null);
                            password_var.setErrorEnabled(false);
                            if(email_.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$\"")){
                                    if(password_.matches("((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})"))
                                    {
                                       firebaseDatabase=firebaseDatabase.getInstance();
                                       referencence= firebaseDatabase.getReference("datauser");
                                        String fullname_s = fullname_var.getEditText().getText().toString();
                                        String username_s = fullname_var.getEditText().getText().toString();
                                        String email_s = fullname_var.getEditText().getText().toString();
                                        String phonenumber_s = fullname_var.getEditText().getText().toString();
                                        String password_s = fullname_var.getEditText().getText().toString();
                                        //creating objects
                                        storingdata storingdatass=new storingdata(fullname_s,username_s,email_s,phonenumber_s,password_s);
                                        referencence.child(username_s).setValue(storingdatass);
                                        Toast.makeText(getApplicationContext(),"Register successfully",Toast.LENGTH_SHORT).show();
                                        Intent  intent=new Intent(getApplicationContext(),jobs.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else
                                    {
                                        password_var.setError("Invalid password");
                                    }
                            }
                            else
                            {
                                email_var.setError("Invalid email");

                            }

                        } else {
                            password_var.setError("please enter the password");
                        }
                    } else {
                        phonenumber_var.setError("please enter the phone number");
                    }
                } else {
                    email_var.setError("please enter email address");
                }
            } else {
                username_var.setError("please enter username");
            }
        } else {
            fullname_var.setError("please enter fullname");
        }
    }

}

