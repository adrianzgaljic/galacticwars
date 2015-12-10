package participants.rebelalliance;

import participants.WarParticipant;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by adrianzgaljic on 09/12/15.
 * LukeSkywalker is singleton class which represents Jedi Luke Skywalker
 */
public class LukeSkywalker extends WarParticipant{


    Random random = new Random();

    /**
     * health represents condition of character
     * when reduced to zero or less, character (thread) dies
     */
    private int health = 1000;


    /**
     * randomly generated unique identification number
     * id is generated outside this class
     */
    private String id;

    /**
     * setter for empireParticipants
     * @param enemyParticipants
     */
    public void setEmpireParticipants(ArrayList<WarParticipant> enemyParticipants) {
        this.enemyParticipants = enemyParticipants;
    }

    /**
     * list of war participans on the opposite side (enemies)
     * list is used to attact enemies
     */
    ArrayList<WarParticipant> enemyParticipants = new ArrayList<>();


    /**
     * name of character
     */
    private final String name = "Luke Skywalker";

    /**
     * only instance of LukeSkywalker  class
     */
    private static  LukeSkywalker lukeSkywalker  = new LukeSkywalker();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private LukeSkywalker(){}

    /**
     * getter for id
     * @return id
     */
    public String getId() {
        return id;
    }


    /**
     * setter for id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getter for name
     * @return character name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for only instance of LukeSkywalker  class
     * @return LukeSkywalker instance
     */
    public static LukeSkywalker getInstance(){
        return lukeSkywalker;
    }


    @Override
    public void attack() {


    }

    @Override
    public void defend() {
        System.out.println(getName()+" primio udarac");
    }
/*
    @Override
    public void run() {
        int time;
        int numberOfEnemies;
        int targetIndex;
        while(health>0){
            time = random.nextInt(10000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            numberOfEnemies = empireParticipants.size();
            targetIndex = random.nextInt(numberOfEnemies);
            System.out.println(getName()+" napada "+empireParticipants.get(targetIndex).getName());
            empireParticipants.get(targetIndex).defend();
        }
    }*/
}
