package Collison;


/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

/**
 * The type Counter.
 */
public class Counter {

    private int counter;

    /**
     * Counter constructor.
     */
// add number to current count.
    public Counter() {
        this.counter = 0;
    }

    /**
     * @param counter sets counter
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * Increase.
     *
     * @param number the number
     */
    public void increase(int number) {
        this.counter += number;
    }

    /**
     * Decrease.
     *
     * @param number the number
     */
// subtract number from current count.
    public void decrease(int number) {
        this.counter -= number;
    }

    /**
     * Get value int.
     *
     * @return the int
     */
// get current count.
    public int getValue() {
        return counter;
    }
}