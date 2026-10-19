package com.example.gestion_catalogue.controller;

import com.example.gestion_catalogue.entities.Categorie;
import com.example.gestion_catalogue.entities.Produit;
import com.example.gestion_catalogue.service.IServiceCategorie;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
@CrossOrigin("*") //pour que je puisse consommer ces apis avec un framework frontend

public class CategorieController {
    private IServiceCategorie serviceCategorie;

    @GetMapping("/all")
    public List<Categorie> getAllCategoryes(){

        return serviceCategorie.getAllCategorie();
    }

    @GetMapping("/{id}")
    public Categorie getById(@PathVariable Long id){

        return serviceCategorie.getCategorie(id);
    }
    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        serviceCategorie.supprimerCategorie(id);
    }

    @PostMapping("/add")
    public void addCategorie(@RequestBody Categorie c){

        serviceCategorie.ajouterCategorie(c);
    }

    @PutMapping("update/{id}")
    public Categorie updateCategorie(@PathVariable Long id,@RequestBody Categorie c){
        return serviceCategorie.mettreAjourCategorie(id,c);
    }

}
