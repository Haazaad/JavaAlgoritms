package ru.haazad.homework5;

import java.util.*;

public class BoxProblem {
    private int weight;

    private Entity[] entities;
    private Map<Integer, List<Entity>> finalResult;

    public BoxProblem(int weight) {
        this.weight = weight;
        this.finalResult = new HashMap<>();
    }

    public static void main(String[] args) {
        BoxProblem box = new BoxProblem(6);
        box.entities = new Entity[]{
                new Entity("Book", 1, 600),
                new Entity("Binoculars", 2, 5000),
                new Entity("First aid kit", 4, 1500),
                new Entity("Notebook", 2, 40000),
                new Entity("Kettle", 1, 500)
        };
        box.findAll();
    }

    private void findAll() {
        find(entities.length);
        int max = 0;
        for (Map.Entry<Integer, List<Entity>> e: finalResult.entrySet()) {
            if (max < e.getKey()) {
                max = e.getKey();
            }
        }
        System.out.printf("Max price is %d for entities %s", max, finalResult.get(max));
    }

    private void find(int length) {
        if (length < 0) {
            return;
        }
        int weight = this.weight;
        int sum = 0;
        List<Entity> list = new ArrayList<>();
        for (Entity e : entities) {
            if (weight - e.getWeight() >= 0) {
                weight -= e.getWeight();
                list.add(e);
                sum += e.getPrice();
            }
        }
        finalResult.put(sum, list);
        rotate();
        find(--length);
    }

    private void rotate() {
        Entity tmp = entities[0];
        for (int i = 0; i < entities.length - 1; i++) {
            entities[i] = entities[i + 1];
        }
        entities[entities.length - 1] = tmp;
    }


}
