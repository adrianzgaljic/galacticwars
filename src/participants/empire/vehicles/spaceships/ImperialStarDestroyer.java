package participants.empire.vehicles.spaceships;

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
 * ImperialStarDestroyer is singleton class which represents Imperial Star Destroyer, massive dagger-shaped capital ship of the Imperial Navy.
 */
public class ImperialStarDestroyer extends Vehicle {

    private Random random = new Random();

    /**
     * when under attack, imperial star destroyer can activate shield which gets damaged and eventually destroyed
     */
    private int shieldHealth = 100;

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new DLT19HeavyBlasterRifle(),
            new E11BlasterRifle())
    );

    /**
     * only instance of ImperialStarDestroyer class
     */
    private static  ImperialStarDestroyer imperialStarDestroyer = new ImperialStarDestroyer();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private ImperialStarDestroyer(){}

    @Override
    public String getName() {
        return "Imperial Star Destroyer";
    }




    /**
     * getter for only instance of ImperialStarDestroyer class
     * @return ImperialStarDestroyer instance
     */
    public static ImperialStarDestroyer getInstance(){
        return imperialStarDestroyer;
    }

    @Override
    public void attack(WarParticipant target) {
        if (random.nextInt(3)==0){
            System.out.println("ImperialStarDestroyer puca na "+target+" ali promašuje.");
        } else {
            weapons.get(random.nextInt(weapons.size())).fire(target, this,1);
        }

    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        //there is 1/3 chance that shield will be activated
        if (random.nextInt(3)==0 && shieldHealth>0){
            shieldHealth = shieldHealth - random.nextInt(30);
            System.out.println("Imperial Star Destroyer aktivira štit, ne možete mi ništa, stanje štita "+shieldHealth+"%");
        } else {
            int fatality = (int)(random.nextInt(200)/(double)10000*force);
            fatality = Math.min(fatality,getCrew());
            System.out.println("U napadu na Imperial Star Destroye, poginulo "+fatality+" članova posade");
            if (getCrew()<=0){
                System.out.println("Imperial Star Destroyer nema posadu i samouništava se");
                setHealth(0);
            } else{
                setHealth(getHealth()-force);
                System.out.println("Imperial Star Destroye pretrpila udarac jačine "+getHealth()+" ostalo još "+getHealth()+" snage.");
            }
        }
    }
}
