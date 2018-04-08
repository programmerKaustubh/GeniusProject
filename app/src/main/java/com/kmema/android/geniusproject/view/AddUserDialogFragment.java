package com.kmema.android.geniusproject.view;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kmema.android.geniusproject.R;

public class AddUserDialogFragment extends DialogFragment implements View.OnClickListener {
    private EditText etFirstName, etJob;
    private Button btnAddUser, btnCancel;
    private final String TAG_DIALOG_FRAGMEN = "DIALOG_Fragment";

    public AddUserDialogFragment() {

    }

    public interface FragmentClickListner {
        boolean userInput(String FirstName, String Job);
    }

    public static AddUserDialogFragment getInstance() {
        AddUserDialogFragment addUserDialogFragment = new AddUserDialogFragment();

        Bundle bundle = new Bundle();
        bundle.putString("title", "titleName");
        addUserDialogFragment.setArguments(bundle);
        return addUserDialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_add_user, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etFirstName = view.findViewById(R.id.etFirstName);
        etJob = view.findViewById(R.id.etJob);
        btnCancel = view.findViewById(R.id.btnCancelAddUser);
        btnCancel.setOnClickListener(this);
        btnAddUser = view.findViewById(R.id.btnAddUser);
        btnAddUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddUser:
                sendResultBack(etFirstName.getText().toString(), etJob.getText().toString());
                break;

            case R.id.btnCancelAddUser:
                Toast.makeText(getActivity().getApplicationContext(), "Canceled", Toast.LENGTH_SHORT).show();
                cancelAddRequest();
                break;
        }
    }

    private void sendResultBack(String FirstName, String Job) {
        FragmentClickListner addUserDialogFragment = (FragmentClickListner) getActivity();
        if (addUserDialogFragment.userInput(FirstName, Job)) {
            dismiss();
        } else {
            Toast.makeText(getActivity().getApplicationContext(), "Enter User Information", Toast.LENGTH_SHORT).show();
        }
    }

    private void cancelAddRequest() {
        Log.i(TAG_DIALOG_FRAGMEN, "CancelAddRequest Clicked");
        dismiss();
    }
}
