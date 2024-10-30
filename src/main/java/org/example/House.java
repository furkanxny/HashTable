package org.example;

/**
 * This class represents House objects with owner and value fields.
 * Has setters, getters, and deepCopy methods.
 *
 * @author Furkan Uzun
 */
public class House {

    /**
     * Fields of the House class.
     */
    private String owner;
    private int value;
    private House next;

    /**
     * Default constructor
     */
    public House() {
    }

    /**
     * Constructor that takes values for all member variables as parameters.
     */
    public House(String owner, int value) {
        this.owner = owner;
        this.value = value;
    }

    /**
     * Constructor that is used to make Deep Copies of a House object.
     *
     * @param other House object.
     */
    public House(House other) {
        this.owner = other.owner;
        this.value = other.value;
    }

    /**
     * Creates deep copy of the house.
     *
     * @return New House object with deep copied values.
     */
    public House deepCopy() {
        return new House(this.owner, this.value);

    }

    /**
     * Sets the new owner of the house.
     *
     * @param owner The new owner of the house.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Gets the owner of the house.
     *
     * @return The owner of the house.
     */
    public String getOwner() {
        return this.owner;
    }

    /**
     * Sets the value of the house.
     *
     * @param value The new value of the house.
     */
    public void setValue(int value) {
        this.value = value;
    }


    /**
     * Gets the value of the house.
     *
     * @return The value of the house.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Sets the pointer(next) of the house.
     *
     * @param next The next house that will be pointed by 'this'.
     */
    public void setNext(House next) { this.next = next; }

    /**
     * Gets the pointer(next) of the house.
     *
     * @return The pointed house.
     */
    public House getNext() { return this.next; }

    /**
     * An override equals method based on the values of the houses.
     *
     * @param obj Object to compare to the current house.
     * @return returns true or false if the owners, and the values of the house objects are equal or not.
     */
    @Override
    public boolean equals(Object obj) {
        House tempHouse = (House) obj;
        return this.owner.equals(tempHouse.getOwner());
    }

    /**
     * Provides string representation of the house object.
     *
     * @return String definition of the fields with owner and value of the house object.
     */
    @Override
    public String toString() {
        return "Owner: " + owner + ", Value: " + value+" "+getOwner().hashCode();
    }

    @Override
    public int hashCode() {
        return this.getOwner().hashCode();
    }
}