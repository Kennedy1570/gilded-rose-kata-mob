package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GildedRoseTest {

   private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void backstagePasses_IncreaseInQualityBy1_WhenMoreThan10DaysLeft() 
    {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality, "Should increase quality by 1 when sellIn > 10");
    }

    @Test
    void backstagePasses_IncreaseInQualityBy2_When10DaysOrLessLeft() 
    {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality, "Should increase quality by 2 when sellIn is 10");
        
    }

    @Test
    void backstagePasses_IncreaseInQualityBy3_When5DaysOrLessLeft() 
    {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality, "Should increase quality by 3 when sellIn is 5");
    }

    @Test
    void backstagePasses_QualityDropsTo0_AfterConcert() 
    {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality, "Quality should be 0 after the concert (sellIn < 0)");
    }
    
    @Test
    void backstagePasses_QualityIncreasesBy2() 
    {
    	Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 9, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }
    @Test
    //checks that aged-brie quality increases by 1
    void agedBrieQualityIncreasedBy1() 
    {
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
    void testQualityNeverNegative() 
    {
        // check that quality does not go negative for normal items
        Item[] items = new Item[] { new Item("Normal Item", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality, "Quality should never be negative");
    }

    @Test
    void normalItem_decreasesSellnByone()
    {
        Item[] items = new Item[] { new Item("Normal Item", 10, 20 ) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        //Assert
        assertEquals(9, app.items[0].sellIn);
    }
    @Test
    void normalItem_decreasesQualityBy2()
    {
    	Item[] items = new Item[] { new Item("Normal Item", 0, 20 ) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        //Assert
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void qualityNeverExceedsFifty() 
    {
        // check backstage passes, which can increase in quality, but should never exceed 50
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality, "Quality should never exceed 50");
    }
    
    @Test
    //checks that aged-brie quality is capped at 50
    void agedBrieQualityNeverExceeds50() 
    {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }
    
    @Test
    //checks that aged-brie quality increases by 2 after sellin < 0
    void agedBrieQualityIncreasesBy2() 
    {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 44) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals(46, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }
}
