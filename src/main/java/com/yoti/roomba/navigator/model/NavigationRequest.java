package com.yoti.roomba.navigator.model;

import java.util.List;

public class NavigationRequest {

    /**
     * {
     *   "roomSize" : [5, 5],
     *   "coords" : [1, 2],
     *   "patches" : [
     *     [1, 0],
     *     [2, 2],
     *     [2, 3]
     *   ],
     *   "instructions" : "NNESEESWNWW"
     * }
      */

    private Position roomSize;

    private Position coords;

    private List<Position> patches;

    private String instructions;

    public NavigationRequest() {}

    public NavigationRequest(Position roomSize, Position coords, List<Position> patches, String instructions) {
        this.roomSize = roomSize;
        this.coords = coords;
        this.patches = patches;
        this.instructions = instructions;
    }

    public Position getRoomSize() {
        return roomSize;
    }

    public Position getCoords() {
        return coords;
    }

    public List<Position> getPatches() {
        return patches;
    }

    public String[] getInstructions() {
        return this.instructions.split("");
    }
}
