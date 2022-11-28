package org.sheasepherd.ghostnet;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@RequestScoped
@Named
public class GhostNetController {

    @Inject
    GhostNetRepository ghostNetRepository;

    private GhostNet ghostNet;

    @PostConstruct
    public void init() {
        ghostNet = new GhostNet();
    }

    public List<GhostNet> allGhostNets() {
        return ghostNetRepository.findAll();
    }

    public String addGhostNet(GhostNet ghostNet) {
        try {
            ghostNetRepository.save(ghostNet);
            return "index";
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            return "reportNet";
        }
    }

    public GhostNet getGhostNet() {
        return ghostNet;
    }

    public void setGhostNet(GhostNet ghostNet) {
        this.ghostNet = ghostNet;
    }

    public String updateGhostNet(GhostNet ghostNet) {


        try {
            ghostNetRepository.update(ghostNet);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return "rescueNet.xhtml";
    }
}
