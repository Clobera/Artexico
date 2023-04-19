package com.personalprojects.artexico.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookmarksKey implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "user_id")
	private int user;
	@Column(name = "artwork_id")
	private int artwork;

	public BookmarksKey() {
		super();
	}

	public BookmarksKey(int user, int artwork) {
		super();
		this.user = user;
		this.artwork = artwork;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getArtwork() {
		return artwork;
	}

	public void setArtwork(int artwork) {
		this.artwork = artwork;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		BookmarksKey other = (BookmarksKey) obj;
		return artwork == other.artwork && user == other.user;
	}

}
