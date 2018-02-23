package dev.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entite.Collegue;
import dev.entite.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
	List<Commentaire> findByCol(Collegue col);
}