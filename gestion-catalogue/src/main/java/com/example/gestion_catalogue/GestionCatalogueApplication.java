package com.example.gestion_catalogue;


import com.example.gestion_catalogue.entities.Categorie;
import com.example.gestion_catalogue.entities.Produit;
import com.example.gestion_catalogue.respository.CategorieRepository;
import com.example.gestion_catalogue.respository.ProduitRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionCatalogueApplication {

	@Bean
	public CommandLineRunner commandLineRunner(
			ProduitRepository pr,
			CategorieRepository cr) {

		return args -> {

			Categorie c1 = new Categorie(
					null,
					"informatique",
					null
			);

			Categorie c2 = Categorie.builder()
					.nom("electronique")
					.build();

			cr.save(c1);
			cr.save(c2);

			pr.save(
					Produit.builder()
							.nom("pc")
							.quantite(5)
							.prix(5000)
							.categorie(c1)
							.build()
			);
			pr.save(
					Produit.builder()
							.nom("smartphone")
							.quantite(5)
							.prix(7000)
							.categorie(c2)
							.build()
			);
		};
	}
	public static void main(String[] args)
	{
		SpringApplication.run(GestionCatalogueApplication.class, args);
	}

}
