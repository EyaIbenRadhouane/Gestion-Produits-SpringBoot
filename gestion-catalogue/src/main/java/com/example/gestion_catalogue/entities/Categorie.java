package com.example.gestion_catalogue.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@Getter
@Setter
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Categorie {

    @Id //Clé Primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
    private Long id;
    @Column(unique = true) //le nom est unique
    private String nom;
    //L’attribut mappedBy = "categorie" dans l’annotation @OneToMany indique à JPA que la rela-
    //tion est bidirectionnelle, mais que c’est l’entité Produit (qui possède l’attribut categorie)
    //
    //qui est "propriétaire" de la relation en base de données. En termes SQL, cela signifie que JPA
    //va créer une clé étrangère categorie_id dans la table produits, et non une table de jointure.
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Indispensable pour éviter la boucle infinie JSON lors de la sérialisation
    private List<Produit> produits;
}