package participants.rebelalliance.armies;

import demo.Health;
import participants.Army;
import participants.WarParticipant;
import participants.empire.armies.Siths;
import weapons.LightSaber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 * Jedis is singleton class which represents Jedis who for peace and justice in the Galactic Republic, against their mortal enemy the Sith.
 */
public class Jedis extends Army {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<LightSaber> weapons = new ArrayList<>(Arrays.asList(
            new LightSaber("green",10),
            new LightSaber("blue",15),
            new LightSaber("light blue",20),
            new LightSaber("white",25))
    );

    /**
     * only instance of Jedis class
     */
    private static  Jedis jedis  = new Jedis();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private Jedis(){
    }

    @Override
    public String getName() {
        return "Jedis";
    }




    /**
     * getter for only instance of Jedis class
     * @return Jedis instance
     */
    public static Jedis getInstance(){
        return jedis;
    }


    @Override
    public void attack(WarParticipant target) {
        //Jedis and Siths hate each other, when these two confront all of them will join the attack
        if (target.getClass().equals(Siths.class)){
            weapons.get(random.nextInt(weapons.size())).fire(target, this, getHealth()/Health.JEDIS);
        } else {
            int noOfJedis = getHealth()/ Health.JEDIS;
            if (noOfJedis>0){
                int noOfShooting = 1+random.nextInt(noOfJedis);
                weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
            }
        }

    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        force = quantify(force,Health.JEDIS);
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.JEDIS;
        int noOfDied = force/Health.JEDIS;
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je poginulo "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}
