package com.slinger.greenfieldworld.model.world.events;

import com.slinger.greenfieldworld.model.common.DiceUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventChest {

    private final List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public Optional<Event> getRandomEvent() {

        if (events.isEmpty())
            return Optional.empty();

        int diceResult = DiceUtil.rollDice(100);

        List<Event> possibleEvents = events.stream().filter(event -> event.getChance() >= diceResult)
                .collect(Collectors.toList());

        if (possibleEvents.isEmpty())
            return Optional.empty();

        Collections.shuffle(possibleEvents);

        return Optional.of(possibleEvents.get(0));
    }
}