package com.example.charityhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;

public class ProfileFragment extends Fragment{

    private EditText FullNameText, EmailText, PhoneText;
    private Button EditProfileButton;
    FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        FullNameText = (EditText) getView().findViewById(R.id.FullNameTextId);
        EmailText = (EditText) getView().findViewById(R.id.EmailEditTextId);
        PhoneText = (EditText) getView().findViewById(R.id.PhoneTextId);

        EditProfileButton = getView().findViewById(R.id.EditButtonId);



        //EditProfileButton.setOnClickListener(this);

        return view;
    }

    //@Override
    //public void onClick(View v) {
        //switch (v.getId()) {
            //case R.id.EditButtonId:
                //Intent i = new Intent(v.getContext(),EditProfile.class);
                //i.putExtra("fullName",FullNameText.getText().toString());
                //i.putExtra("email",EmailText.getText().toString());
                //i.putExtra("phone",PhoneText.getText().toString());
                //startActivity(i);
        }



