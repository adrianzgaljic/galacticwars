package weapons;

import participants.WarParticipant;

/**
 * Created by adrianzgaljic on 09/12/15.
 * Interface which is implemented by all kinds of weapons used in battle.
 */
public interface Weapon {

    /**
     * method which is used when one war participant attacks other
     *
     * @param target target war participant
     * @param attacker attacker war participant
     */
    void fire(WarParticipant target, WarParticipant attacker, int noOfShooters);

}
