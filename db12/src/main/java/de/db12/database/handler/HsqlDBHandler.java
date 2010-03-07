package de.db12.database.handler;

import java.io.File;
import java.io.IOException; 
import java.sql.Connection;

import javax.sql.DataSource;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl.AclFormatException;

import de.db12.database.handler.DBHandler;

public class HsqlDBHandler implements DBHandler {

	private static final String DB12 = "db12";
	private Server server;
	private HsqlProperties hsqlprops;

	public HsqlDBHandler() {
		HsqlProperties p = new HsqlProperties();
		File dbdir = new File("c:/dev/db/hsqldb/");
		dbdir.mkdirs();
		p.setProperty("server.database.0","file:" + dbdir + "/" + DB12);
		p.setProperty("server.dbname.0",DB12);
		p.setProperty("server.database.1","mem:" +DB12);
		p.setProperty("server.dbname.1",DB12 + "mem");
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
		if (!isRunning())
			server.start();
	}
	@Override
	public boolean isRunning() {
		try {
			server.checkRunning(true);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	
	@Override
	public void stopServer() {
		if (isRunning())
			server.stop();
	}

	public static void main(String[] args) {
		new HsqlDBHandler().startServer();
	}

}