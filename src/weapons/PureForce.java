package weapons;

import participants.WarParticipant;

/**
 * Created by adrianzgaljic on 11/12/15.
 */
public class PureForce implements Weapon {


    /**
     * defalut force, amount of damage it can make to enemy
     */
    private int force = 100;


    public int getForce() {
        return force;
    }


    @Override
    public void fire(WarParticipant target, WarParticipant attacker) {
        //when used, pure force takes one fifth of overall target health
        force = target.getHealth()/5;
        System.out.println("WOOOSH " + attacker.getName() + " koristi čistu silu protiv " + target.getName());
        target.defend(attacker, force);
    }

}
