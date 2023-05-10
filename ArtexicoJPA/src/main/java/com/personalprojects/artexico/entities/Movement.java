package com.personalprojects.artexico.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Movement {
	// ---------- ENTITIES ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	// --- ENTITES WITH RELATIONSHIPS---
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "artwork_has_movement", joinColumns = @JoinColumn(name = "movement_id"), inverseJoinColumns = @JoinColumn(name = "artwork_id"))
	private List<User> artworks;

	// ------ ADD & REMOVE METHODS ------

	// ---------- CONSTRUCTORS ----------
	public Movement() {
		super();
	}

	public Movement(int id, String name, List<User> artworks) {
		super();
		this.id = id;
		this.name = name;
		this.artworks = artworks;
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

	public List<User> getArtworks() {
		return artworks;
	}

	public void setArtworks(List<User> artworks) {
		this.artworks = artworks;
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
		Movement other = (Movement) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Movement [id=" + id + ", name=" + name + ", artworks=" + artworks + "]";
	}

}
