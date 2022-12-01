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
    @Inject
    RescuerRepository rescuerRepository;

    private GhostNet ghostNet;
    private Rescuer rescuer;


    private long selectedNet;

    @PostConstruct
    public void init() {
        ghostNet = new GhostNet();
        rescuer = new Rescuer();
    }

    public List<GhostNet> allGhostNets() {
        return ghostNetRepository.findAll();
    }

    public GhostNet getGhostNetByID(long id) {
        return ghostNetRepository.getGhostNet(id);
    }

//    public List<GhostNet> selectedGhostNets() { return ghostNetRepository.filterAll(); }

    public String addGhostNet(GhostNet ghostNet) {
        try {
            ghostNetRepository.save(ghostNet);
           return backToHome();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return null;
    }

    public GhostNet getGhostNet() {
        return ghostNet;
    }

    public void setGhostNet(GhostNet ghostNet) {
        this.ghostNet = ghostNet;
    }

    public Rescuer getRescuer() {
        return rescuer;
    }

    public void setRescuer(Rescuer rescuer) {
        this.rescuer = rescuer;
    }

    public String addRescuer(Rescuer rescuer) {
        try{
            ghostNet = getGhostNetByID(this.selectedNet);
            ghostNet.setRescuer(rescuer);
            String newState = ghostNet.getGhostNetStateEnum().getNextState();
            ghostNet.setState(newState);
            ghostNet.setGhostNetStateEnum(ghostNet.getGhostNetStateEnum().nextState());
            rescuerRepository.save(rescuer);
            ghostNetRepository.update(ghostNet);
            return backToHome();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return null;
    }

    public long getSelectedNet() {
        return selectedNet;
    }

    public void setSelectedNet(long selectedNet) {
        this.selectedNet = selectedNet;
    }

    public String rescueNet() {
        return "rescueNet?faces-redirect=true";
    }

    public String backToHome() {
        return "index?faces-redirect=true";
    }
}
