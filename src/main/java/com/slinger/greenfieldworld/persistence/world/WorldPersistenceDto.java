package com.slinger.greenfieldworld.persistence.world;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.regions.Region;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@Value
@EqualsAndHashCode
@JsonDeserialize(using = WorldPersistenceDtoDeserializer.class)
public class WorldPersistenceDto {

    Map<Coordinate, Region> regionMap;

    long id;

    String name;

    public WorldPersistenceDto(Map<Coordinate, Region> regionMap, long id, String name) {

        this.regionMap = regionMap;
        this.id = id;
        this.name = name;
    }

    public static WorldPersistenceDto ofWorld(World world) {

        Map<Coordinate, Region> regionMap = new HashMap<>();
        regionMap.putAll(world.getUnmodifiableRegionMap());

        WorldPersistenceDto dto = new WorldPersistenceDto(regionMap, world.getId(), world.getName());

        dto.regionMap.putAll(world.getUnmodifiableRegionMap());

        return dto;
    }

    public World toWorld() {

        World world = World.builder().id(id).name(name).build();

        for (Region region : regionMap.values()) {
            world.addRegion(region);
        }

        return world;
    }
}