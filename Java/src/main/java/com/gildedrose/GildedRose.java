package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality()
    {
        for(int i = 0; i < items.length; i++)
        {
            items[i].quality = incrementQualityValue(items[i]);
            items[i].sellIn = incrementSellinValue(items[i]);
        }
    }

    private int incrementQualityValue(Item item)
    {
        switch(item.name)
        {
            case "Aged Brie":
            {
                int itemQuality;
                int increaseQualityBy = 0;

                if(item.sellIn < 0)
                {
                    increaseQualityBy += 2;
                }
                else
                {
                    increaseQualityBy += 1;
                }

                item.quality = item.quality + increaseQualityBy;

                if(item.quality > 50)
                {
                    return 50;
                }
                else
                {
                    return item.quality;
                }
            }
            case "Sulfuras, Hand of Ragnaros":
            {
                // Quality does not change
                return item.quality;
            }
            case "Backstage passes to a TAFKAL80ETC concert":
            {
                int qualityValue = item.quality;

                if(item.sellIn > 10)
                {
                    item.quality = item.quality + 1;
                }
                else if(item.sellIn <= 10 && item.sellIn >= 6)
                {
                    item.quality = item.quality + 2;
                }
                else if(item.sellIn <= 5 && item.sellIn >= 1)
                {
                    item.quality = item.quality + 3;
                }
                else
                {
                    return 0;
                }

                if(item.quality > 50)
                {
                    return 50;
                }
            }
            default:
            {
                int decreaseQualityValue = 1;

                if(item.sellIn < 0)
                {
                    decreaseQualityValue = 2;
                }

                item.quality = item.quality - decreaseQualityValue;

                if(item.quality < 0)
                {
                    return 0;
                }
            }
        }
    }

    private int incrementSellinValue(Item item)
    {
        switch(item.name)
        {
            case "Sulfuras, Hand of Ragnaros":
            {
                // Sellin does not change
                return item.sellIn;
            }
            default:
            {
                if(item.sellIn < 0)
                {
                    return item.sellIn - 2;
                }
                else
                {
                    return item.sellIn - 1;
                }
            }
        }
    }


    // public void updateQuality() 
    // {
    //     for (int i = 0; i < items.length; i++) {
    //         if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    //             if (items[i].quality > 0) {
    //                 if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
    //                     items[i].quality = items[i].quality - 1;
    //                 }
    //             }
    //         } else {
    //             if (items[i].quality < 50) { 
    //                 items[i].quality = items[i].quality + 1;

    //                 if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    //                     if (items[i].sellIn < 11) {
    //                         if (items[i].quality < 50) {
    //                             items[i].quality = items[i].quality + 1;
    //                         }
    //                     }

    //                     if (items[i].sellIn < 6) {
    //                         if (items[i].quality < 50) {
    //                             items[i].quality = items[i].quality + 1;
    //                         }
    //                     }
    //                 }
    //             }
    //         }

    //         if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
    //             items[i].sellIn = items[i].sellIn - 1;
    //         }

    //         if (items[i].sellIn < 0) {
    //             if (!items[i].name.equals("Aged Brie")) {
    //                 if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
    //                     if (items[i].quality > 0) {
    //                         if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
    //                             items[i].quality = items[i].quality - 1;
    //                         }
    //                     }
    //                 } else {
    //                     items[i].quality = items[i].quality - items[i].quality;
    //                 }
    //             } else {
    //                 if (items[i].quality < 50) {
    //                     items[i].quality = items[i].quality + 1;
    //                 }
    //             }
    //         }
    //     }
    // }
}
