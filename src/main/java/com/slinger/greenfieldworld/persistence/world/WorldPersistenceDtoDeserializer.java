package com.slinger.greenfieldworld.persistence.world;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.RegionTypeName;
import com.slinger.greenfieldworld.model.world.regions.Region;
import com.slinger.greenfieldworld.model.world.regions.forest.BearCave;
import com.slinger.greenfieldworld.model.world.regions.forest.BrierWood;
import com.slinger.greenfieldworld.model.world.regions.forest.ForestRegionName;
import com.slinger.greenfieldworld.model.world.regions.forest.Glade;
import com.slinger.greenfieldworld.model.world.regions.mountain.MountainRegionName;
import com.slinger.greenfieldworld.model.world.regions.plain.FlowerBed;
import com.slinger.greenfieldworld.model.world.regions.plain.Hill;
import com.slinger.greenfieldworld.model.world.regions.plain.PlainRegionName;
import com.slinger.greenfieldworld.model.world.regions.plain.TallGrass;
import com.slinger.greenfieldworld.model.world.regions.water.HotSprings;
import com.slinger.greenfieldworld.model.world.regions.water.Lake;
import com.slinger.greenfieldworld.model.world.regions.water.River;
import com.slinger.greenfieldworld.model.world.regions.water.WaterRegionName;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WorldPersistenceDtoDeserializer extends JsonDeserializer<WorldPersistenceDto> {

    @Override
    public WorldPersistenceDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        WorldPersistenceDto dto = null;

        int x = -1;
        int y = -1;
        RegionTypeName regionTypeName;

        Map<Coordinate, Region> regionMap = new HashMap<>();

        int id = -1;
        String name;

        boolean continueParsing = true;

        Set<String> unparsedField = new HashSet<>();

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

                    case "regionTypeName":
                        regionTypeName = RegionTypeName.fromString(p.nextTextValue());

                        /* Default */
                        Region region = new FlowerBed(Coordinate.of(x, y));

                        String regionName = p.nextFieldName();

                        switch (regionTypeName) {

                            case PLAIN:

                                switch (PlainRegionName.fromString(regionName)) {

                                    case FLOWER_BED:
                                        region = new FlowerBed(Coordinate.of(x, y));
                                        break;

                                    case HILL:
                                        region = new Hill(Coordinate.of(x, y));
                                        break;

                                    case TALL_GRASS:
                                        region = new TallGrass(Coordinate.of(x, y));
                                        break;

                                    default:
                                        /* Default is declared before switch. */
                                }

                                break;

                            case FOREST:

                                switch (ForestRegionName.fromString(regionName)) {

                                    case BEAR_CAVE:
                                        region = new BearCave(Coordinate.of(x, y));
                                        break;

                                    case BRIER_WOOD:
                                        region = new BrierWood(Coordinate.of(x, y));
                                        break;

                                    case GLADE:
                                        region = new Glade(Coordinate.of(x, y));
                                        break;

                                    default:
                                        /* Default is declared before switch. */
                                }

                                break;

                            case WATER:

                                switch (WaterRegionName.fromString(regionName)) {

                                    case HOT_SPRINGS:
                                        region = new HotSprings(Coordinate.of(x, y));
                                        break;

                                    case LAKE:
                                        region = new Lake(Coordinate.of(x, y));
                                        break;

                                    case RIVER:
                                        region = new River(Coordinate.of(x, y));
                                        break;

                                    default:
                                        /* Default is declared before switch. */
                                }

                                break;

                            case MOUNTAIN:

                                switch (MountainRegionName.fromString(regionName)) {

                                    case ABANDONED_MINE:
                                        region = new Glade(Coordinate.of(x, y));
                                        break;

                                    case FOOTHILLS:
                                        region = new BearCave(Coordinate.of(x, y));
                                        break;

                                    case UPLANDS:
                                        region = new BrierWood(Coordinate.of(x, y));
                                        break;

                                    default:
                                        /* Default is declared before switch. */
                                }

                                break;

                            default:
                                /* Default is declared before switch. */
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
                        /* Some fields can be ignored. */
                }
            }
        }

        return dto;
    }
}
