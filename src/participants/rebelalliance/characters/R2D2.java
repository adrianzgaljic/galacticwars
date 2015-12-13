package participants.rebelalliance.characters;

import participants.WarParticipant;
import participants.rebelalliance.vehicles.spaceships.MillenniumFalcon;

import java.util.Random;

/**
 * Created by adrianzgaljic on 13/12/15.
 * Singleton class which represents droid R2-D2
 */
public class R2D2 extends WarParticipant {

    private Random random = new Random();


    /**
     * only instance of R2D2  class
     */
    private static  R2D2 r2D2  = new R2D2();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private R2D2(){
    }

    @Override
    public String getName() {
        return "R2-D2";
    }




    /**
     * getter for only instance of R2D2  class
     * @return R2D2 instance
     */
    public static R2D2 getInstance(){
        return r2D2;
    }


    @Override
    public void attack(WarParticipant target) {
        if (random.nextInt(5)==0 && MillenniumFalcon.getInstance().getHealth()>0){
            int repair = random.nextInt(100);
            System.out.println(getName()+" je napravio popravak na Millennium Falconu za "+repair);
            MillenniumFalcon.getInstance().setHealth(MillenniumFalcon.getInstance().getHealth()+repair);
        }


    }

    @Override
    public void defend(WarParticipant attacker, int force) {
        setHealth(getHealth()-force);
        System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");

    }

}
