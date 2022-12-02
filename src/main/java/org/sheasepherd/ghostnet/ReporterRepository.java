/*
 * Copyright (c) 2022. Julian Ammann
 */

package org.sheasepherd.ghostnet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
@Transactional
@ApplicationScoped
public class ReporterRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Reporter r) {
        entityManager.persist(r);
    }

    public void update(Reporter r) {
        entityManager.merge(r);
    }

    public List<Reporter> findAll() {
        return entityManager.createQuery("from " + Reporter.class.getSimpleName() + " r", Reporter.class).getResultList();
    }

    public Reporter getReporter(long id) {
        return entityManager.createQuery("from " + Reporter.class.getSimpleName() + " r WHERE r.id =" + id, Reporter.class).getSingleResult();
    }
}
