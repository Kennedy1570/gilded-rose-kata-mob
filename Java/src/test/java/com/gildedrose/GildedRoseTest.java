package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normalItem_decreasesQualityByOne() {
        Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].quality, "Quality should decrease by 1 for normal items");

    }

    @Test
    void testQualityNeverNegative() {
        Item[] items = new Item[] { new Item("Normal Item", 10, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality, "Quality should never be negative");
    }



}
