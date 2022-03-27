package com.slinger.greenfieldworld.model.items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    public void nameWithConsonantAtBeginningGetsArticleA() {

        /* Given, When */
        Item sut = new Pear();

        /* When */
        String nameWithArticle = sut.getNameWithArticle();

        /* Then */
        assertEquals("a pear", nameWithArticle);
    }

    @Test
    public void nameWithVocalAtBeginningGetsArticleAn() {

        /* Given */
        Item sut = new Apple();

        /* When */
        String nameWithArticle = sut.getNameWithArticle();

        /* Then */
        assertEquals("an apple", nameWithArticle);
    }

    @Test
    public void increasingStackSizeByOneIncreasesStack() {

        /* Given */
        Item sut = new Apple();

        /* When */
        sut.increaseStackSize();

        /* Then */
        assertEquals(2, sut.getStackSize());
    }

    @Test
    public void increasingStackSizeIncreasesStack() {

        /* Given */
        Item sut = new Apple();

        /* When */
        sut.increaseStackSizeBy(5);

        /* Then */
        assertEquals(6, sut.getStackSize());
    }

    @Test
    public void increasingStackSizePassedMaxYieldsLeftovers() {

        /* Given */
        Item sut = new Apple();

        /* When */
        int leftovers = sut.increaseStackSizeBy(12);

        /* Then */
        assertEquals(3, leftovers);
    }

    @Test
    public void decreasingStackSizeByOneDecreasesStack() {

        /* Given */
        Item sut = new Apple();

        sut.increaseStackSizeBy(7);

        /* When */
        sut.decreaseStackSize();

        /* Then */
        assertEquals(7, sut.getStackSize());
    }

    @Test
    public void decreasingStackSizeDecreasesStack() {

        /* Given */
        Item sut = new Apple();

        sut.increaseStackSizeBy(7);

        /* When */
        sut.decreaseStackSizeBy(3);

        /* Then */
        assertEquals(5, sut.getStackSize());
    }

    @Test
    public void decreasingStackSizeBelowZeroMakesItZero() {

        /* Given */
        Item sut = new Apple();

        sut.increaseStackSizeBy(5);

        /* When */
        sut.decreaseStackSizeBy(9);

        /* Then */
        assertEquals(0, sut.getStackSize());
    }

    private static class Apple extends Item {

        @Override
        protected String setName() {
            return "apple";
        }

        @Override
        protected String setDescription() {
            return "Round, red and juicy.";
        }

        @Override
        protected int setMaxStackSize() {
            return 10;
        }
    }

    private static class Pear extends Item {

        @Override
        protected String setName() {
            return "pear";
        }

        @Override
        protected String setDescription() {
            return "Bulb shaped, green and sweet.";
        }

        @Override
        protected int setMaxStackSize() {
            return 10;
        }
    }
}