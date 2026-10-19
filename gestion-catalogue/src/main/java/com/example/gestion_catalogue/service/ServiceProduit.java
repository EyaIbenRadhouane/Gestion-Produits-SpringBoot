package com.example.gestion_catalogue.service;

import com.example.gestion_catalogue.entities.Produit;
import com.example.gestion_catalogue.respository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceProduit implements IServiceProduit{
    private ProduitRepository produitRepository;

    @Override
    public void ajouterProduit(Produit p) {

        produitRepository.save(p);
    }

    @Override
    public Produit mettreAjourProduit(Long id, Produit p) {
        Produit pp=getProduit(id);
        if(pp!=null){
            pp.setNom(p.getNom());
            pp.setPrix(p.getQuantite());
            pp.setQuantite(p.getQuantite());
            produitRepository.save(pp);
        }
        return pp;
    }

    @Override
    public void supprimerProduit(Long id) {

        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {

        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public List<Produit> getAllProduits() {

        return produitRepository.findAll();
    }

    @Override
    public List<Produit> getProduitsParMC(String mc) {
        return produitRepository.findByNomContains(mc);
    }
}
