package demo;

/**
 * Created by adrianzgaljic on 12/12/15.
 * Thic class stores war patricipant's initial health
 */
public class Health {

    public static final int B1_BATTLE_DROID = 5;
    public static final int IMPERIAL_GUARD = 30;
    public static final int SITHS = 100;
    public static final int JEDIS = 100;
    public static final int STORM_TR = 10;
    public static final int DROIDEKA = 10;
    public static final int EWOKS = 10;
    public static final int WOOKIEES = 20;
    public static final int DARTH_VADER = 1000;
    public static final int DARTH_SIDIOUS = 1000;
    public static final int DARTH_MAUL = 1000;
    public static final int LUKE = 1000;
    public static final int YODA = 800;
    public static final int OBI_WAN = 600;
    //flag which is set to true when war ends
    //every thread checks this flag and ends if it's set to false
    public static boolean isOver = true;

}
