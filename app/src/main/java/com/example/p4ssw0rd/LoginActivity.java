package com.example.p4ssw0rd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;


  class LoginActivity extends AppCompatActivity {
      private lateinit var binding: LoginActivity
      private lateinit var auth: FirebaseAuth
    public LoginActivity() {
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LoginActivity.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.root);

        auth = Firebas.auth
                binding.ConfirmarBtn.setOnclickListener{
            auth.signInWithEmailAndPassword(binding.email.getText.toString().trim(),binding.password.getText.toString().trim())
                    .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    val intent = Intent (this, MainActivity::class.java)
                    startActivity(intent);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                            ).show()
                    updateUI(null)
                }
            }
        }

        public override fun onStart() {
            super.onStart()
            // Check if user is signed in (non-null) and update UI accordingly.
            val currentUser = auth.currentUser
            if (currentUser != null) {
                val intente = Intent(this, MainActivity::class.java)
                startActivity(intent);
            }
        }

        binding.move.setOnclickListener{View
            val intente = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void cadastro(View v){
        Intent i = new Intent(this,CadastroActivity.class);
        startActivity(i);
    }
}