package participants.empire.vehicles.spaceships;

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
 * DeathStar is singleton class which represents Death Star, moon-sized deep space mobile battle station constructed by the Galactic Empire.
 */
public class DeathStar extends Vehicle {

    private Random random = new Random();
    /**
     * when under attack, death star can activate shield which gets damaged and eventually destroyed
     */
    private int shieldHealth = 100;

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new DLT19HeavyBlasterRifle(),
            new E11BlasterRifle(),
            new SuperLaser())
    );

    /**
     * only instance of DeathStar class
     */
    private static  DeathStar deathStar  = new DeathStar();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private DeathStar(){}

    @Override
    public String getName() {
        return "Death star";
    }

    /**
     * getter for only instance of DeathStar class
     * @return DeathStar instance
     */
    public static DeathStar getInstance(){
        return deathStar;
    }

    @Override
    public void attack(WarParticipant target) {
        weapons.get(random.nextInt(weapons.size())).fire(target, this,1);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        //there is 50-50 chance that shield will be activated
        if (random.nextInt(1)==0 && shieldHealth>0){
            shieldHealth = shieldHealth - random.nextInt(20);
            System.out.println("Death star aktivira štit, ne možete mi ništa, stanje štita "+shieldHealth+"%");
        } else {
            int fatality = (int)(random.nextInt(200)/(double)10000*force);
            fatality = Math.min(fatality,getCrew());
            System.out.println("U napadu na zvijezdu smrti, poginulo "+fatality+" članova posade");
            setCrew(getCrew()-fatality);
            if (getCrew()<=0){
                System.out.println("Death star nema posadu i samouništava se");
                setHealth(0);
            } else{
                setHealth(getHealth()-force);
                System.out.println("Death star pretrpila udarac jačine "+getHealth()+" ostalo još "+getHealth()+" snage.");
            }
        }



    }
}
