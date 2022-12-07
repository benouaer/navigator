package com.yoti.roomba.navigator.model;


public class NavigationResponse {

    /**
     * {
     *   "coords" : [1, 3],
     *   "patches" : 1
     * }
     */

    private Position coords;
    private int patches;

    public NavigationResponse() {}

    public NavigationResponse(Position coords, int patches) {
        this.coords = coords;
        this.patches = patches;
    }

    public Position getCoords() {
        return coords;
    }

    public int getPatches() {
        return patches;
    }
}
