import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.ComponentActivity;

import com.lab2.part1.R;

import androidx.activity.ComponentActivity;

public class MainActivity extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("onCreate()");

        setContentView(R.layout.activity_main);

        /* Variables */
        EditText name = findViewById(R.id.editName);
        EditText password = findViewById(R.id.editPassword);
        EditText telephone = findViewById(R.id.editPhone);
        EditText email = findViewById(R.id.editEmail);
        Button submit = findViewById(R.id.btnSubmit);

        /* Action Listener for submitButton */
        submit.setOnClickListener(v -> {

            String nameText = name.getText().toString().trim();
            String passText = password.getText().toString().trim();
            String teleNo = telephone.getText().toString().trim();
            String emailText = email.getText().toString().trim();

            boolean isValid = true;

            /* Form Validations */

            /* NAME */
            if (nameText.isEmpty()) {
                name.setError("Name is Required");
                isValid = false;
            } else if (!nameText.matches("^[a-zA-Z]+$")) {
                name.setError("Name must contain letters only!");
                isValid = false;
            }

            /* PASSWORD */
            if (passText.isEmpty()) {
                password.setError("Password is Required");
                isValid = false;
            } else if (passText.length() < 3) {
                password.setError("Password must be 3 or more characters!");
                isValid = false;
            }

            /* TELEPHONE */
            if (teleNo.isEmpty()) {
                telephone.setError("Telephone Number is Required");
                isValid = false;
            } else if (!teleNo.matches("^[0-9]+$")) {
                telephone.setError("You can only use numbers 0 - 9");
                isValid = false;
            } else if (teleNo.length() < 3) {
                telephone.setError("Phone Number Not Long Enough!");
                isValid = false;
            }

            /* EMAIL */
            if (emailText.isEmpty()) {
                email.setError("Email is required");
                isValid = false;
            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                email.setError("Enter a valid email");
                isValid = false;
            }

            /* If everything works */
            if (isValid) {
                Toast.makeText(
                        MainActivity.this,
                        "Thank you " + nameText + ", your request is being processed!",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }

    /* Displaying Application Life Cycle on LogCat */

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy()");
    }
}