package com.example.assu2;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DeclarationSinistreFragment extends Fragment {
    private EditText nomInput, prenomInput, emailInput, adresseInput, matriculeInput, typeVoitureInput, dateInput;
    private Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_declaration_sinistre, container, false);

        nomInput = view.findViewById(R.id.nom_input);
        prenomInput = view.findViewById(R.id.prenom_input);
        emailInput = view.findViewById(R.id.email_input);
        adresseInput = view.findViewById(R.id.adresse_input);
        matriculeInput = view.findViewById(R.id.matricule_input);
        typeVoitureInput = view.findViewById(R.id.type_voiture_input);
        dateInput = view.findViewById(R.id.date_input);
        submitButton = view.findViewById(R.id.submit_button);

        submitButton.setOnClickListener(v -> {
            // Récupérer les données saisies
            String nom = nomInput.getText().toString();
            String prenom = prenomInput.getText().toString();
            String email = emailInput.getText().toString();
            String adresse = adresseInput.getText().toString();
            String matricule = matriculeInput.getText().toString();
            String typeVoiture = typeVoitureInput.getText().toString();
            String date = dateInput.getText().toString();

            // Valider les données et les traiter
            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || adresse.isEmpty() || matricule.isEmpty() || typeVoiture.isEmpty() || date.isEmpty()) {
                Toast.makeText(getContext(), "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            } else {
                // Logique pour soumettre la déclaration de sinistre (à compléter selon vos besoins)
                Toast.makeText(getContext(), "Déclaration soumise avec succès", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
