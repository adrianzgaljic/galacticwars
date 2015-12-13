package participants.empire.armies;

import demo.Health;
import participants.Army;
import participants.WarParticipant;
import weapons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 10/12/15.
 * StormTroopers is singleton class which represents StormTrooper army, original elite soldiers of the Galactic Empire
 */
public class StormTroopers extends Army {

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
     * only instance of StormTroopers class
     */
    private static  StormTroopers stormTroopers  = new StormTroopers();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private StormTroopers(){
    }

    @Override
    public String getName() {
        return  "Storm Troopers";
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
        int noOfStormTr = getHealth()/ Health.STORM_TR;
        if (noOfStormTr>0){
            int noOfShooting = 1+random.nextInt(noOfStormTr);
            weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
            int chance = random.nextInt(5);
            if (chance==0){
                //fatality can be 4 or less
                int fatality = (random.nextInt(Math.min(4,getHealth()/ Health.STORM_TR))+1);
                System.out.println("Smotani Stormtrooperi su u napadu uspjeli ubiti "+fatality+" svojih vojnika");
                defend(this,fatality*Health.STORM_TR);
            }
        }
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        force = quantify(force, Health.STORM_TR);
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.STORM_TR;
        int noOfDied = force/Health.STORM_TR;
        noOfDied = Math.min(noOfDied,getHealth()/Health.STORM_TR);
        if (!attacker.getClass().equals(StormTroopers.class)){
            System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je poginulo "+noOfDied+
                    ", ostalo ih je još "+noAlive);
        }

    }


}
