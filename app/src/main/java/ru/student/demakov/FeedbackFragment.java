package ru.student.demakov;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class FeedbackFragment extends Fragment {
    public FeedbackFragment() {
        super(R.layout.fragment_feedback);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText nameField = view.findViewById(R.id.name_input);
        EditText emailField = view.findViewById(R.id.email_input);

        view.findViewById(R.id.send_button).setOnClickListener(button -> {
            String name = nameField.getText().toString().trim();
            String email = emailField.getText().toString().trim();
            if (name.isEmpty()) {
                nameField.setError(getString(R.string.required_field));
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailField.setError(getString(R.string.invalid_email));
                return;
            }
            String details = getString(R.string.application_details, name, email);
            nameField.setText("");
            emailField.setText("");
            new AlertDialog.Builder(requireContext())
                    .setTitle(R.string.application_title)
                    .setMessage(details)
                    .setPositiveButton(R.string.okay, null)
                    .show();
        });
    }
}
