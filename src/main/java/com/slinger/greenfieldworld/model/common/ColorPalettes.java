package com.slinger.greenfieldworld.model.common;

import lombok.Getter;

public enum ColorPalettes {

    WHITE("#ffffff"),

    /* https://www.color-hex.com/color-palette/2738 */
    BLUE_DARKEST("#0f5e9c"),
    BLUE_DARK("#2389da"),
    BLUE("#1ca3ec"),
    BLUE_LIGHT("#5abcd8"),
    BLUE_LIGHTEST("#74ccf4"),

    /* https://www.color-hex.com/color-palette/42770 */
    GREEN_DARKEST("#136d15 "),
    GREEN_DARK("#117c13"),
    GREEN_("#138510"),
    GREEN_LIGHT(" #268b07"),
    GREEN_LIGHTEST("#41980a"),

    /* https://www.color-hex.com/color-palette/27417 */
    STONE_WALL_A("#9098a3"),
    STONE_WALL_B("#9c9c9c"),
    STONE_WALL_C("#98a0a7"),
    STONE_WALL_D("#8c8d8d"),
    STONE_WALL_E("#8e9494"),
    STONE_WALL_DARK("#454545");

    @Getter
    private final String hexValue;

    ColorPalettes(String hexValue) {
        this.hexValue = hexValue;
    }
}