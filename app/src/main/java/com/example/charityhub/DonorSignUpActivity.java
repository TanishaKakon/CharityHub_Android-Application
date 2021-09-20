package com.example.charityhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonorSignUpActivity extends AppCompatActivity implements View .OnClickListener {

    private EditText FirstNameText, LastNameText, SignUpEmailEditText, SignUpPasswordEditText, PhoneText;
    private TextView UserTypeDon;
    private Button SignUpButton;
    private TextView SignIntextView;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_sign_up);
        this.setTitle("Sign Up Activity");

        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressbarId);

        databaseReference = FirebaseDatabase.getInstance().getReference("donors");

        FirstNameText = findViewById(R.id.FirstNameTextId);
        LastNameText = findViewById(R.id.LastNameTextId);
        SignUpEmailEditText = (EditText) findViewById(R.id.SignUpEmailEditTextId);
        SignUpPasswordEditText = (EditText) findViewById(R.id.SignUpPasswordEditTextId);
        PhoneText = findViewById(R.id.PhoneTextId);
        UserTypeDon = findViewById(R.id.DontypeId);
        SignUpButton = (Button) findViewById(R.id.SignUpButtonId);
        SignIntextView = (TextView) findViewById((R.id.SignIntextViewId));

        SignIntextView.setOnClickListener(this);
        SignUpButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SignUpButtonId:
                saveData();
                userRegister();
                break;

            case R.id.SignIntextViewId:
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);

                break;
        }


    }

    private void saveData() {

        String FirstName = FirstNameText.getText().toString().trim();
        String LastName = LastNameText.getText().toString().trim();
        String Phone = PhoneText.getText().toString().trim();
        String UserDonor = UserTypeDon.getText().toString().trim();

        String key = databaseReference.push().getKey();

        Donor donor = new Donor(FirstName,LastName,Phone,UserDonor);

        databaseReference.child(key).setValue(donor);

    }

    private void userRegister() {
        String email = SignUpEmailEditText.getText().toString().trim();
        String password = SignUpPasswordEditText.getText().toString().trim();

        //checking the validity of the email

        if (email.isEmpty()) {
            SignUpEmailEditText.setError("Enter an email address");
            SignUpEmailEditText.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            SignUpEmailEditText.setError(("Enter an email address"));
            SignUpEmailEditText.requestFocus();
            return;

        }

        if (password.isEmpty()) {
            SignUpPasswordEditText.setError("Enter a password");
            SignUpPasswordEditText.requestFocus();
            return;
        }

        if (password.length() < 6) {
            SignUpPasswordEditText.setError("Minimum length of a password should be 6");
            SignUpPasswordEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);


                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(), "User is already Registered",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }


                }


            }
        });


    }
}