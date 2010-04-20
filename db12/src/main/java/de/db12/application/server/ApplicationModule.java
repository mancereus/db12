package de.db12.application.server;

import javax.persistence.EntityManager;

import org.eclipse.persistence.internal.jpa.EntityManagerImpl;

import com.google.inject.AbstractModule;

public class ApplicationModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(EntityManager.class).to(EntityManagerImpl.class);
		
	}
}