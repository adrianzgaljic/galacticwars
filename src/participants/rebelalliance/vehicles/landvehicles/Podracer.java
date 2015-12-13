package participants.rebelalliance.vehicles.landvehicles;

import demo.Health;
import participants.Vehicle;
import participants.WarParticipant;
import weapons.DLT19HeavyBlasterRifle;
import weapons.E11BlasterRifle;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 10/12/15.
 * Implementation of Podracers, racing vehicles which could be modified to carry weapons.
 */
public class Podracer extends Vehicle {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new DLT19HeavyBlasterRifle(),
            new E11BlasterRifle())
    );


    @Override
    public String getName() {
        return "Podracer";
    }



    @Override
    public void attack(WarParticipant target) {
        int noOfPod = getHealth()/ Health.WOOKIEES;
        if (noOfPod>0){
            int noOfShooting = 1+random.nextInt(noOfPod);
            weapons.get(random.nextInt(weapons.size())).fire(target, this,noOfShooting);
        }
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.WOOKIEES;
        int noOfDied = force/Health.WOOKIEES;
        int fatality = (int)(random.nextInt(200)/(double)10000*force);
        setCrew(getCrew() - fatality);
        System.out.println("U napadu na "+getName()+" poginulo "+fatality+" Wookiee.");
        if (getCrew()==0){
            System.out.println(getName()+" ostaju bez posade te se kvare i eksplodiraju");
            setHealth(0);
        } else {
            System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je uništeno "+noOfDied+
                    ", ostalo ih je još "+noAlive);
        }
    }
}
