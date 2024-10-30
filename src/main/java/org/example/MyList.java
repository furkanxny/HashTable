package org.example;

public class MyList {
    private House head;


    public MyList() {
        this.head = null;
    }

    public MyList(MyList other) {
        if(other.head == null){
            this.head = null;
            return;
        }

        this.head = new House(other.head);
        House newHouse = this.head;
        House copiedHouse = other.head.getNext();


        while(copiedHouse != null) {
            newHouse.setNext(new House(copiedHouse));
            newHouse = newHouse.getNext();
            copiedHouse = copiedHouse.getNext();
        }

    }

    public MyList deepCopy() {
    return new MyList(this);
    }

    public void add(House newHouse) {
        newHouse.setNext(this.head);
        this.head = newHouse;
    }

    public House find(String owner) {
        //if(this.head == null) return null;
        House temp = this.head;
        while(temp != null) {
            if(temp.getOwner().equals(owner))
                return temp;

            temp = temp.getNext();
        }
        return null;
    }

    public House getHead() {
        return this.head;
    }


}
