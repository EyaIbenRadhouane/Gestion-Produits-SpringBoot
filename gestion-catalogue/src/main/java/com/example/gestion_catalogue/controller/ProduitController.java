package com.example.gestion_catalogue.controller;

import com.example.gestion_catalogue.entities.Produit;
import com.example.gestion_catalogue.service.IServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/produits")
@CrossOrigin("*") //pour que je puisse consommer ces apis avec un framework frontend

public class ProduitController {
    private IServiceProduit serviceProduit;

    @GetMapping("/all")
    public List<Produit> getAllProducts(){

        return serviceProduit.getAllProduits();
    }

    @GetMapping("/{id}")
    public Produit getById(@PathVariable Long id){

        return serviceProduit.getProduit(id);
    }

    @PostMapping("/search")
    public List<Produit> getProductsBKw(@RequestParam String mc){
        return serviceProduit.getProduitsParMC(mc);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){

        serviceProduit.supprimerProduit(id);
    }

    @PostMapping("/add")
    public void addProduit(@RequestBody Produit p){

        serviceProduit.ajouterProduit(p);
    }
    @PutMapping("update/{id}")
    public Produit updateProduit(@PathVariable Long id,@RequestBody Produit p){
         return serviceProduit.mettreAjourProduit(id,p);
        }

}
