package com.example.assu2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private List<News> newsList = new ArrayList<>();
    private NewsListFragment newsListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialiser le fragment de la liste d'actualités avec la méthode newInstance
        newsListFragment = NewsListFragment.newInstance(new ArrayList<>(newsList));
        replaceFragment(newsListFragment);

        // Gérer le clic sur le bouton "Ajouter" pour afficher AddNewsFragment
        ImageButton addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(v -> replaceFragment(new AddNewsFragment()));

        // Initialiser la barre de navigation inférieure
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Gérer la navigation de la barre de navigation inférieure
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_declaration_sinistre) {
                // Démarrer l'activité SinistreActivity lorsque l'élément "Déclaration de Sinistre" est sélectionné
                startActivity(new Intent(HomeActivity.this, SinistreActivity.class));
                return true;
            } else if (id == R.id.nav_actualite) {
                // Afficher la liste des actualités
                replaceFragment(newsListFragment);
                return true;
            }
            return false;
        });
    }

    // Méthode pour ajouter une nouvelle actualité à la liste et mettre à jour le fragment
    public void addNews(News news) {
        newsList.add(news);
        if (newsListFragment != null) {
            newsListFragment.updateNewsList(newsList);
        }
    }

    // Méthode pour remplacer les fragments
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null) // Permet la navigation vers l'arrière avec le bouton retour
                .commit();
    }
}
