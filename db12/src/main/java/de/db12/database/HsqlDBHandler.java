package de.db12.database;

import java.io.File;
import java.io.IOException; 
import java.sql.Connection;

import javax.sql.DataSource;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl.AclFormatException;

import de.db12.database.DBHandler;

public class HsqlDBHandler implements DBHandler {

	private Server server;
	private HsqlProperties hsqlprops;

	public HsqlDBHandler() {
		HsqlProperties p = new HsqlProperties();
		File dbdir = new File("c:/dev/db/hsqldb");
		dbdir.mkdirs();
		p.setProperty("server.database.0","file:" + dbdir);
		p.setProperty("server.dbname.0","db12");
		this.hsqlprops = p;
	}

	@Override
	public void startServer() {
		if (server == null) {
			server = new Server();
//			server.setLogWriter(null); // can use custom writer
//			server.setErrWriter(null); // can use custom writer
		}
		try {
			server.setProperties(hsqlprops);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (AclFormatException e) {
			e.printStackTrace();
		}
		if (!isServerRunning())
			server.start();
	}
	@Override
	public boolean isServerRunning() {
		try {
			server.checkRunning(true);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	
	@Override
	public void stopServer() {
		if (isServerRunning())
			server.stop();
	}



}