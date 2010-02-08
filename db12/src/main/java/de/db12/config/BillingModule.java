package de.db12.config;

import javax.persistence.EntityManager;

import org.eclipse.persistence.internal.jpa.EntityManagerImpl;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(EntityManager.class).to(EntityManagerImpl.class);
	}
}