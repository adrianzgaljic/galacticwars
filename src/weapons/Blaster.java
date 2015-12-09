package weapons;

/**
 * Created by adrianzgaljic on 09/12/15.
 * A blaster is type of ranged weapon that fired bolts of intense light energy.
 */
public class Blaster implements Weapon{

    @Override
    public int fire() {
        return 50;
    }
}
