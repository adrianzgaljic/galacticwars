package participants.empire.armies;

import demo.Health;
import participants.Army;
import participants.WarParticipant;
import participants.empire.characters.DarthSidious;
import weapons.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 11/12/15.
 * ImperialRoyalGuard is singleton class which represents personal bodyguards and assassins of Sith Lord Darth Sidious.
 */
public class ImperialRoyalGuard extends Army {

    private Random random = new Random();

    /**
     * war participants weapons
     */
    ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new E5BlasterRifle(),
            new E11BlasterRifle(),
            new Sword())
    );

    /**
     * only instance of ImperialRoyalGuard class
     */
    private static  ImperialRoyalGuard imperialRoyalGuard = new ImperialRoyalGuard();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private ImperialRoyalGuard(){
    }

    @Override
    public String getName() {
        return "Imperial Royal guard";
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
        if (DarthSidious.getInstance().getHealth()>0){
            int noOfGuards = getHealth()/ Health.IMPERIAL_GUARD;
            if (noOfGuards>0){
                int noOfShooting = random.nextInt(noOfGuards);
                weapons.get(random.nextInt(weapons.size())).fire(target, this, noOfShooting);
            }
        } else{
            System.out.println(getName()+" kreću napasti "+target+" ali shvaćaju da je Darth Sidious mrtav \ni bezvoljno odustaju");
        }

    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        force = quantify(force,Health.IMPERIAL_GUARD);
        setHealth(getHealth() - force);
        int noAlive = getHealth()/10;
        int noOfDied = force/10;
        System.out.println(getName() + " pretrpjeli napad od "+attacker.getName()+" u kojem ih je poginulo "+noOfDied+
                ", ostalo ih je još "+noAlive);
    }
}


