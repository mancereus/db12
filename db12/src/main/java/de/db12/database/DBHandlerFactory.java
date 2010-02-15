package de.db12.database;

public class DBHandlerFactory {
	public static DBHandler getHandler(DBHandler.dbtype dbtype) {
		switch (dbtype) {
		case hsql:
			return new HsqlDBHandler();
		case derby:
			return new DerbyDBHandler();
		default:
			return null;
		}
	}
}
