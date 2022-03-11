package com.slinger.greenfieldworld.model.world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.world.regions.Region;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Builder(access = AccessLevel.PUBLIC)
@JsonIgnoreProperties(ignoreUnknown = true)
public class World {

    private static final int DEFAULT_REGION_GRID_SIDE_LENGTH = 5;

    private final Map<Coordinate, Region> regionMap = new HashMap<>();

    @Getter
    private long id;

    @Getter
    private String name;

    @Getter
    @Builder.Default
    private int gridSideLength = DEFAULT_REGION_GRID_SIDE_LENGTH;

    private World(long id, String name, int gridSideLength) {

        this.id = id;
        this.name = name;
        this.gridSideLength = gridSideLength;
    }

    public Map<Coordinate, Region> getUnmodifiableRegionMap() {
        return Collections.unmodifiableMap(regionMap);
    }

    public void addRegion(Region region) {
        regionMap.put(region.getCoordinate(), region);
    }

    public Region getRegion(Coordinate coordinate) {
        return regionMap.get(coordinate);
    }

    public void spawnPlayerAtCenter(Player player) {

        int spawnSideValue = gridSideLength / 2;

        Coordinate spawnPosition = Coordinate.of(spawnSideValue, spawnSideValue);

        Region spawnRegion = regionMap.get(spawnPosition);

        if (spawnRegion == null)
            throw new IllegalStateException(MessageUtil.format("Can't spawn player. Region at coordinate" +
                    " {0}/{1} does not exist.", spawnPosition.getX(), spawnPosition.getY()));

        player.spawn(this, spawnRegion);
    }
}