package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void qualityDecreasesDayAfterDay() {
        List<ExtendedItem> items = singletonList(new DexterityVest(10, 20));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items.get(0).sellIn);
        assertEquals(19, app.items.get(0).quality);
    }

    @Test
    void qualityDecreasesTwiceFasterWhenDateIsExpired() {
        List<ExtendedItem> items = singletonList(new Elixir(-1, 7));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items.get(0).sellIn);
        assertEquals(5, app.items.get(0).quality);
    }

    @Test
    void qualityCannotBeNegative() {
        List<ExtendedItem> items = singletonList(new Elixir(0, 0));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items.get(0).sellIn);
        assertEquals(0, app.items.get(0).quality);
    }

    @Test
    void qualityCannotBeNegative_dateExpired() {
        List<ExtendedItem> items = singletonList(new Elixir(-1, 1));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items.get(0).sellIn);
        assertEquals(0, app.items.get(0).quality);
    }

    @Test
    void agedBrieItemGainsQualityAsTimePasses() {
        List<ExtendedItem> items = singletonList(new AgedBrie(2, 0));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items.get(0).sellIn);
        assertEquals(1, app.items.get(0).quality);
    }

    @Test
    void agedBrieItemGainsQualityAsTimePasses_dateExpired() {
        List<ExtendedItem> items = singletonList(new AgedBrie(-1, 0));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items.get(0).sellIn);
        assertEquals(2, app.items.get(0).quality);
    }

    @Test
    void qualityNeverExceeds50() {
        List<ExtendedItem> items = singletonList(new AgedBrie(10, 50));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items.get(0).sellIn);
        assertEquals(50, app.items.get(0).quality);
    }

    @Test
    void qualityNeverExceeds50_dateExpired() {
        List<ExtendedItem> items = singletonList(new AgedBrie(-1, 49));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items.get(0).sellIn);
        assertEquals(50, app.items.get(0).quality);
    }

    @Test
    void sulfurasItemHasNoExpiryDateAndNeverLosesQuality() {
        List<ExtendedItem> items = singletonList(new Sulfuras(0, 80));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items.get(0).sellIn);
        assertEquals(80, app.items.get(0).quality);
    }

    @Test
    void sulfurasItemHasNoExpiryDateAndNeverLosesQuality_dateExpired() {
        List<ExtendedItem> items = singletonList(new Sulfuras(-1, 80));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items.get(0).sellIn);
        assertEquals(80, app.items.get(0).quality);
    }

    @Test
    void backStageItemGainsQualityAsTimePasses_sellInMoreThan10() {
        List<ExtendedItem> items = singletonList(new Backstage(15, 20));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items.get(0).sellIn);
        assertEquals(21, app.items.get(0).quality);
    }

    @Test
    void backStageItemGainsQualityAsTimePasses_sellIn10OrLess() {
        List<ExtendedItem> items = singletonList(new Backstage(10, 49));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items.get(0).sellIn);
        assertEquals(50, app.items.get(0).quality);
    }

    @Test
    void backStageItemGainsQualityAsTimePasses_sellIn5OrLess() {
        List<ExtendedItem> items = singletonList(new Backstage(5, 49));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items.get(0).sellIn);
        assertEquals(50, app.items.get(0).quality);
    }

    @Test
    void conjuredItemLosesQualityTwiceFasterThanOtherItems() {
        List<ExtendedItem> items = singletonList(new Conjured(5, 10));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items.get(0).sellIn);
        assertEquals(8, app.items.get(0).quality);
    }

    @Test
    void conjuredItemLosesQualityTwiceFasterThanOtherItems_dateExpired() {
        List<ExtendedItem> items = singletonList(new Conjured(-1, 10));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items.get(0).sellIn);
        assertEquals(6, app.items.get(0).quality);
    }

}