package weapons;

/**
 * Created by adrianzgaljic on 09/12/15.
 * LightSaber is weapon used by the Jedi and the Sith.
 */
public class LightSaber implements Weapon {

    /**
     * lightsaber color
     */
    private String color;

    /**
     * lightsaber force, amount of damage it can make to enemy
     */
    private int force;

    /**
     * Constructor
     * @param color lightsaber color
     */
    public LightSaber(String color){
        this.color = color;
    }

    /**
     * Setter for force, force depends on person using lightsaber
     * @param force amount of force
     */
    public void setForce(int force){
        this.force = force;
    }

    @Override
    public int fire() {
        return force;
    }
}
