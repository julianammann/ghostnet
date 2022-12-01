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
public class RescuerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Rescuer r) {
        entityManager.persist(r);
    }

    public void update(Rescuer r) {
        entityManager.merge(r);
    }

    public List<Rescuer> findAll() {
        return entityManager.createQuery("from " + Rescuer.class.getSimpleName() + " r", Rescuer.class).getResultList();
    }

    public Rescuer getRescuer(long id) {
        return entityManager.createQuery("from " + Rescuer.class.getSimpleName() + " r WHERE r.id =" + id, Rescuer.class).getSingleResult();
    }
}
