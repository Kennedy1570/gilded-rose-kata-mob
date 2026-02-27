package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void sulfurasQualityAndSellinValues() 
    {
        Item[] items = new Item[] 
        { 
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        };

        GildedRose app = new GildedRose(items);

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
}
