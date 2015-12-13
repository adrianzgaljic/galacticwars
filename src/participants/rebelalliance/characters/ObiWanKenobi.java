package participants.rebelalliance.characters;

import participants.WarParticipant;
import weapons.LightSaber;
import weapons.Weapon;

/**
 * Created by adrianzgaljic on 11/12/15.
 */
public class ObiWanKenobi extends WarParticipant {

    /**
     * war participants weapon
     */
    private Weapon weapon = new LightSaber("purple",80);


    /**
     * name of character
     */
    private final String name = "Obi-Wan Kenobi";

    /**
     * only instance of ObiWanKenobi class
     */
    private static ObiWanKenobi obiWanKenobi = new ObiWanKenobi();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private ObiWanKenobi(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of ObiWanKenobi  class
     * @return ObiWanKenobi instance
     */
    public static ObiWanKenobi getInstance(){
        return obiWanKenobi;
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
