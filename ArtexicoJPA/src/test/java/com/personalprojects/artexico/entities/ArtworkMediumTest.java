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

class ArtworkMediumTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private ArtworkMedium artworkMedium;

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
		artworkMedium = em.find(ArtworkMedium.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		artworkMedium = null;
	}

	@Test
	void ArtworkMedium_test() {
		assertNotNull(artworkMedium);
		assertEquals("Medium Test", artworkMedium.getName());
	}
	
	@Test
	void User_OTM_mapping_Artwork_test() {
		assertNotNull(artworkMedium);
		assertTrue(artworkMedium.getArtwork().size() > 0);
	}
	

}
