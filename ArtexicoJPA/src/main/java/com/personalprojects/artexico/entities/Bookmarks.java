package com.personalprojects.artexico.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "user_has_bookmarked_artwork")
public class Bookmarks {
	@EmbeddedId
	private BookmarksKey id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@MapsId(value = "user")
	private User user;

	@ManyToOne
	@JoinColumn(name = "artwork_id")
	@MapsId(value = "artwork")
	private Artwork artwork;

	public Bookmarks() {
		super();
	}

	public Bookmarks(BookmarksKey id, User user, Artwork artwork) {
		super();
		this.id = id;
		this.user = user;
		this.artwork = artwork;
	}

	public BookmarksKey getId() {
		return id;
	}

	public void setId(BookmarksKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artwork, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bookmarks other = (Bookmarks) obj;
		return Objects.equals(artwork, other.artwork) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Bookmarks [id=" + id + ", user=" + user + ", artwork=" + artwork + "]";
	}

}
