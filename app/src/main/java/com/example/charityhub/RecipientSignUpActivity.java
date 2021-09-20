package com.example.charityhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RecipientSignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText OrgNameText, RegNumText,SignUpEmailEditText, WebLink, AddressText, BKashText, AccountText,SignUpPasswordEditText,Typetext;
    private TextView UserTypeRec;
    DatabaseReference databaseReference;
    private RadioGroup radiogroup;
    private Button SignUpButton;
    private TextView SignIntextView;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_sign_up);

        databaseReference = FirebaseDatabase.getInstance().getReference("recipients");
        mAuth = FirebaseAuth.getInstance();

        OrgNameText = findViewById(R.id.OrgNameTextId);
        RegNumText = findViewById(R.id.RegNumTextId);
        SignUpEmailEditText = (EditText) findViewById(R.id.SignUpEmailEditTextId);
        SignUpPasswordEditText = (EditText) findViewById(R.id.SignUpPasswordEditTextId);
        WebLink = findViewById(R.id.WebLinkId);
        AddressText = findViewById(R.id.AddressTextId);
        BKashText = findViewById(R.id.BKashTextId);
        AccountText = findViewById(R.id.AccountTextId);
        radiogroup = findViewById(R.id.radiogroupid);
        Typetext = findViewById(R.id.typeid);
        UserTypeRec=findViewById(R.id.RectypeId);
        SignUpButton = (Button) findViewById(R.id.SignUpButtonId);
        SignIntextView = (TextView) findViewById((R.id.SignIntextViewId));
        progressBar = findViewById(R.id.progressbarId);

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

        String OrganizationName = OrgNameText.getText().toString().trim();
        String RegistrationNo = RegNumText.getText().toString().trim();
        String WebsiteLink = WebLink.getText().toString().trim();
        String Address = AddressText.getText().toString().trim();
        String BKashNumber = BKashText.getText().toString().trim();
        String AccountNo = AccountText.getText().toString().trim();
        String UserRecipient = UserTypeRec.getText().toString().trim();
        String Type = Typetext.getText().toString().trim();
        String key = databaseReference.push().getKey();

        Recipient recipient = new Recipient(OrganizationName,RegistrationNo,WebsiteLink,Address,BKashNumber,AccountNo,UserRecipient,Type);

        databaseReference.child(key).setValue(recipient);
        Toast.makeText(getApplicationContext(), "Recipient info is added",Toast.LENGTH_LONG).show();


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
