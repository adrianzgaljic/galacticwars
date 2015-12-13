package participants.rebelalliance.characters;

import participants.WarParticipant;
import weapons.LightSaber;
import weapons.Weapon;

/**
 * Created by adrianzgaljic on 11/12/15.
 */
public class Yoda extends WarParticipant {

    /**
     * war participants weapon
     */
    private Weapon weapon = new LightSaber("green",100);


    /**
     * name of character
     */
    private final String name = "Yoda";

    /**
     * only instance of Yoda class
     */
    private static Yoda yoda = new Yoda();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Yoda(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of Yoda  class
     * @return Yoda instance
     */
    public static Yoda getInstance(){
        return yoda;
    }


    @Override
    public void attack(WarParticipant target) {
        weapon.fire(target,this,1);


    }

    @Override
    public void defend(WarParticipant attacker, int force) {


        setHealth(getHealth()-force);
        System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");

    }

}

