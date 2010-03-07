package de.db12.entity;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.db12.database.EMFactory;
import de.db12.database.handler.DBHandler;
import de.db12.database.handler.DBHandlerFactory;
import de.db12.database.handler.DBHandler.DBType;

public class JpaTest {
	private final static Logger log = LoggerFactory.getLogger(JpaTest.class);
	private static final DBType PERSISTENCE_UNIT_NAME = DBHandler.DBType.hsql;
	private static DBHandler handler = DBHandlerFactory
			.getHandler(PERSISTENCE_UNIT_NAME);

	@BeforeClass
	public static void setUpClass() throws Exception {
		handler.startServer();
	}

	@AfterClass
	public static void teardownClass() throws Exception {
		handler.stopServer();
	}

	@Before
	public void setUp() throws Exception {
		EntityManager em = EMFactory.getEntityManager(PERSISTENCE_UNIT_NAME);

		// Begin a new local transaction so that we can persist a new entity
		em.getTransaction().begin();

		// Read the existing entries
		Query q = em.createQuery("select m from Game m");
		// Persons should be empty

		// Do we have entries?
		boolean createNewEntries = (q.getResultList().size() == 0);

		// No, so lets create new entries
		if (createNewEntries) {
			assertTrue(q.getResultList().size() == 0);
			Game family = new Game();
			family.setName("Skat");
			em.persist(family);
		}
		em.getTransaction().commit();
		em.close();

	}

	@Test
	public void checkGames() {

		// Now lets check the database and see if the created entries are there
		// Create a fresh, new EntityManager
		EntityManager em = EMFactory.getEntityManager(PERSISTENCE_UNIT_NAME);

		// Perform a simple query for all the Message entities
		Query q = em.createQuery("select m from Game m");

		// We should have 40 Persons in the database
		assertTrue(q.getResultList().size() == 1);
		Game game = (Game) q.getResultList().get(0);
		log.info(game.toString());
		em.close();
	}

	@Test(expected = javax.persistence.NoResultException.class)
	public void deletePerson() {
		EntityManager em = EMFactory.getEntityManager(PERSISTENCE_UNIT_NAME);

		// Begin a new local transaction so that we can persist a new entity
		em.getTransaction().begin();
		Query q = em
				.createQuery("SELECT p FROM Game p WHERE p.name = :firstName");
		q.setParameter("firstName", "Skat2");
		Game user = (Game) q.getSingleResult();
		em.remove(user);
		em.getTransaction().commit();
		Game person = (Game) q.getSingleResult();
		// Begin a new local transaction so that we can persist a new entity

		em.close();
	}
}