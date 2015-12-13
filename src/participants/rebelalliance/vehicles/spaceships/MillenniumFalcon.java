package participants.rebelalliance.vehicles.spaceships;

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
 * Singleton class, implementation of Millennium Flacon, light freighter used by the rebel allience.
 */
public class MillenniumFalcon extends Vehicle {

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
     * only instance of MillenniumFalcon class
     */
    private static  MillenniumFalcon millenniumFalcon = new MillenniumFalcon();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private MillenniumFalcon(){}

    @Override
    public String getName() {
        return "Millennium Falcon";
    }




    /**
     * getter for only instance of MillenniumFalcon class
     * @return MillenniumFalcon instance
     */
    public static MillenniumFalcon getInstance(){
        return millenniumFalcon;
    }

    @Override
    public void attack(WarParticipant target) {
        weapons.get(random.nextInt(weapons.size())).fire(target, this,1);
    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        //there is 50-50 chance that shield will be activated
        if (random.nextInt(2)==0 && shieldHealth>0){
            shieldHealth = shieldHealth - random.nextInt(20);
            System.out.println("Millennium Falcon  aktivira štit, ne možete mi ništa, stanje štita "+shieldHealth+"%");
        } else {
            int fatality = (int)((random.nextInt(200)/(double)1000)*force);
            fatality = Math.min(fatality,getCrew());
            setCrew(getCrew()-fatality);
            System.out.println("U napadu na "+getName()+" poginulo "+fatality+" članova posade, ostalo ih je još "+getCrew());
            if (getCrew()<=0){
                System.out.println(getName()+" nema posadu i samouništava se");
                setHealth(0);
            } else{
                setHealth(getHealth()-force);
                System.out.println(getName()+" pretrpila udarac jačine "+force+" ostalo još "+getHealth()+" snage.");
            }
        }
    }
}
