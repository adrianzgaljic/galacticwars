package weapons;

import participants.WarParticipant;

/**
 * Created by adrianzgaljic on 12/12/15.
 */
public class Sword implements Weapon {


    /**
     * defalut force, amount of damage it can make to enemy
     */
    private int force = 50;


    public int getForce() {
        return force;
    }


    @Override
    public void fire(WarParticipant target, WarParticipant attacker, int noOfShooters) {
        target.defend(attacker, noOfShooters * force);
        System.out.println(noOfShooters + " " + attacker.getName() + " koriste mač protiv " + target.getName());
        //every time sword is used it gets more and more blunt until it reaches force of 10
        if (force>10){
            force = force-2;
        }
    }

}

