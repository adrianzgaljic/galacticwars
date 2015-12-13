package participants.rebelalliance.characters;

import participants.WarParticipant;
import weapons.LightSaber;
import weapons.PureForce;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 * Singleton class which represents Jedi Yoda.
 */
public class Yoda extends WarParticipant {

    Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new LightSaber("green", 100), new PureForce()));


    /**
     * only instance of Yoda class
     */
    private static Yoda yoda = new Yoda();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Yoda(){
    }

    @Override
    public String getName() {
        return "Yoda";
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
        if (target.getClass().equals(LukeSkywalker.class)){
            System.out.println(target.getName()+" izdao nas si! Platiti sada ćeš!");
        }
        weapons.get(random.nextInt(weapons.size())).fire(target, this, 1);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth()-force);
        System.out.println(getName() + ": od "+attacker.getName()+" udarac primio sam, preostalo "+getHealth()+" zdravlja još mi je");

    }

}

