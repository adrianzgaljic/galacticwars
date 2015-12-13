package participants.rebelalliance.characters;

import participants.WarParticipant;
import participants.rebelalliance.vehicles.spaceships.MillenniumFalcon;
import java.util.Random;

/**
 * Created by adrianzgaljic on 13/12/15.
 * Singleton class which represents droid C-3PO
 */
public class C3PO extends WarParticipant {

    private Random random = new Random();


    /**
     * only instance of C3PO  class
     */
    private static  C3PO c3PO  = new C3PO();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private C3PO(){
    }

    @Override
    public String getName() {
        return "C-3PO";
    }




    /**
     * getter for only instance of C3PO  class
     * @return C3PO instance
     */
    public static C3PO getInstance(){
        return c3PO;
    }


    @Override
    public void attack(WarParticipant target) {
        if (random.nextInt(5)==0 && MillenniumFalcon.getInstance().getHealth()>0){
            int damage = random.nextInt(100);
            System.out.println(getName()+" je slučajno napravio "+damage+" štete na Millennium Falconu");
            MillenniumFalcon.getInstance().setHealth(MillenniumFalcon.getInstance().getHealth() - damage);
        }


    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth()-force);
        System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");

    }

}
