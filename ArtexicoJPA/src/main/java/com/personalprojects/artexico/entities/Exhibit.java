package com.personalprojects.artexico.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exhibit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String desctiption;
	
	private User artist;

	public Exhibit() {
		super();
	}

	public Exhibit(int id, String name, String desctiption, User artist) {
		super();
		this.id = id;
		this.name = name;
		this.desctiption = desctiption;
		this.artist = artist;
	}

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

	public String getDesctiption() {
		return desctiption;
	}

	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}

	public User getArtist() {
		return artist;
	}

	public void setArtist(User artist) {
		this.artist = artist;
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
		Exhibit other = (Exhibit) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Exhibit [id=" + id + ", name=" + name + ", desctiption=" + desctiption + ", artist=" + artist + "]";
	}
	
	
	

}
