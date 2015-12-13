package participants.empire.characters;

import participants.WarParticipant;
import participants.rebelalliance.characters.ObiWanKenobi;
import weapons.LightSaber;
import weapons.Weapon;


/**
 * Created by adrianzgaljic on 11/12/15.
 * DarthMaul is singleton class which represents Darth Maul,a Sith Lord and a master of wielding a double-bladed lightsaber
 */
public class DarthMaul extends WarParticipant {


    /**
     * war participants weapon
     */
    private Weapon weapon = new LightSaber("double-bladed red",80);


    /**
     * only instance of DarthMaul class
     */
    private static DarthMaul darthMaul  = new DarthMaul();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private DarthMaul(){
    }

    @Override
    public String getName() {
        return "Darth Maul";
    }




    /**
     * getter for only instance of DarthMaul class
     * @return DarthMaul instance
     */
    public static DarthMaul getInstance(){
        return darthMaul;
    }


    @Override
    public void attack(WarParticipant target) {
        weapon.fire(target, this,1);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        if (attacker.getClass().equals(ObiWanKenobi.class)){
            System.out.println(getName()+": aaa presječen sam na pola!");
            setHealth(0);
        } else {
            setHealth(getHealth()-force);
            System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");
        }
    }

}

