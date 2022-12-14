package com.yoti.roomba.navigator.service;

import com.yoti.roomba.navigator.model.NavigationRequest;
import com.yoti.roomba.navigator.model.NavigationResponse;
import com.yoti.roomba.navigator.model.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class NavigationServiceTest {

    @Mock
    private PersistenceService persistenceService;

    @InjectMocks
    private final NavigationService navigationService = new NavigationService();

    @Test
    public void shouldReturnTargetPosition() {

        final NavigationRequest navigationRequest = new NavigationRequest(
                new Position(3, 3),
                new Position(1,0),
                List.of(new Position(1,2), new Position(2,2)),
                "NNEENNEWS"
        );

        NavigationResponse navigationResponse = navigationService.navigate(navigationRequest);

        assertEquals(navigationResponse.getPatches(), 2);
        assertEquals(navigationResponse.getCoords(), new Position(2, 2));
    }
}
