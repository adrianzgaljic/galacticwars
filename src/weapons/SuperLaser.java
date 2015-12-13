package weapons;

import participants.WarParticipant;

/**
 * Created by adrianzgaljic on 10/12/15.
 * Very powerful type of weapon.
 */
public class SuperLaser implements Weapon {

    private long startTime;

    public SuperLaser(){
        startTime = System.currentTimeMillis();
    }

    /**
     * weapon force, amount of damage it can make to enemy
     */
    private final int force = 1000;


    public int getForce() {
        return force;
    }

    @Override
    public void fire(WarParticipant target, WarParticipant attacker, int noOfShooters) {
        long currTime = System.currentTimeMillis();
        long elapsedTime = currTime-startTime;

        if (elapsedTime >= 60000){
            System.out.println("FZZZZZ "+attacker.getName()+" je ispalila Superlaser zraku na "+target.getName());
            startTime = System.currentTimeMillis();
            target.defend(attacker, force);
        } else {
            int chargedPerc = (int)(elapsedTime)/600;
            System.out.println(attacker.getName()+" pokušava ispaliti Superlaser zraku na "+target.getName()+
                    " ali laser je napunjen tek "+chargedPerc+"%");
        }
    }
}
