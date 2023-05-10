package com.personalprojects.artexico.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArtworkTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Artwork artwork;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("ArtexicoJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		artwork = em.find(Artwork.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		artwork = null;
	}

	@Test
	void Artwork_test() {
		assertNotNull(artwork);
		assertEquals("test", artwork.getTitle());
	}
	
	@Test
	void Artwork_MTO_mapping_ArtMedium_test() {
		assertNotNull(artwork);
		assertEquals("Medium Test", artwork.getArtworkMedium().getName());
	}

	@Test
	void Artwork_MTO_mapping_Theme_test() {
		assertNotNull(artwork);
		assertEquals("Theme test", artwork.getTheme().getName());
	}
	
	@Test
	void Artwork_MTO_mapping_User_test() {
		assertNotNull(artwork);
		assertEquals("Carlos", artwork.getArtist().getFirstName());
	}
	
	@Test
	void Artwork_MTM_mapping_User_test() {
		Artwork artwork2 = em.find(Artwork.class, 2);
		assertNotNull(artwork2);
		assertTrue(artwork2.getBookmarks().size() > 0);
	}
	
	@Test
	void Artwork_MTM_mapping_Materials_test() {
		assertNotNull(artwork);
		assertTrue(artwork.getMaterials().size() > 0);
	}
	
}
