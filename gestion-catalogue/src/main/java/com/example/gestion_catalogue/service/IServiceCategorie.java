package com.example.gestion_catalogue.service;

import com.example.gestion_catalogue.entities.Categorie;
import java.util.List;

public interface IServiceCategorie {
    void ajouterCategorie(Categorie c);
    Categorie mettreAjourCategorie(Long id, Categorie c);
    void supprimerCategorie(Long id);
    Categorie getCategorie(Long id);
    List<Categorie> getAllCategorie();
}
