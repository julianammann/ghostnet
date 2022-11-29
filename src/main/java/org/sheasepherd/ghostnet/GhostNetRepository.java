package org.sheasepherd.ghostnet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
@ApplicationScoped
public class GhostNetRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(GhostNet g) {
        entityManager.persist(g);
    }

    public void update(GhostNet g) {
        entityManager.merge(g);
    }

    public List<GhostNet> findAll() {
        return entityManager.createQuery("from " + GhostNet.class.getSimpleName() + " g", GhostNet.class).getResultList();
    }
}
