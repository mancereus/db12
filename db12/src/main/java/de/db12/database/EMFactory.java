package de.db12.database;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.common.collect.Maps;

import de.db12.database.handler.DBHandler.DBType;

public class EMFactory {
	private static Map<DBType, EntityManagerFactory> factorymap = Maps
			.newEnumMap(DBType.class);

	public static EntityManager getEntityManager(DBType dbtype) {
		if (factorymap.get(dbtype) == null)
			factorymap.put(dbtype, Persistence
					.createEntityManagerFactory(dbtype.name()));
		return factorymap.get(dbtype).createEntityManager();
	}
}
