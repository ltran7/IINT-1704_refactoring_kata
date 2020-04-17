package com.gildedrose;

class Sulfuras extends ExtendedItem {

    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    public void decreaseSellIn() {
        return;
    }

    @Override
    public void manageQuality(boolean isExpired) {
        return;
    }

    @Override
    public void manageExpirationDate(boolean isExpired) {
        return;
    }

}