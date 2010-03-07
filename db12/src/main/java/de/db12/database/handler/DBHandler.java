package de.db12.database.handler;



public interface DBHandler {
	public enum DBType {
		hsql, derby
	}
	
	void startServer();
	boolean isRunning();
//	public DataSource getDataSource();
	void stopServer();

}
