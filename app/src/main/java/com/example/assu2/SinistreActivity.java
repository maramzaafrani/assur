package com.example.assu2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SinistreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinstre);

        // Gérer le clic sur le bouton retour pour revenir à HomeActivity
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> onBackPressed());

        // Initialiser la barre de navigation inférieure
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Gérer la navigation de la barre de navigation inférieure
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_actualite) {
                // Démarrer l'activité HomeActivity lorsque l'élément "Actualités" est sélectionné
                startActivity(new Intent(SinistreActivity.this, HomeActivity.class));
                return true;
            } else if (id == R.id.nav_declaration_sinistre) {
                // Afficher le fragment DeclarationSinistreFragment
                replaceFragment(new DeclarationSinistreFragment());
                return true;
            }
            return false;
        });

        // Gérer le clic sur le bouton Add
        ImageButton addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(v -> {
            // Afficher le fragment DeclarationSinistreFragment
            replaceFragment(new DeclarationSinistreFragment());
        });
    }

    private void replaceFragment(Fragment fragment) {
        // Remplacer le fragment dans le FrameLayout
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null) // Ajoute à la pile de retour pour permettre de revenir en arrière
                .commit();
    }
}
