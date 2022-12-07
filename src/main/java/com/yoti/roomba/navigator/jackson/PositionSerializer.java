package com.yoti.roomba.navigator.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.yoti.roomba.navigator.model.Position;

import java.io.IOException;

public class PositionSerializer extends StdSerializer<Position> {
    static final long serialVersionUID = 1L;

    public PositionSerializer() {
        this(null);
    }

    public PositionSerializer(Class<Position> t) {
        super(t);
    }

    @Override
    public void serialize(Position position, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        int[] positionArray = { position.getxCoordinate(), position.getyCoordinate() };
        jsonGenerator.writeArray(positionArray,0, 2);
    }
}
