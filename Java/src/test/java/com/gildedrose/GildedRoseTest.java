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
    void sulfurasQualityAndSellinValues() 
    {
        Item[] items = new Item[] 
        { 
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        };

        GildedRose app = new GildedRose(items);

        //assertEquals(19, app.items[0].quality, "Quality should decrease by 1 for normal items");
        System.out.println("BEFORE Update: Sulfurus Item #1 - Sellin = " + app.items[0].sellIn + ", Quality = " + app.items[0].quality);
        System.out.println("BEFORE Update: Sulfurus Item #2 - Sellin = " + app.items[1].sellIn + ", Quality = " + app.items[1].quality);

        app.updateQuality();
        
     // First Sulfurus item
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);

        // Second Sulfurus item
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(80, app.items[1].quality);

        
        System.out.println("AFTER  Update: Sulfurus Item #1 - Sellin = " + app.items[0].sellIn + ", Quality = " + app.items[0].quality);
        System.out.println("AFTER  Update: Sulfurus Item #2 - Sellin = " + app.items[1].sellIn + ", Quality = " + app.items[1].quality);
    }

    @Test
    void testQualityNeverNegative() {
        // check that quality does not go negative for normal items
        Item[] items = new Item[] { new Item("Normal Item", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality, "Quality should never be negative");
    }

    @Test
    void qualityNeverExceedsFifty() {
        // check backstage passes, which can increase in quality, but should never exceed 50
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality, "Quality should never exceed 50");
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
