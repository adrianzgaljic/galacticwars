package participants.rebelalliance.vehicles.landvehicles;

import demo.Health;
import participants.Vehicle;
import participants.WarParticipant;
import weapons.DLT19HeavyBlasterRifle;
import weapons.E11BlasterRifle;
import weapons.SuperLaser;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 10/12/15.
 * Class represents Low Altitude Assault Transport/infantry (LAAT/i), gunship used by rebel alliance.
 */
public class LAAT extends Vehicle {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new DLT19HeavyBlasterRifle(),
            new E11BlasterRifle(),
            new DLT19HeavyBlasterRifle())
    );


    @Override
    public String getName() {
        return  "LAAT/i";
    }



    @Override
    public void attack(WarParticipant target) {
        int noOfLaat = getHealth()/ Health.WOOKIEES;
        if (noOfLaat>0){
            int noOfShooting = 1+random.nextInt(noOfLaat);
            weapons.get(random.nextInt(weapons.size())).fire(target, this,noOfShooting);
        }
        weapons.get(random.nextInt(weapons.size())).fire(target, this,1);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        force = quantify(force,Health.WOOKIEES);
        setHealth(getHealth() - force);
        int noAlive = getHealth()/Health.WOOKIEES;
        int noOfDied = force/Health.WOOKIEES;
        int fatality = (int)(random.nextInt(200)/(double)1000*force);
        fatality = Math.min(fatality,getCrew());
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


