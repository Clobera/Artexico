package com.personalprojects.artexico.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "artwork_medium")
public class ArtworkMedium {
	// ---------- ENTITIES ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	// --- ENTITES WITH RELATIONSHIPS---
	@JsonIgnore
	@OneToMany(mappedBy = "artworkMedium")
	private List<Artwork> artwork;

	// ---------- CONSTRUCTORS ----------
	public ArtworkMedium() {
		super();
	}

	public ArtworkMedium(int id, String name, List<Artwork> artwork) {
		super();
		this.id = id;
		this.name = name;
		this.artwork = artwork;
	}

	// GETTERS & SETTERS, HASHCODE AND EQUALS, AND TO-STRING
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Artwork> getArtwork() {
		return artwork;
	}

	public void setArtwork(List<Artwork> artwork) {
		this.artwork = artwork;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtworkMedium other = (ArtworkMedium) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "ArtworkMedium [id=" + id + ", name=" + name + ", artwork=" + artwork + "]";
	}

}
