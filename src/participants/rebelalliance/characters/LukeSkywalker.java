package participants.rebelalliance.characters;

import participants.WarParticipant;
import participants.empire.characters.DarthVader;
import weapons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 09/12/15.
 * LukeSkywalker is singleton class which represents Jedi Luke Skywalker.
 */
public class LukeSkywalker extends WarParticipant {

    private Random random = new Random();


    /**
     * war participants weapons
     */
    ArrayList<LightSaber> weapons = new ArrayList<>(Arrays.asList(
            new LightSaber("light blue",100), new LightSaber("green",100)));


    /**
     * only instance of LukeSkywalker  class
     */
    private static  LukeSkywalker lukeSkywalker  = new LukeSkywalker();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private LukeSkywalker(){
    }

    @Override
    public String getName() {
        return "Luke Skywalker";
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
        weapons.get(random.nextInt(weapons.size())).fire(target, this,1);


    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        if (attacker.getClass().equals(DarthVader.class)){
            if (random.nextInt(2)==0){
                System.out.println(getName()+": Nooooo!");
            } else {
                switchSides();
            }
        }

        setHealth(getHealth()-force);
        System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");

    }

}
