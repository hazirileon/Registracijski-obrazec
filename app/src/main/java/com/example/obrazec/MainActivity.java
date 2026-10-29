package com.example.obrazec;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etUsername, etFullName, etCountry, etEmail, etPhone, etPassword;
    private RadioGroup rgGender;
    private CheckBox cbTerms;
    private Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etUsername = findViewById(R.id.etUsername);
        etFullName = findViewById(R.id.etFullName);
        etCountry = findViewById(R.id.etCountry);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        rgGender = findViewById(R.id.rgGender);
        cbTerms = findViewById(R.id.cbTerms);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);


        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegistrationDetails();
            }
        });
    }

    private void showRegistrationDetails() {

        String username = etUsername.getText().toString().trim();
        String fullName = etFullName.getText().toString().trim();
        String country = etCountry.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        int selectedGenderId = rgGender.getCheckedRadioButtonId();


        boolean hasError = false;
        if (username.isEmpty()) {
            etUsername.setError("Username is required");
            hasError = true;
        }
        if (fullName.isEmpty()) {
            etFullName.setError("Full name is required");
            hasError = true;
        }
        if (country.isEmpty()) {
            etCountry.setError("Country is required");
            hasError = true;
        }
        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            hasError = true;
        }
        if (phone.isEmpty()) {
            etPhone.setError("Phone is required");
            hasError = true;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            hasError = true;
        }


        if (hasError || selectedGenderId == -1) {
            Toast.makeText(MainActivity.this, "Please fill in all fields and select a gender!", Toast.LENGTH_LONG).show();
            return;
        }


        RadioButton selectedRadioButton = findViewById(selectedGenderId);
        String gender = selectedRadioButton.getText().toString();


        String termsAccepted = cbTerms.isChecked() ? "Yes" : "No";


        String detailsMessage = "Username: " + username + "\n" +
                "Name: " + fullName + "\n" +
                "Country: " + country + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n" +
                "Password: " + password + "\n" +
                "Gender: " + gender + "\n" +
                "Terms Accepted: " + termsAccepted;


        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Registration Details")
                .setMessage(detailsMessage)
                .setPositiveButton("OK", null)
                .show();
    }
}
