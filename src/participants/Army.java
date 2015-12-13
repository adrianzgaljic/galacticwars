package participants;

/**
 * Created by adrianzgaljic on 13/12/15.
 * This class is extended by all armies, adding quantify functionality to regular war participant.
 */
public class Army extends WarParticipant {
    @Override
    public void attack(WarParticipant target) {

    }

    @Override
    public void defend(WarParticipant attacker, int force) {

    }

    /**
     * this method is used to calculate number of soldiers that died in attack
     * it is used because only whole number of soldier can die in one attack
     * @param force force of attack
     * @param individualHealth health of individual soldier
     * @return calculated force
     */
    public int quantify(int force, int individualHealth){
        int noOfDied = Math.round(force/(float)individualHealth);
        return noOfDied*individualHealth;
    }


}
