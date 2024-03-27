package com.leynnnnnn.nectar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {
    TextView createAnAccount;
    EditText usernameField, passwordField;
    Button sigIn;
    DatabaseReference dbRef;
    AccountInformation currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        createAnAccount = findViewById(R.id.createAnAccount);
        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);
        sigIn = findViewById(R.id.signIn);
        createAnAccount.setOnClickListener(v -> startActivity(new Intent(this, SignUp.class)));
        dbRef = FirebaseDatabase.getInstance().getReference().child("Accounts");

        sigIn.setOnClickListener(v-> {
            verifyInfo(usernameField.getText().toString(), passwordField.getText().toString());
            startActivity(new Intent(this, HomePage.class));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void verifyInfo(String usernameInput, String passwordInput) {
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snap : snapshot.getChildren()) {
                    String username = snap.child("username").getValue(String.class);
                    String password = snap.child("password").getValue(String.class);
                    String email = snap.child("email").getValue(String.class);
                    assert username != null;
                    assert password != null;
                    if(username.equals(usernameInput)) {
                        if (password.equals(passwordInput)) {
                            currentUser = new AccountInformation(username, email, password);
                            Toast.makeText(SignIn.this, "Welcome", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(SignIn.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                        }
                        return;
                    }
                }
                Toast.makeText(SignIn.this, "No user found.", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}