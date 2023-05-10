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

class BoroughTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Borough borough;

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
		borough = em.find(Borough.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		borough = null;
	}

	@Test
	void Borough_test() {
		assertNotNull(borough);
		assertEquals("Álvaro Obregón", borough.getName());
	}

	@Test
	void Borough_OTM_mapping_User_test() {
		assertNotNull(borough);
		assertTrue(borough.getUsers().size() > 0);
	}

}
