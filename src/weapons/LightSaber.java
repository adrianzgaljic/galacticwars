package weapons;

import participants.WarParticipant;

/**
 * Created by adrianzgaljic on 09/12/15.
 * LightSaber is weapon used by the Jedi and the Sith.
 */
public class LightSaber implements Weapon {

    /**
     * lightsaber color
     */
    private String color;

    /**
     * lightsaber force, amount of damage it can make to enemy
     */
    private int force;


    public LightSaber(String color){
        this.color = color;
    }

    public LightSaber(String color, int force){
        this.color = color;
        this.force = force;
    }

    /**
     * Setter for force, force depends on person using lightsaber
     * @param force amount of force
     */
    public void setForce(int force){
        this.force = force;
    }

    @Override
    public void fire(WarParticipant target, WarParticipant attacker, int noOfShooters) {
        System.out.println(attacker.getName()+" zamahnuo svojim "+color+" lightsaberom na "+target.getName());
        target.defend(attacker,force);
    }
}
