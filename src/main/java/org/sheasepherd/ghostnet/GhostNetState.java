/*
 * Copyright (c) 2022. Julian Ammann
 */

package org.sheasepherd.ghostnet;

public enum GhostNetState {
    Reported {

        @Override
        public GhostNetState nextState() {
            return RecoveryImminent;
        };

        @Override
        public String getState() {
          return "reported";
        };
    },
    RecoveryImminent{
        @Override
        public GhostNetState nextState() {
            return Recovered;
        };

        @Override
        public String getState() {
            return "recoveryImminent";
        };
    },
    Recovered{
        @Override
        public GhostNetState nextState() {
            return this;
        };

        @Override
        public String getState() {
            return "recovered";
        };
    },
    Lost {
        @Override
        public GhostNetState nextState() {
            return this;
        };
        @Override
        public String getState() {
            return "lost";
        };
    };

    public abstract GhostNetState nextState();
    public abstract String getState();
}