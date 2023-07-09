package io.devqa.java.examples.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterMapExamples {

    public static void filterWithLoop() {
        Map<Integer, String> originalMap = new HashMap<>();
        originalMap.put(1, "Apple");
        originalMap.put(2, "Banana");
        originalMap.put(3, "Orange");
        originalMap.put(4, "Grapes");

        Map<Integer, String> filteredMap = new HashMap<>();

        for (Map.Entry<Integer, String> entry : originalMap.entrySet()) {
            if (entry.getKey() > 2) {
                filteredMap.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println("Filtered Map: " + filteredMap);
    }

    public static void filterWithStreams() {
        Map<Integer, String> originalMap = new HashMap<>();
        originalMap.put(1, "Apple");
        originalMap.put(2, "Banana");
        originalMap.put(3, "Orange");
        originalMap.put(4, "Grapes");

        Map<Integer, String> filteredMap = originalMap.entrySet()
                .stream()
                .filter(entry -> entry.getKey() > 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Filtered Map: " + filteredMap);
    }
    public static void filterWithPredicate() {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("Apple", 10);
        originalMap.put("Banana", 20);
        originalMap.put("Orange", 15);
        originalMap.put("Grapes", 5);

        Predicate<Map.Entry<String, Integer>> filterCondition = entry -> entry.getValue() >= 10;

        Map<String, Integer> filteredMap = originalMap.entrySet()
                .stream()
                .filter(filterCondition)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Filtered Map: " + filteredMap);
    }

    public static void main(String[] args) {
        filterWithLoop();
        filterWithStreams();
        filterWithPredicate();
    }
}
