package org.sheasepherd.ghostnet;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class MarkersView implements Serializable {

    private MapModel<Long> simpleModel;

    @Inject
    GhostNetController ghostNetController;

    @PostConstruct
    public void init() {
        try {
            simpleModel = new DefaultMapModel<>();
            List<GhostNet> ghostNets = ghostNetController.allGhostNets();

            for(GhostNet g: ghostNets) {
                simpleModel.addOverlay(new Marker<>(new LatLng(g.getLatitude(), g.getLongitude()), g.getEstimatedSize(), g.getId()));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public MapModel<Long> getSimpleModel() {
        return simpleModel;
    }

}
