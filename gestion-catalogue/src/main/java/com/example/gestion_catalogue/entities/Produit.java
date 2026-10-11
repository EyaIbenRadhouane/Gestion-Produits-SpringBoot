package com.example.gestion_catalogue.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "produits")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private double prix;

    private int quantite;
    @ManyToOne //plusieurs produits appartiennent à une catégorie
    @JoinColumn(name = "categorie_id") //nom de la colonne FK  en BD
    private Categorie categorie;
}
