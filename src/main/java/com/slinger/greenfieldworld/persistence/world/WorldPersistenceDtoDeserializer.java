package com.slinger.greenfieldworld.persistence.world;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.RegionName;
import com.slinger.greenfieldworld.model.world.regions.Plain;
import com.slinger.greenfieldworld.model.world.regions.Region;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WorldPersistenceDtoDeserializer extends JsonDeserializer<WorldPersistenceDto> {

    @Override
    public WorldPersistenceDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        WorldPersistenceDto dto = null;

        int x = -1;
        int y = -1;
        RegionName regionName;

        Map<Coordinate, Region> regionMap = new HashMap<>();

        int id = -1;
        String name;

        boolean continueParsing = true;

        while (continueParsing) {

            String fieldName = p.nextFieldName();

            if (fieldName != null) {

                switch (fieldName) {

                    case "x":
                        x = p.nextIntValue(-1);
                        break;

                    case "y":
                        y = p.nextIntValue(-1);
                        break;

                    case "regionName":
                        regionName = RegionName.fromString(p.nextTextValue());

                        Region region = new Plain(Coordinate.of(x, y));

                        switch (regionName) {

                            case PLAIN:
                                region = new Plain(Coordinate.of(x, y));
                                break;
                            case FOREST:
//                                region = new Plains(Coordinate.of(x, y));
                                break;
                            case WATER:
//                                region = new Plains(Coordinate.of(x, y));
                                break;
                            case MOUNTAIN:
//                                region = new Plains(Coordinate.of(x, y));
                                break;
                            default:
                                region = new Plain(Coordinate.of(x, y));
                        }

                        regionMap.put(region.getCoordinate(), region);

                        break;

                    case "id":
                        id = p.nextIntValue(-1);
                        break;

                    case "name":
                        name = p.nextTextValue();

                        dto = new WorldPersistenceDto(regionMap, id, name);

                        continueParsing = false;
                        break;

                    default:
                }
            }
        }

        return dto;
    }
}
