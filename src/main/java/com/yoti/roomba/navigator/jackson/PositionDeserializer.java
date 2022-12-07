package com.yoti.roomba.navigator.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.yoti.roomba.navigator.model.Position;

import java.io.IOException;

public class PositionDeserializer extends StdDeserializer<Position> {
    static final long serialVersionUID = 1L;

    public PositionDeserializer() {
        this(null);
    }

    protected PositionDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Position deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        ArrayNode node = parser.readValueAsTree();
        return new Position(node.get(0).asInt(), node.get(1).asInt());
    }
}
