package com.slinger.greenfieldworld.model.world;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WorldRepositoryTest {

    /* TODO: User in-memory-file-system from JIMFS. */
    private static final File FOLDER = new File("WorldRepositoryTestFiles");

    private final WorldRepository sut = new WorldRepository();

    @BeforeAll
    public static void setUp() {

        boolean directoryExists = FOLDER.exists();

        boolean directoryCreated = FOLDER.mkdir();

        if (directoryExists)
            assertFalse(directoryCreated);
        else
            assertTrue(directoryCreated);
    }

    @Test
    public void createdWorldIsNotNull() {

        /* Given, When */
        World world = sut.createWorld("creation_test");

        /* Then */
        assertNotNull(world);
    }

    @Test
    public void savedFileEqualsSavedWorld() throws IOException {

        /* Given */
        WorldGenerator worldGenerator = new WorldGenerator();

        World expectedWorld = worldGenerator.generateWorld("saving_test");

        PlayerGenerator playerGenerator = new PlayerGenerator();

        expectedWorld.spawnPlayerAtCenter(playerGenerator.generatePlayer("Sl1ng3r"));

        /* When */
        sut.saveWorld(expectedWorld, FOLDER);

        /* Then */
        ObjectReader or = new ObjectMapper().reader();
        World actualWorld = or.readValue(new File(FOLDER, "world_saving_test.json"), World.class);

        assertEquals(expectedWorld.getId(), actualWorld.getId());
    }

    @Test
    public void loadedWorldEqualsLoadedFile() {

        /* Given */
        World expectedWorld = World.builder().id(1).name("loading_test").build();

        sut.saveWorld(expectedWorld, FOLDER);

        /* When */
        World actualWorld = sut.loadStateFromFile(new File(FOLDER, "world_loading_test.json"));

        /* Then */
        assertEquals(expectedWorld.getId(), actualWorld.getId());
    }
}