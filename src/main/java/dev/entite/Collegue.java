package dev.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coll")
public class Collegue {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	@Column
	private float score;
	@Column(length = 100)
	private String pseudo;
	@Column(length = 100)
	private String UrlImage;
	
	
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getUrlImage() {
		return UrlImage;
	}
	public void setUrlImage(String urlImage) {
		UrlImage = urlImage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
