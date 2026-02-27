package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normalItem_decreasesQualityByOne() {
        Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].quality);

    }
    @Test
    void normalItem_decreasesSellnByone(){
        Item[] items = new Item[] { new Item("Normal Item", 10, 20 ) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        //Assert
        assertEquals(9, app.items[0].sellIn);
    }


}
