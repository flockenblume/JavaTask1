package mainPackage;

import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        int itemsSoFar = 0;
        for (String arg: args) {
            if (arg.equals("-calories") || arg.equals("-sort")) {
                continue;
            }
            String[] parts = arg.split("/");
            switch (parts[0]) {
                case "Cheese" -> breakfast[itemsSoFar] = new Cheese();
                case "Apple" -> breakfast[itemsSoFar] = new Apple(parts[1]);
                case "Tea" -> breakfast[itemsSoFar] = new Tea(parts[1]);
            }
            itemsSoFar++;
        }

        double totalCalories = 0.0;
        if (Arrays.asList(args).contains("-calories")) {
            for (Food item : breakfast) {
                if (item instanceof Nutritions) {
                    totalCalories += ((Nutritions) item).calculateCalories();
                }
            }
            System.out.println("Общая калорийность завтрака: " + totalCalories);
        }

        if (Arrays.asList(args).contains("-sort")) {
            Arrays.sort(breakfast, 0, itemsSoFar, (a, b) -> {
                if (a == null) return 1;
                if (b == null) return -1;
                int lengthComparison = Integer.compare(a.getName().length(), b.getName().length());
                if (lengthComparison != 0) {
                    return lengthComparison;
                }
                return a.getName().compareTo(b.getName());
            });
            System.out.println("Завтрак отсортирован по длине названия в прямом порядке.");
        }

        Food foodToCount = new Tea("чёрный");
        int count = countFoods(breakfast, foodToCount);
        System.out.println("Количество 'чёрный чай' в завтраке: " + count);

        for (Food item: breakfast)
            if (item!=null)
                item.consume();
            else
                break;
        System.out.println("Всего хорошего!");
    }

    public static int countFoods(Food[] breakfast, Food food) {
        int count = 0;
        for (Food item : breakfast) {
            if (item != null && item.equals(food)) {
                count++;
            }
        }
        return count;
    }
}