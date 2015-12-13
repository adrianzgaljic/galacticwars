package participants.rebelalliance.armies;

import demo.Health;
import participants.Army;
import participants.WarParticipant;
import weapons.DLT19HeavyBlasterRifle;
import weapons.E11BlasterRifle;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 10/12/15.
 * Ewoks is singleton class which represents Ewoks, cute furry bipeds helping the Rebel Alliance defeat the forces of the Galactic Empire.
 */
public class Ewoks extends Army {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new DLT19HeavyBlasterRifle(),
            new E11BlasterRifle())
    );

    /**
     * only instance of StormTroopers class
     */
    private static  Ewoks ewoks  = new Ewoks();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Ewoks(){
    }

    @Override
    public String getName() {
        return "Ewoks";
    }




    /**
     * getter for only instance of Ewoks  class
     * @return Ewoks instance
     */
    public static Ewoks getInstance(){
        return ewoks;
    }


    @Override
    public void attack(WarParticipant target) {
        int noOfEwoks = getHealth()/ Health.EWOKS;
        if (noOfEwoks>0){
            int noOfShooting = 1+random.nextInt(noOfEwoks);
            weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
        }
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        int chance = random.nextInt(6);
        if (chance<3){
            String compliment="";
            switch (chance){
                case 0:
                    compliment = "cute";
                    break;
                case 1:
                    compliment = "fluffy";
                    break;
                case  2:
                    compliment = "small";
                    break;
            }
            System.out.println(attacker.getName()+": I can't, little Ewoks you are so "+compliment);

        } else{
            force = quantify(force,Health.EWOKS);
            setHealth(getHealth() - force);
            int noAlive = getHealth()/Health.EWOKS;
            int noOfDied = force/Health.EWOKS;
            noOfDied = Math.min(noOfDied,getHealth()/Health.EWOKS);
            System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je poginulo "+noOfDied+
                    ", ostalo ih je još "+noAlive);
        }

    }
}
