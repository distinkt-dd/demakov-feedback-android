package ru.student.demakov;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout), (view, windowInsets) -> {
            Insets bars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return windowInsets;
        });

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnItemSelectedListener(item -> {
            int selected = item.getItemId();
            if (selected == R.id.menu_feedback) {
                showScreen(new FeedbackFragment());
            } else if (selected == R.id.menu_quiz) {
                showScreen(new QuizFragment());
            } else if (selected == R.id.menu_notification) {
                showScreen(new NoticeFragment());
            } else {
                return false;
            }
            return true;
        });

        if (savedInstanceState == null) {
            showScreen(new FeedbackFragment());
        }
    }

    private void showScreen(Fragment screen) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, screen)
                .commit();
    }
}
