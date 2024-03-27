package com.leynnnnnn.nectar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    EditText usernameField, emailField, passwordField;
    TextView haveAnAccount;
    Button signUp;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        haveAnAccount = findViewById(R.id.haveAnAccout);
        usernameField = findViewById(R.id.username);
        emailField = findViewById(R.id.email);
        passwordField = findViewById(R.id.password);
        signUp = findViewById(R.id.signUpButton);
        dbRef = FirebaseDatabase.getInstance().getReference().child("Accounts");

        haveAnAccount.setOnClickListener(v-> startActivity(new Intent(this, SignIn.class)));

        signUp.setOnClickListener(v -> createAccount());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void createAccount() {
        String username = usernameField.getText().toString().trim();
        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();

        if(!isValidEmail(email)) {
            emailField.setError("Invalid email");
            return;
        }
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill up all the information needed.", Toast.LENGTH_SHORT).show();
            return;
        }

        AccountInformation accountInformation = new AccountInformation(username, email, password);
        dbRef.push().setValue(accountInformation).addOnSuccessListener(unused -> {
                    Toast.makeText(this, "Account created successfully.", Toast.LENGTH_SHORT).show();})
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();});

    }

    private boolean isValidEmail(CharSequence target) {
        return (target != null && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }


}