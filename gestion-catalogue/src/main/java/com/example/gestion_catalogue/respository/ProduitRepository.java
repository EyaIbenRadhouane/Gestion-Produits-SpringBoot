package com.example.gestion_catalogue.respository;

import com.example.gestion_catalogue.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long>{
    //derived Query
    public List<Produit> findNomContains(String mc);
    //JPGL
    @Query("select p from Produit p where p.nom like %:x%")
    public List<Produit>rechercheParMotCle(@Param("x")String mc);
}


