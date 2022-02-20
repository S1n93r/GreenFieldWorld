package com.slinger.greenfieldworld.model.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    List<Player> playerList = new ArrayList<>();

    public Player createPlayer(String name) {

        Player player = Player.builder()
                .id(playerList.size() + 1)
                .name(name)
                .build();

        playerList.add(player);

        return player;
    }

    public String saveStateToFile() {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        String json = "";

        try {
            json = ow.writeValueAsString(playerList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    public void loadStateFromFile() {

    }
}
