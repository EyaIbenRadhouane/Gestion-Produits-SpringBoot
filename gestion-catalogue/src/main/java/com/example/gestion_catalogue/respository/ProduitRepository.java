package com.example.gestion_catalogue.respository;

import com.example.gestion_catalogue.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long>{
    // ================================================================
    // 1. DERIVED QUERIES ( Requetes derivees du nom de la methode )
    // ================================================================

    public List<Produit> findByNomContains(String mc);

    // ================================================================
    // 2. JPQL QUERIES ( Java Persistence Query Language )
    // ================================================================
    @Query("select p from Produit p where p.nom like %:x%")
    public List<Produit>rechercheParMotCle(@Param("x")String mc);
}


