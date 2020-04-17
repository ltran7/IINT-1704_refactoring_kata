package com.gildedrose;

class Conjured extends ExtendedItem {

    public Conjured(int sellIn, int quality) {
        super("Conjured Mana Cake", sellIn, quality);
    }

    @Override
    public void manageQuality(boolean isExpired) {
        quality -= !isExpired ? 2 : 4;
        if (quality < 0) {
            quality = 0;
        }
    }

    @Override
    public void manageExpirationDate(boolean isExpired) {
        return;
    }

}