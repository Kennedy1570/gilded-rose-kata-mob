package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 2, 7) };
        System.out.println("BEFORE: sellIn=" + items[0].sellIn + ", quality=" + items[0].quality);
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        System.out.println("AFTER:  sellIn=" + items[0].sellIn + ", quality=" + items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }
    
    

}
