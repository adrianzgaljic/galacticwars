package participants.rebelalliance;

import participants.WarParticipant;
import java.util.Random;

/**
 * Created by adrianzgaljic on 09/12/15.
 * LukeSkywalker is singleton class which represents Jedi Luke Skywalker
 */
public class LukeSkywalker extends WarParticipant {


    Random random = new Random();


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
        target.defend(this);


    }

    @Override
    public void defend(WarParticipant attacket) {


        setHealth(getHealth()-100);
        System.out.println(getName() + " primio udarac "+getHealth());

    }

}
