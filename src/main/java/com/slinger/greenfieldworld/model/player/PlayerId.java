package com.slinger.greenfieldworld.model.player;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
public class PlayerId {

    int id;

}