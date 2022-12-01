/*
 * Copyright (c) 2022. Julian Ammann
 */

package org.sheasepherd.ghostnet;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        GhostNet g = new GhostNet(43.1213, 39.123, "20cm", "reported");

        Rescuer r = new Rescuer("Julian", "Ammann", "0123456789");

        g.setRescuer(r);
        System.out.println(g.getRescuer().getFirstname());
    }

}
