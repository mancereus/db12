package de.db12.database.handler;

public class DBHandlerFactory {
	public static DBHandler getHandler(DBHandler.DBType dbtype) {
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
