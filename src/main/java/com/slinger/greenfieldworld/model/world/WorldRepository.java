package com.slinger.greenfieldworld.model.world;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

public class WorldRepository {

    private static final String SAVE_FILE_PREFIX = "world_";
    private static final String SAVE_FILE_SUFFIX = ".json";

    private static final File DEFAULT_SAVE_FOLDER = new File("");

    public World createWorld(String name) {
        return World.builder().id(System.currentTimeMillis()).name(name).build();
    }

    public void saveWorld(World world) {
        saveWorld(world, DEFAULT_SAVE_FOLDER);
    }

    public void saveWorld(World world, File folder) {

        try {

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

            String fileName = SAVE_FILE_PREFIX + world.getName() + SAVE_FILE_SUFFIX;

            ow.writeValue(new File(folder, fileName), world);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public World loadStateFromFile(File file) {

        World world = null;

        try {

            ObjectReader or = new ObjectMapper().reader();
            world = or.readValue(file, World.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return world;
    }
}
