package com.lab2.part2;
import android.widget.Toast;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent);

        int validationCode =
                getIntent().getIntExtra("validationCode", 0);

        EditText codeInput = findViewById(R.id.codeInput);
        Button verifyButton = findViewById(R.id.verifyButton);

        verifyButton.setOnClickListener(v -> {

            String enteredCode = codeInput.getText().toString().trim();

            if (enteredCode.isEmpty()) {
                codeInput.setError("Enter the validation code");
                return;
            }

            int userCode = Integer.parseInt(enteredCode);

            if (userCode == validationCode) {
                codeInput.setError(null);
                Toast.makeText(
                        IntentActivity.this,
                        "Account validated successfully",
                        Toast.LENGTH_LONG
                ).show();
            } else {
                codeInput.setError("Incorrect validation code");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}