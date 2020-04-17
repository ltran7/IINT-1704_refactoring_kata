package com.gildedrose;

abstract class ExtendedItem extends Item {

    public ExtendedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void updateQuality() {
        decreaseSellIn();
        manageQuality(sellIn < 0);
        manageExpirationDate(sellIn < 0);
    }

    protected void decreaseSellIn() {
        sellIn--;
    }

    protected abstract void manageQuality(boolean isExpired);

    protected abstract void manageExpirationDate(boolean isExpired);

}