package org.sheasepherd.ghostnet;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@SessionScoped
@Named
public class AppController implements Serializable {

    private int index = 0;

    public GhostNet getGhostNet()
    {
        return App.getInstance().getGhostNets().get(index);
    }
}
