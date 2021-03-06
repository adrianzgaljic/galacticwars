package weapons;

import participants.WarParticipant;

/**
 * Created by adrianzgaljic on 10/12/15.
 * Type of weapon.
 */
public class DLT19HeavyBlasterRifle implements Weapon{

    /**
     * weapon force, amount of damage it can make to enemy
     */
    private final int force = 20;


    public int getForce() {
        return force;
    }



    @Override
    public void fire(WarParticipant target, WarParticipant attacker,  int noOfShooters) {
        System.out.println(attacker.getName()+" pucaju iz DLT-19 heavy blaster riflea na "+target.getName());
        target.defend(attacker, force);
    }
}
