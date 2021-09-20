package com.example.charityhub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsApplicationFragment extends Fragment {

    private EditText Personalisation, Privacy, Notification, AdditionalInfo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_settings_application,container,false);

        Personalisation = (EditText)view.findViewById(R.id.personId);
        Privacy = (EditText)view.findViewById(R.id.privacyId);
        Notification = (EditText)view.findViewById(R.id.NotifyId);
        AdditionalInfo = (EditText) view.findViewById(R.id.infoId);
        return view;
    }
}
