package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class TexttestFixture {

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        List<ExtendedItem> items = new ArrayList() {{
            add(new DexterityVest(10, 20));
            add(new AgedBrie(2, 0));
            add(new Elixir(5, 7));
            add(new Sulfuras(0, 80));
            add(new Sulfuras(-1, 80));
            add(new Backstage(15, 20));
            add(new Backstage(10, 49));
            add(new Backstage(5, 49));
            add(new Conjured(3, 6));
        }};

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            items.forEach(System.out::println);
            System.out.println();
            app.updateQuality();
        }
    }

}