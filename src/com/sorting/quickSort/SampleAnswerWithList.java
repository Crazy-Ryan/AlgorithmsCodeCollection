package com.sorting.quickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SampleAnswerWithList {
    private static void sort(List<Integer> items) {
        if (items.size() > 1) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer chosenItem = items.get(items.size() / 2);
            for (Integer i : items) {
                if (i < chosenItem) {
                    smaller.add(i);
                } else if (i > chosenItem) {
                    larger.add(i);
                } else {
                    same.add(i);
                }
            }
            sort(smaller);
            sort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }

    public static void main(String[] args) {
        int[] input = {34, 8, 64, 51, 32, 21};
        List<Integer> items = Arrays.stream(input).boxed().collect(Collectors.toList());
        sort(items);
        System.out.println(items);
    }

}
