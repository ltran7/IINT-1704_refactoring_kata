package com.gildedrose;

import java.util.List;

class GildedRose {

    List<ExtendedItem> items;

    public GildedRose(List<ExtendedItem> items) {
        this.items = items;
    }

    public void updateQuality() {
        items.forEach(ExtendedItem::updateQuality);
    }

}