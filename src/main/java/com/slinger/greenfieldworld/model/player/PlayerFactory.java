package com.slinger.greenfieldworld.model.player;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {

    List<Player> playerList = new ArrayList<>();

    public Player createPlayer(String name) {

        return Player.builder()
                .playerId(PlayerId.of(playerList.size() + 1))
                .playerName(PlayerName.of(name))
                .build();
    }
}
