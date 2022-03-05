package com.slinger.greenfieldworld.model.creatures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NameChest {

    private final List<String> names = new ArrayList<>();

    public NameChest(String... names) {
        this.names.addAll(Arrays.asList(names));
    }

    public String giveRandomName() {

        if (names.isEmpty())
            throw new IllegalStateException("You can't ask an empty NameChest for a random name.");

        Collections.shuffle(names);

        return names.get(0);
    }
}