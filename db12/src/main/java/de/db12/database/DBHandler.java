package de.db12.database;



public interface DBHandler {

	void startServer();
	boolean isServerRunning();
//	public DataSource getDataSource();
	void stopServer();

}
