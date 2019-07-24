package ac.kr.ajou.dirt;

public class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }


    public void UpdateQuality_And_SellIn() {


        for (int nth_count = 0; nth_count < items.length; nth_count++) {

            if(isSulfuras_HandOfRagnaros(items[nth_count], "Sulfuras, Hand of Ragnaros"))
                continue;

            MinusItemSellIn(nth_count);

            if (isAgedbrie(items[nth_count], "Aged Brie")) {
                updateQualityWhenIsAgedbrie(nth_count);
            }
            else if(isBackstagePassesToATAFKAL80ETCConcert(items[nth_count], "Backstage passes to a TAFKAL80ETC concert")){
                updateQualityWhenIsBackstagePassesToATAFKAL80ETCConcert(nth_count);
            }
            else{
                updateQualityWhenIsNeither(nth_count);
            }

        }

    }


    private void updateQualityWhenIsNeither(int nth_count) {
        if (items[nth_count].quality > 0 ) {
            MinusItemQuality(nth_count);
        }
        if (items[nth_count].sellIn < 0 && items[nth_count].quality > 0)
            MinusItemQuality(nth_count);
    }

    private void updateQualityWhenIsBackstagePassesToATAFKAL80ETCConcert(int nth_count) {
        if (items[nth_count].quality < 50) {
            PlusItemQuality(nth_count);
            if (items[nth_count].sellIn < 11 && items[nth_count].quality < 50) {
                PlusItemQuality(nth_count);
            }
            if (items[nth_count].sellIn < 6 && items[nth_count].quality < 50) {
                PlusItemQuality(nth_count);
            }
        }
        if (items[nth_count].sellIn < 0)
            items[nth_count].quality = 0;
    }

    private void updateQualityWhenIsAgedbrie(int nth_count) {
        if (items[nth_count].quality < 50) {
            PlusItemQuality(nth_count);
        }
        if (items[nth_count].sellIn < 0 && items[nth_count].quality < 50)
            PlusItemQuality(nth_count);
    }

    private boolean isBackstagePassesToATAFKAL80ETCConcert(Item item, String name) {
        return item.name.equals(name);
    }

    private boolean isSulfuras_HandOfRagnaros(Item item, String name) {
        return item.name.equals(name);
    }

    private boolean isAgedbrie(Item item, String name) {
        return item.name.equals(name);
    }


    private void MinusItemSellIn(int nth_count) {
        items[nth_count].sellIn = items[nth_count].sellIn - 1;
    }

    private void MinusItemQuality(int nth_count) {
        items[nth_count].quality = items[nth_count].quality - 1;
    }

    private void PlusItemQuality(int nth_count) {
        items[nth_count].quality = items[nth_count].quality + 1;
    }


}