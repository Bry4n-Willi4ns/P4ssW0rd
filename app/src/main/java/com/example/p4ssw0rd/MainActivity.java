package com.example.p4ssw0rd;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity {
    private lateinit var binding: MainActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = Firebas.auth
        binding = LoginActivity.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.root);


    }
}