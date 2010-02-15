package de.db12.database;



public interface DBHandler {
	public enum dbtype {
		hsql, derby
	}
	
	void startServer();
	boolean isRunning();
//	public DataSource getDataSource();
	void stopServer();

}
