package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable();

        // Read the owner and value of the house from the house.txt file.
        File houseFile = new File("houses.txt");

        try {
            //create a scanner object to read from the houseFile.
            Scanner sc = new Scanner(houseFile);

            // Read and populate the priority queue list with the house objects.
            while (sc.hasNextLine()) {
                String name = sc.nextLine(); //read the next line and assign it to the name variable.
                int value = Integer.parseInt(sc.nextLine());
                House house = new House(name, value);
                myHashTable.add(house);
                //System.out.println("Added: " + house);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        myHashTable.show();

    }
}