package com.personalprojects.artexico.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Artwork {
	// ---------- ENTITIES ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private double price;

	private String image;

	@Column(name = "for_sale")
	private boolean forSale;

	private boolean enabled;

	@Column(name = "dimension_height")
	private int dimensionHeight;

	@Column(name = "dimension_width")
	private int dimensionWidth;

	@Column(name = "dimension_length")
	private int dimensionLength;

	@Column(name = "created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;

	// --- ENTITES WITH RELATIONSHIPS---
	@ManyToOne
	@JoinColumn(name = "medium_id")
	private ArtworkMedium artworkMedium;

	@ManyToOne
	@JoinColumn(name = "theme_id")
	private Theme theme;

	@ManyToOne
	@JoinColumn(name = "artist_id")
	private User artist;

	@ManyToMany(mappedBy = "bookmarkedArt")
	private List<User> bookmarks;

	@ManyToMany(mappedBy = "artworks")
	private List<Material> materials;

	@ManyToMany(mappedBy = "artworks")
	private List<Movement> movements;

	// ----- ADD & REMOVE METHODS ------

	// ---------- CONSTRUCTORS ----------
	public Artwork() {
		super();
	}

	public Artwork(int id, String title, double price, String image, boolean forSale, boolean enabled,
			int dimensionHeight, int dimensionWidth, int dimensionLength, LocalDateTime createdAt,
			ArtworkMedium artworkMedium, Theme theme, User artist, List<User> bookmarks, List<Material> materials,
			List<Movement> movements) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.image = image;
		this.forSale = forSale;
		this.enabled = enabled;
		this.dimensionHeight = dimensionHeight;
		this.dimensionWidth = dimensionWidth;
		this.dimensionLength = dimensionLength;
		this.createdAt = createdAt;
		this.artworkMedium = artworkMedium;
		this.theme = theme;
		this.artist = artist;
		this.bookmarks = bookmarks;
		this.materials = materials;
		this.movements = movements;
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

	public boolean isForSale() {
		return forSale;
	}

	public void setForSale(boolean forSale) {
		this.forSale = forSale;
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

	public ArtworkMedium getArtworkMedium() {
		return artworkMedium;
	}

	public void setArtworkMedium(ArtworkMedium artworkMedium) {
		this.artworkMedium = artworkMedium;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public User getArtist() {
		return artist;
	}

	public void setArtist(User artist) {
		this.artist = artist;
	}

	public List<User> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(List<User> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public List<Movement> getMovements() {
		return movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
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
		return "Artwork [id=" + id + ", title=" + title + ", price=" + price + ", image=" + image + ", forSale="
				+ forSale + ", enabled=" + enabled + ", dimensionHeight=" + dimensionHeight + ", dimensionWidth="
				+ dimensionWidth + ", dimensionLength=" + dimensionLength + ", createdAt=" + createdAt
				+ ", artworkMedium=" + artworkMedium + ", theme=" + theme + ", artist=" + artist + ", bookmarks="
				+ bookmarks + ", materials=" + materials + ", movements=" + movements + "]";
	}

}
