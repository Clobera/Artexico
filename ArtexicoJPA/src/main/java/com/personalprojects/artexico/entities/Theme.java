package com.personalprojects.artexico.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Theme {
	// ---------- ENTITIES ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	// --- ENTITES WITH RELATIONSHIPS---
	@JsonIgnore
	@OneToMany(mappedBy = "theme")
	private List<Artwork> artwork;

	// ---------- CONSTRUCTORS ----------
	public Theme() {
		super();
	}

	public Theme(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
		Theme other = (Theme) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", name=" + name + "]";
	}

}
