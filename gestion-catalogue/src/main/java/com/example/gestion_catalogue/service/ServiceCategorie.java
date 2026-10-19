package com.example.gestion_catalogue.service;

import com.example.gestion_catalogue.entities.Categorie;
import com.example.gestion_catalogue.respository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceCategorie implements IServiceCategorie{
    private CategorieRepository categorieRepository;
    @Override
    public void ajouterCategorie(Categorie c) {
        categorieRepository.save(c);
    }

    @Override
    public Categorie mettreAjourCategorie(Long id, Categorie c) {
        Categorie categorie=getCategorie(id);
        if(categorie!=null){
            categorie.setNom(c.getNom());
            categorieRepository.save(categorie);
        }
        return categorie;
    }

    @Override
    public void supprimerCategorie(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }
}
