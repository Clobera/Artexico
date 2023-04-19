package com.personalprojects.artexico.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Artwork {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private double price;

	private String image;

	private boolean sold;

	private boolean enabled;

	private int dimensionHeight;

	private int dimensionWidth;

	private int dimensionLength;

	@Column(name = "created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name = "medium_id")
	private ArtworkMedium artworkMedium;
	
	@ManyToOne
	@JoinColumn(name = "theme_id")
	private Theme theme;
	
	@ManyToOne
	@JoinColumn(name = "artist_id")
	private User artist;

	public Artwork() {
		super();
	}

	public Artwork(int id, String title, double price, String image, boolean sold, boolean enabled, int dimensionHeight,
			int dimensionWidth, int dimensionLength, LocalDateTime createdAt, User artist,
			ArtworkMedium artworkMedium) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.image = image;
		this.sold = sold;
		this.enabled = enabled;
		this.dimensionHeight = dimensionHeight;
		this.dimensionWidth = dimensionWidth;
		this.dimensionLength = dimensionLength;
		this.createdAt = createdAt;
		this.artist = artist;
		this.artworkMedium = artworkMedium;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getDimensionHeight() {
		return dimensionHeight;
	}

	public void setDimensionHeight(int dimensionHeight) {
		this.dimensionHeight = dimensionHeight;
	}

	public int getDimensionWidth() {
		return dimensionWidth;
	}

	public void setDimensionWidth(int dimensionWidth) {
		this.dimensionWidth = dimensionWidth;
	}

	public int getDimensionLength() {
		return dimensionLength;
	}

	public void setDimensionLength(int dimensionLength) {
		this.dimensionLength = dimensionLength;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public User getArtist() {
		return artist;
	}

	public void setArtist(User artist) {
		this.artist = artist;
	}

	public ArtworkMedium getArtworkMedium() {
		return artworkMedium;
	}

	public void setArtworkMedium(ArtworkMedium artworkMedium) {
		this.artworkMedium = artworkMedium;
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
		Artwork other = (Artwork) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Artwork [id=" + id + ", title=" + title + ", price=" + price + ", image=" + image + ", sold=" + sold
				+ ", enabled=" + enabled + ", dimensionHeight=" + dimensionHeight + ", dimensionWidth=" + dimensionWidth
				+ ", dimensionLength=" + dimensionLength + ", createdAt=" + createdAt + ", artist=" + artist
				+ ", artworkMedium=" + artworkMedium + "]";
	}

}
