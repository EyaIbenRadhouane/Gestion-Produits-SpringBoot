package com.example.gestion_catalogue.respository;

import com.example.gestion_catalogue.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
