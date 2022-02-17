package com.slinger.greenfieldworld.model.player;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
public class PlayerName {

    @NonNull
    String name;

}