package participants.rebelalliance.characters;

import participants.WarParticipant;
import weapons.LightSaber;
import weapons.Weapon;

/**
 * Created by adrianzgaljic on 11/12/15.
 * Singleton class which represents Jedi Obi-Wan Kenobi.
 */
public class ObiWanKenobi extends WarParticipant {

    /**
     * war participants weapon
     */
    private Weapon weapon = new LightSaber("purple",80);


    /**
     * only instance of ObiWanKenobi class
     */
    private static ObiWanKenobi obiWanKenobi = new ObiWanKenobi();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private ObiWanKenobi(){
    }

    @Override
    public String getName() {
        return "Obi-Wan Kenobi";
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
        if (target.getClass().equals(LukeSkywalker.class)){
            System.out.println("Izdao si nas "+target.getName()+" sada ćeš platiti!");
        }
        weapon.fire(target,this,1);


    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        if (attacker.getClass().equals(LukeSkywalker.class)){
            setHealth(getHealth()-force*2);
            System.out.println(getName() + " primio udarac od " + attacker.getName() + "\n zbog izdaje bol je još veća, još mu je preostalo " + getHealth() + " zdravlja");
        } else {
            setHealth(getHealth()-force);
            System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");
        }
    }

}
