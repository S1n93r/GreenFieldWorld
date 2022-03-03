package com.slinger.greenfieldworld.persistence.world;

import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.regions.Plain;
import com.slinger.greenfieldworld.model.world.regions.Region;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WorldPersistenceDtoTest {

    @Test
    public void createdWorldPersistenceDtoIsNotNull() {

        /* Given, When */
        Map<Coordinate, Region> regionMap = new HashMap<>();

        WorldPersistenceDto sut = new WorldPersistenceDto(regionMap, 1, "Test-Dto");

        /* Then */
        assertNotNull(sut);
    }

    @Test
    public void convertToWorldHasSameValues() {

        /* Given */
        Map<Coordinate, Region> regionMap = new HashMap<>();

        Plain plainA = new Plain(Coordinate.of(0, 0));
        Plain plainB = new Plain(Coordinate.of(0, 0));
        Plain plainC = new Plain(Coordinate.of(0, 0));

        regionMap.put(plainA.getCoordinate(), plainA);
        regionMap.put(plainB.getCoordinate(), plainB);
        regionMap.put(plainC.getCoordinate(), plainC);

        WorldPersistenceDto sut = new WorldPersistenceDto(regionMap, 1, "Test-Dto");

        /* When */
        World world = sut.toWorld();

        /* Then */
        assertEquals(sut.getId(), world.getId());
        assertEquals(sut.getName(), world.getName());
        assertEquals(sut.getRegionMap(), world.getUnmodifiableRegionMap());
    }

    @Test
    public void convertOfWorldHasSameValues() {

        /* Given */
        World world = World.builder().id(1).name("Test-World").build();

        Plain plainA = new Plain(Coordinate.of(0, 0));
        Plain plainB = new Plain(Coordinate.of(1, 0));
        Plain plainC = new Plain(Coordinate.of(2, 0));

        world.addRegion(plainA);
        world.addRegion(plainB);
        world.addRegion(plainC);

        /* When */
        WorldPersistenceDto sut = WorldPersistenceDto.ofWorld(world);

        /* Then */
        assertEquals(world.getId(), sut.getId());
        assertEquals(world.getName(), sut.getName());
        assertEquals(world.getUnmodifiableRegionMap(), sut.getRegionMap());
    }
}