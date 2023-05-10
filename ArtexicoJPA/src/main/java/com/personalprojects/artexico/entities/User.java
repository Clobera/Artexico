package com.personalprojects.artexico.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	// ---------- ENTITIES ----------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private String username;

	private String password;

	private boolean enabled;

	private String role;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "image_url")
	private String imageUrl;

	private String bio;

	@Column(name = "account_type")
	private String accountType;

	// --- ENTITES WITH RELATIONSHIPS---
	@ManyToOne
	@JoinColumn(name = "borough_id")
	private Borough borough;

	@OneToMany(mappedBy = "artist")
	private List<Artwork> portfolio;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "user_has_bookmarked_artwork", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "artwork_id"))
	private List<Artwork> bookmarkedArt;

	// ----- ADD & REMOVE METHODS ------

	// ---------- CONSTRUCTORS ----------
	public User() {
		super();
	}

	public User(int id, String email, String username, String password, boolean enabled, String role, String firstName,
			String lastName, String imageUrl, String bio, String accountType, Borough borough, List<Artwork> portfolio,
			List<Artwork> bookmarkedArt) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.imageUrl = imageUrl;
		this.bio = bio;
		this.accountType = accountType;
		this.borough = borough;
		this.portfolio = portfolio;
		this.bookmarkedArt = bookmarkedArt;
	}

	// GETTERS & SETTERS, HASHCODE AND EQUALS, AND TO-STRING
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Borough getBorough() {
		return borough;
	}

	public void setBorough(Borough borough) {
		this.borough = borough;
	}

	public List<Artwork> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(List<Artwork> portfolio) {
		this.portfolio = portfolio;
	}

	public List<Artwork> getBookmarkedArt() {
		return bookmarkedArt;
	}

	public void setBookmarkedArt(List<Artwork> bookmarkedArt) {
		this.bookmarkedArt = bookmarkedArt;
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
		User other = (User) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", enabled=" + enabled + ", role=" + role + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", imageUrl=" + imageUrl + ", bio=" + bio + ", accountType=" + accountType + ", borough=" + borough
				+ ", portfolio=" + portfolio + ", bookmarkedArt=" + bookmarkedArt + "]";
	}

}
