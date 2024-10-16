package com.example.assu2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class AddNewsFragment extends Fragment {
    private EditText titleInput, descriptionInput, dateInput, timeInput;
    private ImageView imagePreview;
    private Button selectImageButton, saveNewsButton;

    private List<News> newsList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_news, container, false);

        titleInput = view.findViewById(R.id.news_title_input);
        descriptionInput = view.findViewById(R.id.news_description_input);
        dateInput = view.findViewById(R.id.news_date_input);
        timeInput = view.findViewById(R.id.news_time_input);
        imagePreview = view.findViewById(R.id.selected_image_preview);
        selectImageButton = view.findViewById(R.id.select_image_button);
        saveNewsButton = view.findViewById(R.id.save_news_button);

        saveNewsButton.setOnClickListener(v -> {
            // Crée un objet News avec les informations saisies
            String title = titleInput.getText().toString();
            String description = descriptionInput.getText().toString();
            String date = dateInput.getText().toString();
            String time = timeInput.getText().toString();

            News news = new News(title, description, date, time, R.drawable.ic_placeholder);

            // Appelle la méthode de HomeActivity pour ajouter l'actualité
            if (getActivity() instanceof HomeActivity) {
                ((HomeActivity) getActivity()).addNews(news);
                // Retourne à la page d'accueil
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}
