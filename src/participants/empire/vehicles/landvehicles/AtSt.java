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
 * AtSt class represents a lightweight, bidepal walker used by the ground forces of the Galactic Empire.
 */
public class AtSt extends Vehicle {

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
        return  "AT-ST";
    }



    @Override
    public void attack(WarParticipant target) {
        int noOfAtst = getHealth()/ Health.STORM_TR;
        if (noOfAtst>0){
            int noOfShooting = 1+random.nextInt(noOfAtst);
            weapons.get(random.nextInt(weapons.size())).fire(target, this,noOfShooting);
        }
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        force = quantify(force,Health.STORM_TR*2);
        setHealth(getHealth() - force);
        int noAlive = getHealth()/(Health.STORM_TR*2);
        int noOfDied = force/(Health.STORM_TR*2);
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
