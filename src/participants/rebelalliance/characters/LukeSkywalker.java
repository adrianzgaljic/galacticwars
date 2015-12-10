package participants.rebelalliance.characters;

import participants.WarParticipant;
import weapons.LightSaber;
import weapons.Weapon;

/**
 * Created by adrianzgaljic on 09/12/15.
 * LukeSkywalker is singleton class which represents Jedi Luke Skywalker
 */
public class LukeSkywalker extends WarParticipant {

    /**
     * war participants weapon
     */
    private Weapon weapon = new LightSaber("light blue",100);


    /**
     * name of character
     */
    private final String name = "Luke Skywalker";

    /**
     * only instance of LukeSkywalker  class
     */
    private static  LukeSkywalker lukeSkywalker  = new LukeSkywalker();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private LukeSkywalker(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of LukeSkywalker  class
     * @return LukeSkywalker instance
     */
    public static LukeSkywalker getInstance(){
        return lukeSkywalker;
    }


    @Override
    public void attack(WarParticipant target) {
        weapon.fire(target,this);


    }

    @Override
    public void defend(WarParticipant attacker, int force) {


        setHealth(getHealth()-force);
        System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");

    }

}
