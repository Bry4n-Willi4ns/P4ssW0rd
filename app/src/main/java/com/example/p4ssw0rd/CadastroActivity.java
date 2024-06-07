package com.example.p4ssw0rd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {
    private lateinit var binding:CadastroActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = Firebas.auth
                binding.confirmarBtn.setOnclickListener{it:View!
                auth.createUserWithEmailAndPassword(binding.email.getText.toString().trim(), binding.password.getText.toString().trim())
                        .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "createUserWithEmail:success")
                val user = auth.currentUser
                val intent = Intent (this, MainActivity::class.java)
                startActivity(intent);
                updateUI(user)
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                        ).show()

            }
        }}
        binding = LoginActivity.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.root);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.move.setOnclickListener{View
            val intente = Intent(this, LoginActivity::class.java)
            startActivity(intent);
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent);
        }
    }
}