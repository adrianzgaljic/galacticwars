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
 * AtAt class represents the All Terrain Armored Transport (AT-AT), a four-legged combat walker
 * used by the ground forces of the Galactic Empire.
 */
public class AtAt extends Vehicle {

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
        return "AT-AT";
    }



    @Override
    public void attack(WarParticipant target) {
        int noOfAtat = getHealth()/ Health.STORM_TR;
        if (noOfAtat>0){
            int noOfShooting = 1+random.nextInt(noOfAtat);
            weapons.get(random.nextInt(weapons.size())).fire(target, this,noOfShooting);
        }
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth() - force);
        int noAlive = getHealth()/(Health.STORM_TR*2);
        int noOfDied = force/(Health.STORM_TR*2);
        int fatality = (int)(random.nextInt(200)/(double)10000*force);
        setCrew(getCrew() - fatality);
        System.out.println("U napadu na "+getName()+" poginulo "+fatality+" Stromtroopera.");
        if (getCrew()==0){
            System.out.println(getName()+" ostaju bez posade te se kvare i eksplodiraju");
            setHealth(0);
        } else {
            System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je uništeno "+noOfDied+
                    ", ostalo ih je još "+noAlive);
        }

    }
}
