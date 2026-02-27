package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

   private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void backstagePasses_IncreaseInQualityBy1_WhenMoreThan10DaysLeft() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality, "Should increase quality by 1 when sellIn > 10");
    }

    @Test
    void backstagePasses_IncreaseInQualityBy2_When10DaysOrLessLeft() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality, "Should increase quality by 2 when sellIn is 10");
    }

    @Test
    void backstagePasses_IncreaseInQualityBy3_When5DaysOrLessLeft() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 5, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality, "Should increase quality by 3 when sellIn is 5");
    }

    @Test
    void backstagePasses_QualityDropsTo0_AfterConcert() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality, "Quality should be 0 after the concert (sellIn < 0)");
    }
}
