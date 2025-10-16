package ca.bytetube._15_greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {
        Item[] items = {new Item(35, 10), new Item(30, 40), new Item(60, 30),
                new Item(50, 50), new Item(40, 35), new Item(10, 40),
                new Item(25, 30)};
        int val1 = select(150, items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o2.density, o1.density);
            }
        });

        System.out.println(val1);
    }


    public static int select(int W, Item[] items, Comparator<Item> comparator) {
        Arrays.sort(items, comparator);
        int value = 0;
        int weight = 0;
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            int newWeight = items[i].weight + weight;
            if (newWeight <= W) {
                weight = newWeight;
                value += items[i].value;
                itemList.add(items[i]);

            }

        }

        System.out.println(itemList);
        return value;

    }
}
