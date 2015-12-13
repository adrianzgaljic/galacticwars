package weapons;

import participants.WarParticipant;

/**
 * Created by adrianzgaljic on 10/12/15.
 * Type of weapon.
 */
public class E11BlasterRifle implements Weapon {



    /**
     * weapon force, amount of damage it can make to enemy
     */
    private final int force = 1;


    public int getForce() {
        return force;
    }



    @Override
    public void fire(WarParticipant target, WarParticipant attacker, int noOfShooters) {
        System.out.println(noOfShooters+" "+attacker.getName()+" pucaju iz E-11 Blaster riflea na "+target.getName());
        target.defend(attacker, noOfShooters*force);
    }
}
