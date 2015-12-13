package participants.empire.vehicles.landvehicles;

import demo.Health;
import participants.Vehicle;
import participants.WarParticipant;
import weapons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 10/12/15.
 * Implementation of 74-Z Speeder Bikes, used by Stortroopers.
 */
public class Z74SpeederBike extends Vehicle {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new E5BlasterRifle(),
            new E11BlasterRifle())

    );


    @Override
    public String getName() {
        return "74-Z Speeder Bike";
    }



    @Override
    public void attack(WarParticipant target) {
        int noOfSpee = getHealth()/ Health.STORM_TR;
        if (noOfSpee>0){
            int noOfShooting = 1+random.nextInt(noOfSpee);
            weapons.get(random.nextInt(weapons.size())).fire(target, this,noOfShooting);
        }
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        force = quantify(force,Health.STORM_TR);
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.STORM_TR;
        int noOfDied = force/Health.STORM_TR;
        int fatality = (int)(random.nextInt(200)/(double)1000*force);
        fatality = Math.min(fatality,getCrew());
        setCrew(getCrew() - fatality);
        System.out.println("U napadu na "+getName()+" poginulo "+fatality+" Stromtroopera.");
        if (getCrew()==0){
            System.out.println(getName()+" ostaju bez posade te prestaju s radom.");
            setHealth(0);
        } else {
            System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je uništeno "+noOfDied+
                    ", ostalo ih je još "+noAlive);
        }
    }
}

