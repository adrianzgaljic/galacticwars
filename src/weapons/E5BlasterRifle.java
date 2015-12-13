package weapons;

import demo.Health;
import participants.WarParticipant;
import participants.empire.armies.B1BattleDroids;

import java.util.Random;

/**
 * Created by adrianzgaljic on 12/12/15.
 */
public class E5BlasterRifle implements Weapon {

    Random random = new Random();

    /**
     * weapon force, amount of damage it can make to enemy
     */
    private final int force = 2;


    public int getForce() {
        return force;
    }



    @Override
    public void fire(WarParticipant target, WarParticipant attacker,  int noOfShooters) {
        target.defend(attacker,noOfShooters*force);
        System.out.println(noOfShooters+" "+attacker.getName()+" pucaju iz E-5 Blaster riflea na "+target.getName());
    }
}
