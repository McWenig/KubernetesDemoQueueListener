package com.accenture.kubernetesdemo.queueapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.accenture.kubernetesdemo.queueapp.domain.Protocol;

/**
 * This class is used to access data for the Act entity. Repository annotation
 * allows the component scanning support to find and configure the DAO wihtout
 * any XML configuration and also provide the Spring exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the method.
 * If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class ProtocolDao {

	/**
	 * Save the Protocoll in the database.
	 */
	public void create(Protocol protocoll) {
		entityManager.persist(protocoll);
		return;
	}

	/**
	 * Delete the Protocoll from the database.
	 */
	public void delete(Protocol protocoll) {
		if (entityManager.contains(protocoll))
			entityManager.remove(protocoll);
		else
			entityManager.remove(entityManager.merge(protocoll));
		return;
	}

	/**
	 * Return all the Protocolls stored in the database.
	 */
	public List<Protocol> getAll() {
		return entityManager.createQuery("from Protocol", Protocol.class).getResultList();
	}

	/**
	 * Return the Protocoll having the passed id.
	 */
	public Protocol getById(long id) {
		return entityManager.find(Protocol.class, id);
	}

	/**
	 * Update the passed Protocoll in the database.
	 */
	public void update(Protocol act) {
		entityManager.merge(act);
		return;
	}

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;

}