package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GildedRoseTest {

    @Test
    //checks that aged-brie quality increases by 1
    void agedBrieQualityIncreasedBy1() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }
    
    @Test
    //checks that aged-brie quality is capped at 50
    void agedBrieQualityNeverExceeds50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }
    
    @Test
    //checks that aged-brie quality increases by 2 after sellin < 0
    void agedBrieQualityIncreasesBy2() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 44) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(46, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    
    
    

}
