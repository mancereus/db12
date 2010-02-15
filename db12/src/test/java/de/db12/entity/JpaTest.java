package de.db12.entity;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import de.db12.database.DBHandler;
import de.db12.database.DBHandlerFactory;
import de.db12.database.HsqlDBHandler;
import de.db12.database.DBHandler.dbtype;
import de.db12.entity.Game;

public class JpaTest {

	private static final dbtype PERSISTENCE_UNIT_NAME = DBHandler.dbtype.hsql;
	private EntityManagerFactory factory;
	private DBHandler handler = DBHandlerFactory.getHandler(PERSISTENCE_UNIT_NAME);

	@Before
	public void setUp() throws Exception {
		//handler.startServer();
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME.name());
		EntityManager em = factory.createEntityManager();

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
	public void checkAvailablePeople() {

		// Now lets check the database and see if the created entries are there
		// Create a fresh, new EntityManager
		EntityManager em = factory.createEntityManager();

		// Perform a simple query for all the Message entities
		Query q = em.createQuery("select m from Game m");

		// We should have 40 Persons in the database
		assertTrue(q.getResultList().size() == 1);

		em.close();
	}


	@Test(expected = javax.persistence.NoResultException.class)
	public void deletePerson() {
		EntityManager em = factory.createEntityManager();
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