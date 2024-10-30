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

        House newHouse = new House(head.getNext())



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
