package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        int size = 10;
        int[] numbers = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100);
        }
        System.out.println("Array: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("Sorted: " + Arrays.toString(numbers));

        int[] temp = new int[size];
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                temp[count] = numbers[i];
                count++;
            } else {
                if (numbers[i] != numbers[i - 1]) {
                    temp[count] = numbers[i];
                    count++;
                }
            }
        }

        int[] uniqueNumbers = new int[count];
        for (int i = 0; i < count; i++) {
            uniqueNumbers[i] = temp[i];
        }

        System.out.println("Sorted without duplicates: " + Arrays.toString(uniqueNumbers));
    }
}
