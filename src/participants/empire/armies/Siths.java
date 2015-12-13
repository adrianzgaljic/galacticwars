package participants.empire.armies;

import demo.Health;
import participants.Army;
import participants.WarParticipant;
import participants.rebelalliance.armies.Jedis;
import weapons.LightSaber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 * Siths is singleton class which represents Siths, an order of Force users who utilized the dark side of the Force.
 */
public class Siths extends Army {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<LightSaber> weapons = new ArrayList<>(Arrays.asList(
            new LightSaber("orange",10),
            new LightSaber("purple",15),
            new LightSaber("yellow",20),
            new LightSaber("red",25))
    );

    /**
     * only instance of Siths class
     */
    private static  Siths siths = new Siths();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Siths(){
    }

    @Override
    public String getName() {
        return "Siths";
    }




    /**
     * getter for only instance of Siths class
     * @return Siths instance
     */
    public static Siths getInstance(){
        return siths;
    }


    @Override
    public void attack(WarParticipant target) {
        //Jedis and Siths hate each other, when these two confront all of them will join the attack
        if (target.getClass().equals(Jedis.class)){
            weapons.get(random.nextInt(weapons.size())).fire(target, this, getHealth()/Health.SITHS);
        } else {
            int noOfSiths = getHealth()/ Health.SITHS;
            if (noOfSiths>0){
                int noOfShooting = 1+random.nextInt(noOfSiths);
                weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
            }
        }

    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        force = quantify(force,Health.SITHS);
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.SITHS;
        int noOfDied = (int)Math.ceil(force/(double)Health.SITHS);
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je poginulo "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}

