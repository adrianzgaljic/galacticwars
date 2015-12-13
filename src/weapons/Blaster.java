package weapons;

import participants.WarParticipant;

/**
 * Created by adrianzgaljic on 09/12/15.
 * A blaster is type of ranged weapon that fired bolts of intense light energy.
 */
public class Blaster implements Weapon{

    /**
     * weapon force, amount of damage it can make to enemy
     */
    private final int force = 1;


    public int getForce() {
        return force;
    }


    @Override
    public void fire(WarParticipant target, WarParticipant attacker,  int noOfShooters) {
        System.out.println(noOfShooters+" "+attacker.getName()+" pucaju iz Blastera na "+target.getName());
        target.defend(attacker, noOfShooters*force);
    }
}
