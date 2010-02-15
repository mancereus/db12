package de.db12.database;

import java.io.IOException;
import java.net.ServerSocket;

import junit.framework.Assert;

import org.hsqldb.persist.HsqlProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HsqlDBHandlerTest {

	private HsqlDBHandler dbHandler;

	@Before
	public void setUp() throws Exception {
		dbHandler = new HsqlDBHandler();
	}

	@After
	public void tearDown() throws Exception {
		dbHandler.stopServer();
	}

	@Test
	public void testOpenInstance() {
		
	}

	@Test
	public void testStartServer() {
		dbHandler.startServer();
		Assert.assertTrue(dbHandler.isRunning());
		Assert.assertFalse(isPortAvailable(9001));
	}

	@Test
	public void testStopServer() {
		dbHandler.startServer();
		Assert.assertTrue(dbHandler.isRunning());
		dbHandler.stopServer();
		Assert.assertFalse(dbHandler.isRunning());

	}

	private static boolean isPortAvailable(int port) {
		try {
			ServerSocket srv = new ServerSocket(port);
			srv.close();
			srv = null;
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
