package org.example;

import java.sql.SQLOutput;

public class MyHashTable {
    private MyList[] buckets; // = new MyList[10];
    private int initSize;
    private double loadFactor;
    private int count;


    public MyHashTable () {
        this.initSize = 4;
        this.buckets = new MyList[initSize];
        this.loadFactor = .75;
        for(MyList bucket : buckets) {
            bucket = new MyList();
        }
    }

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

    public MyHashTable deepCopy() {
        return new MyHashTable(this);
    }

    public void add(House newHouse) {
        int length = this.buckets.length;
        if((double) length / count > .75) {
            resize();
        }
        int index = length % newHouse.hashCode();
        this.buckets[index].add(newHouse);
    }

    public House find(String owner) {
        int index = this.buckets.length % owner.hashCode();
        return this.buckets[index].find(owner);
    }

    public void show() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.println("Bucket "+ i);
            System.out.println("---------------");
            House temp = buckets[i].getHead();
            while(temp != null) {
                System.out.println(temp);
                temp = temp.getNext();
            }
        }
    }

    private void resize() {
    }


}
