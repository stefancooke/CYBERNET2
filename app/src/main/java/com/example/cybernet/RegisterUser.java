package com.example.cybernet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private TextView banner, registerUser, login;
    private EditText editTextFullName, editTextAge, editTextEmail, editTextPassword, editTextConfirmPassword;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private CheckBox checkBox;
    private MaterialAlertDialogBuilder materialAlertDialogBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();


        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerUser = (Button) findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);


        materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);

        registerUser.setBackgroundColor(0xFFCCCCCC);

        registerUser.setEnabled(false);

        //This checks whether or not the box is checked
        checkBox = findViewById(R.id.terms);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    materialAlertDialogBuilder.setTitle("Terms and Conditions");
                    materialAlertDialogBuilder.setMessage("Welcome to CyberNet! Before you can use our app, please read and accept our Terms and Conditions. By creating an account with us and using our app, you agree to comply with our Terms and Conditions and our Privacy Policy.\n" +
                            "At CyberNet, we take your privacy and data security very seriously. When you create an account with us, we will ask you to provide certain information, including your login credentials. We will only use this information for the sole purpose of allowing you to access our app and providing our services. We will not share this information with any third parties, except as required by law. We take appropriate technical and organizational measures to ensure that your login information is stored securely and protected against unauthorized access or disclosure.\n" +
                            "By using our app, you acknowledge that you have read and understood our Terms and Conditions and our Privacy Policy. If you have any questions or concerns about how we use your data, please do not hesitate to contact us. If you do not agree with our Terms and Conditions or our Privacy Policy, please do not use our app.\n");
                    materialAlertDialogBuilder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            registerUser.setBackgroundColor(R.color.blue);
                            registerUser.setEnabled(true);
                            dialogInterface.dismiss();
                        }
                    });
                    materialAlertDialogBuilder.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            registerUser.setBackgroundColor(0xFFCCCCCC);
                            dialogInterface.dismiss();
                            checkBox.setChecked(false);
                        }
                    });

                    materialAlertDialogBuilder.show();
                } else {
                    registerUser.setEnabled(false);
                }
            }
        });

        //Old Redirect button no longer needed

        //login = (Button) findViewById(R.id.login);
        //login.setOnClickListener(this);



        editTextFullName = (EditText) findViewById(R.id.fullName);
        editTextAge = (EditText) findViewById(R.id.age);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);
        editTextConfirmPassword = (EditText) findViewById(R.id.confirmPassword);


        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
            case R.id.login:
                startActivity(new Intent(this, dashboard.class));
                break;
            case R.id.registerUser:
                registerUser();
                break;
        }
    }


    //Method created to ensure user enters a special character in their passowrd
    private boolean validatePassword(String password) {
        String specialChars = "[!@#$%&*()_+=|<>?{}\\[\\]~-]";
        boolean hasSpecialChar = password.matches(".*" + specialChars + ".*");
        return hasSpecialChar;
    }


    private void registerUser() {
        String email= editTextEmail.getText().toString().trim();
        String password= editTextPassword.getText().toString().trim();
        String fullName= editTextFullName.getText().toString().trim();
        String age= editTextAge.getText().toString().trim();
        String confirmPassword= editTextConfirmPassword.getText().toString().trim();
        String profilePicture = "";

        if(fullName.isEmpty()){
            editTextFullName.setError("You must enter your name!");
            editTextFullName.requestFocus();
            return;
        }
        if(age.isEmpty()){
            editTextAge.setError("You must enter your age!");
            editTextAge.requestFocus();
            return;
        }

        if(email.isEmpty()){
            editTextEmail.setError("You must enter your email!");
            editTextEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid email!");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("You must enter a password!");
            editTextPassword.requestFocus();
            return;
        }

        if (!validatePassword(password)) {
            editTextPassword.setError("Password must include a special character.");
            return;
        }

        if(password.length() < 6){
            editTextPassword.setError("The minimum length for a password should be 6 characters!");
            editTextPassword.requestFocus();
            return;
        }

        if(!password.equals(confirmPassword)){
            editTextPassword.setError("The passwords do not match!");
            editTextPassword.requestFocus();
            editTextConfirmPassword.setError("The passwords do not match!");
            editTextConfirmPassword.requestFocus();
            return;
        }










        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()){
                            //User user = new User(fullName, email, age);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(new User(fullName, email, age, profilePicture)).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(RegisterUser.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);
                                                // Then user should be redirected
                                                startActivity(new Intent(RegisterUser.this, dashboard.class));
                                            } else {
                                                Toast.makeText(RegisterUser.this, "Failed to register user! Please try again.", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);
                                            }
                                        }
                                    });
                        } else {
                            Toast.makeText(RegisterUser.this, "Failed to register user! Please try again.", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });





    }
}