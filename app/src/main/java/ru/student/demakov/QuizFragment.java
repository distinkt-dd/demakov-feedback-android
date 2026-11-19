package ru.student.demakov;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class QuizFragment extends Fragment {
    public QuizFragment() {
        super(R.layout.fragment_quiz);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.answer_button).setOnClickListener(button -> {
            String[] answers = {"Toast", "Fragment", "Activity"};
            new AlertDialog.Builder(requireContext())
                    .setTitle(R.string.choose_answer)
                    .setItems(answers, (dialog, choice) -> {
                        int message = choice == 0 ? R.string.success : R.string.failure;
                        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton(android.R.string.cancel, null)
                    .show();
        });
    }
}
