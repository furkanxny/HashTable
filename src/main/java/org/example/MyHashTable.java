package org.example;

/**
 * This class mimics the functionality of a HashTable.
 * Holds an array of MyList objects, initialization size, loadFactor value, and count of Houses added.
 * Has default, deep-copy constructors, add, find, show, resize methods.
 */
public class MyHashTable {

    /**
     * Fields of MyHashTable class.
     */
    private MyList[] buckets; // = new MyList[10];
    private int initSize;
    private double loadFactor;
    private int count;


    /**
     * Default constructor that initializes size to 4, loadFactor to .75, and inserts MyList to each index of the MyList array.
     */
    public MyHashTable () {
        this.initSize = 4;
        this.buckets = new MyList[initSize];
        this.loadFactor = .75;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyList();
        }

    }

    /**
     * Deep copy constructor that initializes a MyHashTable object with a given MyHashTable object.
     *
     * Makes a deep copy of each List and adds it to the new MyHashTable.
     *
     * @param other MyHashTable object to be copied from.
     */
    public MyHashTable (MyHashTable other) {
        this.initSize = other.initSize;
        this.loadFactor = other.loadFactor;
        this.buckets = new MyList[other.buckets.length];
        this.count = other.count;

        for(int i = 0; i < this.buckets.length; i++) {
            MyList temp = other.buckets[i].deepCopy();
            //MyList temp = new MyList(other.buckets[i]);
            buckets[i] = temp;
        }
    }

    /**
     * Deep copy method that uses the deep copy constructor to return a new Object.
     *
     * @return new MyHashTable object.
     */
    public MyHashTable deepCopy() {
        return new MyHashTable(this);
    }

    /**
     * Add a method that inserts given Houses to the MyHashTable by abstraction from MyList.
     * Cost O(1)
     * @param newHouse House to be added.
     */
    public void add(House newHouse) {
        int length = this.buckets.length;
        if ((double) count / length > loadFactor) {
            this.buckets = resize();
        }

        int index = Math.abs(newHouse.hashCode()) % length;
        this.buckets[index].add(newHouse);
        count++;
    }

    /**
     * Abstraction of find from MyList class. Finds the House of the given owner.
     * @param owner Owner of the house to be found.
     * Cost: Ideally O(1), but MyList find() method worst case is O(n).
     *              Thus, the worst case O(n).
     * @return return the House if found, null otherwise.
     */
    public House find(String owner) {
        int index = Math.abs(owner.hashCode()) % this.buckets.length;
        return this.buckets[index].find(owner);
    }

    /**
     * show method to print all the List and houses belong to the Lists.
     */
    public void show() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("---------------------------------------");
            System.out.println("***** Bucket "+ i+" *****");
            House temp = buckets[i].getHead();
            while(temp != null) {
                System.out.println(temp);
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

    /**
     * Resize method to double the size of the List array and insert each element from an old array to a new array.
     * Cost: the best case O(n), the worst case O(n^2).
     *
     * @return new List array to be referenced to the this.array.
     */
    private MyList[] resize() {
        MyList[] listArr = new MyList[this.buckets.length * 2];

        for (int i = 0; i < listArr.length; i++) {
            listArr[i] = new MyList();
        }

        for (MyList bucket : this.buckets) {
            House temp = bucket.getHead();

            while (temp != null) {
                int hash = Math.abs(temp.hashCode()) % listArr.length;
                listArr[hash].add(new House(temp));
                temp = temp.getNext();
            }
        }
        return listArr;
    }
}
