package org.example;


public class MyHashTable {
    private MyList[] buckets; // = new MyList[10];
    private int initSize;
    private double loadFactor;
    private int count;


    public MyHashTable () {
        this.initSize = 4;
        this.buckets = new MyList[initSize];
        this.loadFactor = .75;
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyList();
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
        if ((double) count / length > loadFactor) {
            this.buckets = resize();
        }

        int index = Math.abs(newHouse.hashCode()) % length;
        this.buckets[index].add(newHouse);
        count++;
    }

    public House find(String owner) {
        int index = Math.abs(owner.hashCode()) % this.buckets.length;
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
