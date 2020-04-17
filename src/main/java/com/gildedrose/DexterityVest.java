package com.gildedrose;

class DexterityVest extends ExtendedItem {

    public DexterityVest(int sellIn, int quality) {
        super("+5 Dexterity Vest", sellIn, quality);
    }

    @Override
    public void manageQuality(boolean isExpired) {
        quality -= !isExpired ? 1 : 2;
        if (quality < 0) {
            quality = 0;
        }
    }

    @Override
    public void manageExpirationDate(boolean isExpired) {
        return;
    }

}