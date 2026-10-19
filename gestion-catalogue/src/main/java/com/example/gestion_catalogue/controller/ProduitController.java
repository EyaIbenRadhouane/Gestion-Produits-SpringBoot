package com.example.gestion_catalogue.controller;

import com.example.gestion_catalogue.entities.Produit;
import com.example.gestion_catalogue.service.IServiceProduit;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produits")
@CrossOrigin("*") //pour que je puisse consommer ces api avec un framework frontend
public class ProduitController {
    private IServiceProduit serviceProduit;
    @GetMapping("/all")
    public List<Produit> getAllProducts(){
        return serviceProduit.getAllProduits();
    }
}
