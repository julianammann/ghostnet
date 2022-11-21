package org.sheasepherd.ghostnet;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@RequestScoped
@Named
public class GhostNetController {

    @Inject
    GhostNetRepository ghostNetRepository;

    public List<GhostNet> allGhostNets() {
        return ghostNetRepository.findAll();
    }


}
