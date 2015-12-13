package participants;

/**
 * Created by adrianzgaljic on 10/12/15.
 * Vehicle is type of war participants which carries crew of other participants.
 * Vehicles can be destroyed when their healh or crew is reducet to zero.
 */
public class Vehicle extends WarParticipant {


    /**
     * number of personel in vehicle
     */
    private int crew;

    public Vehicle() {
    }

    public int getCrew() {
        if (crew<=0){
            return 0;
        } else {
            return crew;
        }
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    /**
     * this method is used to calculate number of vehicles destroyed in attack
     * it is used because only whole number of vehicles can be destroyed in one attack
     * @param force force of attack
     * @param vehicleHealth health of individual vehicle (equals to number of soldiers operating it * soldier health)
     * @return calculated force
     */
    public int quantify(int force, int vehicleHealth){
        int noOfDied = Math.round(force/(float)vehicleHealth);
        return noOfDied*vehicleHealth;
    }

    @Override
    public void attack(WarParticipant target) {

    }

    @Override
    public void defend(WarParticipant attacker, int force) {

    }
}
