package org.sheasepherd.ghostnet;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SessionScoped
@Named
public class App implements Serializable {

    private static App instance;
    private final EntityManagerFactory entityManagerFactory;

    public App() {
        instance = this;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ghost_net_db");
        } catch (Exception e) {
            throw new IllegalStateException("Can't create database connection.", e);
        }
    }

    public static App getInstance()
    {
        if ( instance == null ) instance = new App();
        return instance;
    }


    public List<GhostNet> getGhostNets()
    {
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            Query q = em.createQuery("select g from GhostNet g");
            List<GhostNet> ghostNets = q.getResultList();
            if(ghostNets.size() == 0) {
                System.err.println("No Ghostnets found initiating");
                ghostNets = basisNets();
                for(GhostNet g: ghostNets) {
                    em.getTransaction().begin();
                    em.persist(g);
                    em.getTransaction().commit();
                }
            }
            em.close();

            return ghostNets;
        } catch (Exception e) {
            e.printStackTrace();
            return basisNets();
        }
    }

    private List<GhostNet> basisNets() {
        List<GhostNet> list = new LinkedList<>();
        list.add(new GhostNet(45.821044, -10.737615, "200cm"));
        list.add(new GhostNet(44.872751, -15.916663, "220cm"));
        list.add(new GhostNet(50.248277, 0.289105, "100cm"));
        list.add(new GhostNet(39.302288, 5.865443, "900cm"));

        return list;
    }

    private List<GhostNet> populateInitialApp() {
        List<GhostNet> l = new LinkedList<GhostNet>();
        l.add(new GhostNet(45.821044, -10.737615, "200cm"));
        l.add(new GhostNet(44.872751, -15.916663, "220cm"));
        l.add(new GhostNet(39.302288, 5.865443, "900cm"));
        return l;
    }

    private void saveToDb() {

        GhostNet ghostNet = new GhostNet(41.23, -100.123, "10000cm");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(ghostNet);
        em.getTransaction().commit();
        em.close();
    }



}
