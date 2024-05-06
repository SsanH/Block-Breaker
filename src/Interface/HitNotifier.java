package Interface;

/**
 * name : San Haviv.
 * id : 316515170
 * submit : havivsa
 */

/**
 * hitnotifier interface.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     *
     * @param hl
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl
     */
    void removeHitListener(HitListener hl);
}