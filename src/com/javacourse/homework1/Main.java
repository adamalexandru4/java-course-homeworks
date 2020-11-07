package com.javacourse.homework1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    enum WeekDay {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    /**
     * Return a map with 3 initial values
     * @return new map filled with values
     * @see Map
     */
    private static Map<Integer, String>  mapExample() {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "First value");
        map.put(2, "Second value");
        map.put(3, "Third value");
        return map;
    }

    private static Optional<Integer> randomOptionalGenerator() {
        Random rand = new Random();
        if (rand.nextInt(2) == 1) {
            return Optional.of(1);
        } else {
            return Optional.empty();
        }
    }

    private static Integer differenceBetweenValuesList(List<Integer> list) {
        Integer minValue = list.stream().min(Integer::compareTo).orElseThrow();
        Integer maxValue = list.stream().max(Integer::compareTo).orElseThrow();

        return maxValue - minValue;
    }

    private static void loopThroughList(List<String> list) {
        if(list.isEmpty()) {
            System.out.println("Empty list");
            return;
        }

        if(list instanceof ArrayList) {
            System.out.print("ArrayList: ");
            list.forEach(System.out::print);
            System.out.println();
            return;
        }

        if(list instanceof LinkedList) {
            System.out.print("LinkedList: ");
            Iterator<String> iterator = ((LinkedList<String>) list).descendingIterator();
            iterator.forEachRemaining(System.out::print);
            System.out.println();
            return;
        }

        System.out.println("Try next time..");
    }

    private static String generateViewTemplate(Map<String, String> map) {
        return """
                <html>
                    <body>
                        <p>Hello %s. %s </p>
                    </body>
                </html>
                """.formatted(map.getOrDefault("name", ""), map.getOrDefault("greeting", ""));
    }

    private static String checkWeekDay(WeekDay weekDay) {
        return switch (weekDay) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Work day";
            case SATURDAY, SUNDAY -> "Weekend";
        };
    }

    private static Boolean checkOperations(MathematicalOperation firstOperation, MathematicalOperation secondOperation) {
        return firstOperation.equals(secondOperation);
    }

    public static void main(String[] args) {
        /**
         * EXERCISE 1
         *
         * Explanation: This code works due to the fact that the new map is returned by reference and you can
         * add/delete/modify values for corresponding key. Obviously, it won't fail.
         */
        Map<Integer, String> map = mapExample();
        map.put(4, "Fourth value");

        /**
         * EXERCISE 2
         */
        // randomOptionalGenerator().orElseThrow();

        /**
         * EXERCISE 3
         */
        //randomOptionalGenerator().ifPresentOrElse(System.out::println, () -> System.out.println("You've reached the end of INT"));
        /**
         * EXERCISE 4
         */
        List<Integer> list = Stream.of(1,2,3,6,5).collect(Collectors.toList());
        System.out.println(differenceBetweenValuesList(list));
        /**
         * EXERCISE 5
         */
        List<String> simpleList = Stream.of("a", "b").collect(Collectors.toList());
        LinkedList<String> linkedList = Stream.of("c", "d").collect(Collectors.toCollection(LinkedList::new));
        loopThroughList(simpleList);
        loopThroughList(linkedList);
        /**
         * EXERCISE 6
         */
        System.out.println(generateViewTemplate(Map.of("name", "Adam", "greeting", "Welcome!")));
        /**
         * EXERCISE 7
         */
        System.out.println(checkWeekDay(WeekDay.SATURDAY));
        /**
         * EXERCISE 8
         */
        Addition addition = new Addition();
        Subtraction substraction = new Subtraction();
        System.out.println(checkOperations(addition, substraction));
    }
}

