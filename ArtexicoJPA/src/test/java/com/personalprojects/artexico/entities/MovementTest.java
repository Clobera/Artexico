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

class MovementTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Movement movement;

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
		movement = em.find(Movement.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		movement = null;
	}

	@Test
	void Movement_test() {
		assertNotNull(movement);
		assertEquals("Contemporary", movement.getName());
	}
	
	@Test
	void Movement_MTM_mapping_Artwork_test() {
		assertNotNull(movement);
		assertTrue(movement.getArtworks().size() > 0);
	}

}
