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

    @Override
    public void attack(WarParticipant target) {

    }

    @Override
    public void defend(WarParticipant attacker, int force) {

    }
}
