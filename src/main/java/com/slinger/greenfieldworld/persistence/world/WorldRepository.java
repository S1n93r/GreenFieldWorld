package com.slinger.greenfieldworld.persistence.world;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.world.World;

import java.io.File;
import java.io.IOException;

public class WorldRepository {

    private static final String SAVE_FILE_PREFIX = "world_";
    private static final String SAVE_FILE_SUFFIX = ".json";

    private static final File DEFAULT_SAVE_FOLDER = new File("");

    public World loadWorld(String name) {

        World world = null;

        return world;
    }

    public void saveWorld(World world, File folder) {

        WorldPersistenceDto dto = WorldPersistenceDto.ofWorld(world);

        try {

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

            String fileName = SAVE_FILE_PREFIX + dto.getName() + SAVE_FILE_SUFFIX;

            ow.writeValue(new File(folder, fileName), dto);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* TODO: Loading is currently not working due to issues with regions maps and Coordinate class. */
    public World loadStateFromFile(File file) {

        WorldPersistenceDto dto = null;

        try {

            ObjectReader or = new ObjectMapper().reader();

            dto = or.readValue(file, WorldPersistenceDto.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (dto == null)
            throw new IllegalStateException(MessageUtil.format("Dto couldn't be loaded from file {0}." +
                    " File empty?", file.getName()));

        return dto.toWorld();
    }
}
