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
                int increaseQualityBy;

                if(item.sellIn > 0)
                {
                    increaseQualityBy = 1;
                }
                else
                {
                    increaseQualityBy = 2;
                }

                int quality = item.quality + increaseQualityBy;

                if(quality > 50)
                {
                    return 50;
                }
                else
                {
                    return quality;
                }
            }
            case "Sulfuras, Hand of Ragnaros":
            {
                // Quality does not change
                return item.quality;
            }
            case "Backstage passes to a TAFKAL80ETC concert":
            {
                int quality = item.quality;

                if(item.sellIn > 10)
                {
                    quality += 1;
                }
                else if(item.sellIn <= 10 && item.sellIn >= 6)
                {
                    quality += 2;
                }
                else if(item.sellIn <= 5 && item.sellIn >= 1)
                {
                    quality += 3;
                }
                else
                {
                    return 0;
                }

                if(quality > 50)
                {
                    return 50;
                }

                return quality;
            }
            default:
            {
                int decreaseQualityValue = 1;

                if(item.sellIn <= 0)
                {
                    decreaseQualityValue = 2;
                }

                int newQuality = item.quality - decreaseQualityValue;

                if(newQuality < 0)
                {
                    return 0;
                }

                return newQuality;
            }
        }
    }

    private int incrementSellinValue(Item item) 
    {
    	if(item.name.equals("Sulfuras, Hand of Ragnaros")) 
    	{
    		return item.sellIn;
    	}
    	else 
    	{
    		return item.sellIn - 1;
    	}
    	
    }
}
