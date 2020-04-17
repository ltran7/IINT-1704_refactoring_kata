package com.gildedrose;

class AgedBrie extends ExtendedItem {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void manageQuality(boolean isExpired) {
        if (quality < 50) {
            quality += !isExpired ? 1 : 2;
            if (quality > 50) {
                quality = 50;
            }
        }
    }

    @Override
    public void manageExpirationDate(boolean isExpired) {
        return;
    }

}