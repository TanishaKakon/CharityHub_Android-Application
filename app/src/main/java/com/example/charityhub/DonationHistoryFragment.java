package com.example.charityhub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DonationHistoryFragment extends Fragment {

    private EditText DonorName, DonorEmail, DonorPhone, DonationType;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_donation_history,container,false);

        DonorName = (EditText) view.findViewById(R.id.DonorNameId);
        DonorEmail= (EditText) view.findViewById(R.id.EmailId);
        DonorPhone = (EditText) view.findViewById(R.id.PhoneId);
        DonationType = (EditText) view.findViewById(R.id.TypeId);
    return view;
    }
}
