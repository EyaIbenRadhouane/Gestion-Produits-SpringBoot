package com.example.gestion_catalogue.service;

import com.example.gestion_catalogue.entities.Produit;

import java.util.List;

public interface IServiceProduit {
    void ajouterProduit(Produit p);
    Produit mettreAjourProduit(Long id, Produit p);
    void supprimerProduit(Long id);
    Produit getProduit(Long id);
    List<Produit> getAllProduits();
    List<Produit> getProduitsParMC(String mc);
}
