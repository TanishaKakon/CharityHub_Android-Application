package com.example.charityhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity implements View .OnClickListener {

    private EditText SignInEmailEditText, SignInPasswordEditText;
    private Button SignInButton;
    private TextView SignUptextView, ForgotPassView;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        this.setTitle("Sign In Activity");

        mAuth = FirebaseAuth.getInstance();
        SignInEmailEditText = (EditText) findViewById(R.id.SignInEmailEditTextId);
        SignInPasswordEditText = (EditText) findViewById(R.id.SignInPasswordEditTextId);
        SignInButton = (Button) findViewById(R.id.SignInButtonId);
        SignUptextView = (TextView) findViewById(R.id.SignUpTextViewId);
        ForgotPassView = findViewById(R.id.ForgotPassId);
        progressBar = findViewById(R.id.progressbarId);

        SignUptextView.setOnClickListener(this);
        ForgotPassView.setOnClickListener(this);
        SignInButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SignInButtonId:
                userLogin();
                break;

            case R.id.SignUpTextViewId:
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);

                break;

            case R.id.ForgotPassId:
                final EditText resetMail = new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter Your Email To Received Reset Link.");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the email and send reset link
                        String mail = resetMail.getText().toString();
                        mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(SignInActivity.this, "Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SignInActivity.this, "Error ! Reset Link is Not Sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog
                    }
                });

                passwordResetDialog.create().show();
        }


    }

    private void userLogin() {
        String email = SignInEmailEditText.getText().toString().trim();
        String password = SignInPasswordEditText.getText().toString().trim();

        //checking the validity of the email

        if (email.isEmpty()) {
            SignInEmailEditText.setError("Enter an email address");
            SignInEmailEditText.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            SignInEmailEditText.setError(("Enter an email address"));
            SignInEmailEditText.requestFocus();
            return;

        }

        if (password.isEmpty()) {
            SignInPasswordEditText.setError("Enter a password");
            SignInPasswordEditText.requestFocus();
            return;
        }

        if (password.length() < 6) {
            SignInPasswordEditText.setError("Minimum length of a password should be 6");
            SignInPasswordEditText.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    finish();
                    Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
