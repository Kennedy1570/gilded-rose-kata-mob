package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GildedRoseTest {

    @Test
    void agedBrieQualityIncreasedBy1() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        System.out.println("BEFORE: sellIn=" + items[0].sellIn + ", quality=" + items[0].quality);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        System.out.println("AFTER:  sellIn=" + items[0].sellIn + ", quality=" + items[0].quality);
        //System.out.println("AFTER:  name=" + items[0].name);
        assertEquals(21, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }
    
    @Test
    void agedBrieQualityNeverExceeds50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        System.out.println("BEFORE: sellIn=" + items[0].sellIn + ", quality=" + items[0].quality);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        System.out.println("AFTER:  sellIn=" + items[0].sellIn + ", quality=" + items[0].quality);
        //System.out.println("AFTER:  name=" + items[0].name);
        assertEquals(50, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }
    
    @Test
    void agedBrieQualityIncreasesBy2() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 44) };
        System.out.println("BEFORE: sellIn=" + items[0].sellIn + ", quality=" + items[0].quality);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        System.out.println("AFTER:  sellIn=" + items[0].sellIn + ", quality=" + items[0].quality);
        //System.out.println("AFTER:  name=" + items[0].name);
        assertEquals(46, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
    
    
    

}
