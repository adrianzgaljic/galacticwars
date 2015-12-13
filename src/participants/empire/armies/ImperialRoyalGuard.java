package participants.empire.armies;

import demo.Health;
import participants.WarParticipant;
import participants.empire.characters.DarthVader;
import weapons.DLT19HeavyBlasterRifle;
import weapons.E11BlasterRifle;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 */
public class ImperialRoyalGuard extends WarParticipant {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new DLT19HeavyBlasterRifle(),
            new E11BlasterRifle())
    );

    /**
     * name of character
     */
    private final String name = "Imperial Royal guard";

    /**
     * only instance of ImperialRoyalGuard class
     */
    private static  ImperialRoyalGuard imperialRoyalGuard = new ImperialRoyalGuard();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private ImperialRoyalGuard(){}

    @Override
    public String getName() {
        return name;
    }




    /**
     * getter for only instance of ImperialRoyalGuard class
     * @return ImperialRoyalGuard instance
     */
    public static ImperialRoyalGuard getInstance(){
        return imperialRoyalGuard;
    }


    @Override
    public void attack(WarParticipant target) {
        if (DarthVader.getInstance().getHealth()>0){
            int noOfDroids = getHealth()/ Health.IMPERIAL_GUARD;
            int noOfShooting = random.nextInt(noOfDroids);
            weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
        } else{
            System.out.println(getName()+" kreću napasti "+target+" ali shvaćaju da je Darth Vader mrtav \ni bezvoljno odustaju");
        }

    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth() - force);
        int noAlive = getHealth()/10;
        int noOfDied = force/10;
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je poginulo "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}


