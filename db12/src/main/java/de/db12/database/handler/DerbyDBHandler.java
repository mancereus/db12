package de.db12.database.handler;

import java.io.File;
import java.io.IOException; 
import java.sql.Connection;

import javax.sql.DataSource;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl.AclFormatException;

import de.db12.database.handler.DBHandler;

public class DerbyDBHandler implements DBHandler {

//	private Server server;
//	private HsqlProperties hsqlprops;

	public DerbyDBHandler() {
//		HsqlProperties p = new HsqlProperties();
//		File dbdir = new File("c:/dev/db/hsqldb");
//		dbdir.mkdirs();
//		p.setProperty("server.database.0","file:" + dbdir);
//		p.setProperty("server.dbname.0","db12");
//		this.hsqlprops = p;
	}

	@Override
	public void startServer() {
//		if (server == null) {
//			server = new Server();
////			server.setLogWriter(null); // can use custom writer
////			server.setErrWriter(null); // can use custom writer
//		}
//		try {
//			server.setProperties(hsqlprops);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (AclFormatException e) {
//			e.printStackTrace();
//		}
//		if (!isServerRunning())
//			server.start();
	}
	@Override
	public boolean isRunning() {
//		try {
//			server.checkRunning(true);
//			return true;
//		} catch (RuntimeException e) {
//			return false;
//		}
		return true;
	}
	
	@Override
	public void stopServer() {
//		if (isServerRunning())
//			server.stop();
	}



}