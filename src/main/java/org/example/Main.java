package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

//    You must read data from the input file and populate the hash table with that data.
//            • Print all data in the hash table on screen (organized by bucket).
//            • Write code to show that the following MyHashTable methods work properly:
//    o Copy constructor
//    o deepCopy
//    o find
    public static void main(String[] args) {
        //MyHashTable object.
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
        //print all the houses by buckets.
        myHashTable.show();

        //Deep copy constructor test.
        System.out.println();
        MyHashTable test1 = new MyHashTable(myHashTable);

        //Testing find() method and if deep copy constructor works.
        System.out.println(test1.find("Janet Evans"));

        //Deep copy method test.
        System.out.println();
        MyHashTable test2 = test1.deepCopy();

        //Testing if deep copy method works.
        System.out.println(test2.find("Janet Evans"));
        System.out.println();
        System.out.println(test2.find("Arthur Hoskey"));
    }
}