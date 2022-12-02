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
    @Inject
    ReporterRepository reporterRepository;

    private GhostNet ghostNet;
    private Rescuer rescuer;

    private Reporter reporter;

    private long selectedNet;

    @PostConstruct
    public void init() {
        ghostNet = new GhostNet();
        rescuer = new Rescuer();
        reporter = new Reporter();
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

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public String addRescuer(Rescuer rescuer, long id) {
        try {
            ghostNet = getGhostNetByID(id);
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

    public String addReporter(Reporter reporter, long id) {
        try {
            ghostNet = getGhostNetByID(id);
            ghostNet.setReporter(reporter);
            ghostNet.setState(GhostNetState.Lost.getState());
            ghostNet.setGhostNetStateEnum(GhostNetState.Lost);
            reporterRepository.save(reporter);
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

    public String rescueNet(long id) {
        setSelectedNet(id);
        return "rescueNet?faces-redirect=true&includeViewParams=true";
    }

    public String reportNet() {
        return "reportNet?faces-redirect=true";
    }

    public String lostNet(long id) {
        setSelectedNet(id);
        return "lostNet?faces-redirect=true&includeViewParams=true";
    }

    public String recoverNet(long id) {
        try {
            ghostNet = getGhostNetByID(id);
            String newState = ghostNet.getGhostNetStateEnum().getNextState();
            ghostNet.setState(newState);
            ghostNet.setGhostNetStateEnum(ghostNet.getGhostNetStateEnum().nextState());
            ghostNetRepository.update(ghostNet);
            return backToHome();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        return null;
    }

    public String backToHome() {
        return "index?faces-redirect=true";
    }
}
