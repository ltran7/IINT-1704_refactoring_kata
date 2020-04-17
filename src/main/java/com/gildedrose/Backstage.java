package com.gildedrose;

class Backstage extends ExtendedItem {

    public Backstage(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void manageQuality(boolean isExpired) {
        if (quality < 50) {
            quality += !isExpired ? 1 : 2;

            if (sellIn < 6) {
                quality += 2;
            } else if (sellIn < 11) {
                quality += 1;
            }
            if (quality > 50) {
                quality = 50;
            }
        }
    }

    @Override
    public void manageExpirationDate(boolean isExpired) {
        if (isExpired) {
            quality -= quality;
        }
    }

}