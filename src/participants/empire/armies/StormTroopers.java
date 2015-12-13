package participants.empire.armies;

import demo.Health;
import participants.WarParticipant;
import weapons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 10/12/15.
 */
public class StormTroopers extends WarParticipant {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new E5BlasterRifle(),
            new Blaster(),
            new E11BlasterRifle())
    );

    /**
     * name of character
     */
    private final String name = "Storm Troopers";

    /**
     * only instance of StormTroopers class
     */
    private static  StormTroopers stormTroopers  = new StormTroopers();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private StormTroopers(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of StormTroopers  class
     * @return StormTroopers instance
     */
    public static StormTroopers getInstance(){
        return stormTroopers;
    }


    @Override
    public void attack(WarParticipant target) {
        int noOfDroids = getHealth()/ Health.STORM_TR;
        int noOfShooting = 1+random.nextInt(noOfDroids);
        weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
        int chance = random.nextInt(5);
        if (chance==0){
            int fatality = (random.nextInt(4)+1);
            System.out.println("Smotani Stormtrooperi su u napadu uspjeli ubiti "+fatality+" svojih vojnika");
            defend(this,fatality*Health.STORM_TR);
        }

    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth() - force);
        int noAlive = getHealth()/10;
        int noOfDied = force/10;
        //TODO provjeri ak ovo radi
        if (!attacker.getClass().equals(this.getClass())){
            System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je poginulo "+noOfDied+
                    ", ostalo ih je još "+noAlive);
        }

    }
}
