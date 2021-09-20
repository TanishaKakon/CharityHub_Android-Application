package com.example.charityhub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditLocationFragment extends Fragment {

    private EditText PreviousAddress, NewAddress;
    private Button UpdateAddress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_edit_my_location,container,false);

        PreviousAddress = (EditText) view.findViewById(R.id.PreAddId);
        NewAddress = (EditText) view.findViewById(R.id.NewAddId);
        UpdateAddress = (Button) view.findViewById(R.id.EditAddId);

    return view;
    }
}
