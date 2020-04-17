package com.gildedrose;

class Elixir extends ExtendedItem {

    public Elixir(int sellIn, int quality) {
        super("Elixir of the Mongoose", sellIn, quality);
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