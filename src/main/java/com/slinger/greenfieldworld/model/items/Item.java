package com.slinger.greenfieldworld.model.items;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import lombok.Getter;

import java.util.Locale;

public abstract class Item {

    @Getter
    private final String name;

    protected Item() {
        this.name = setName();
    }

    protected abstract String setName();

    public String getNameWithArticle() {

        switch (name.substring(0, 1).toLowerCase(Locale.ROOT)) {

            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                return MessageUtil.format("an {0}", name);
            default:
                return MessageUtil.format("a {0}", name);
        }
    }
}