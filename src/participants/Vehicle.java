package participants;

/**
 * Created by adrianzgaljic on 10/12/15.
 */
public class Vehicle extends WarParticipant {


    /**
     * number of personel in vehicle
     */
    private int crew;

    public int getCrew() {
        return crew;
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
