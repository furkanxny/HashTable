package org.example;

/**
 *This class represents MyList object with House object field.
 * Has add, find, and deepCopy methods.
 *
 * @author Furkan Uzun
 */
public class MyList {
    /**
     * Field of the MyList class.
     */
    private House head;

    /**
     * Default Constructor that initializes MyList object with head field null.
     */
    public MyList() {
        this.head = null;
    }

    /**
     * Deep Copy constructor that initializes MyList with given parameter.
     *
     * @param other MyList object that will be copied from.
     */
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

    /**
     * Deep copy method that initializes a new MyList object with called(this) MyList.
     *
     * @return A new MyList object.
     */
    public MyList deepCopy() {
    return new MyList(this);
    }

    /**
     * Adds a House object to the beginning of MyList. Added House points to the old head.
     * Cost O(1)
     * @param newHouse House object that will be added to the beginning of the List.
     */
    public void add(House newHouse) {
        newHouse.setNext(this.head);
        this.head = newHouse;
    }

    /**
     * Finds the House object of the given owner in the List.
     *
     * @param owner String value of a House owner.

     * Cost: Ideally O(1), the worst case O(n)
     *
     * @return The found House object if existed, null otherwise.
     */
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

    /**
     * Gets the head of the List.
     *
     * @return Head House object.
     */
    public House getHead() {
        return this.head;
    }


}
