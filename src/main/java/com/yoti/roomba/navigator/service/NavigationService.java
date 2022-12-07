package com.yoti.roomba.navigator.service;

import com.yoti.roomba.navigator.model.NavigationRequest;
import com.yoti.roomba.navigator.model.NavigationResponse;
import com.yoti.roomba.navigator.model.Position;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavigationService {

    public NavigationResponse navigate(NavigationRequest request) {
        Position targetPosition = request.getCoords();
        List<Position> visitedPatches = new ArrayList<>();

        for (int i = 0; i < request.getInstructions().length; i++) {
            Position startPosition = targetPosition;

            targetPosition = calculateNextPosition(startPosition, request.getInstructions()[i], request.getRoomSize());

            updatePatches(request.getPatches(), targetPosition, visitedPatches);

        }
        return new NavigationResponse(targetPosition, visitedPatches.size());
    }

    private Position calculateNextPosition(Position startPosition, String instruction, Position limit) {
        int nextXCoordinate = startPosition.getxCoordinate();
        int nextYCoordinate = startPosition.getyCoordinate();

        switch (instruction) {
            case "N" ->
                    nextYCoordinate = nextYCoordinate < limit.getyCoordinate() ? ++nextYCoordinate : nextYCoordinate;
            case "S" ->
                    nextYCoordinate = nextYCoordinate > 0 ? --nextYCoordinate : nextYCoordinate;
            case "E" ->
                    nextXCoordinate = nextXCoordinate < limit.getxCoordinate() ? ++nextXCoordinate : nextXCoordinate;
            case "W" ->
                    nextXCoordinate = nextXCoordinate > 0 ? --nextXCoordinate : nextXCoordinate;
        }
        return new Position(nextXCoordinate, nextYCoordinate);
    }

    private List<Position> updatePatches(List<Position> patches, Position currentPosition, List<Position> visitedPatches) {
        boolean foundPatch = patches.stream().anyMatch(patch -> patch.equals(currentPosition));
        if (foundPatch && !visitedPatches.contains(currentPosition)) {
            visitedPatches.add(currentPosition);
        }
        return visitedPatches;
    }
}
