package participants;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by adrianzgaljic on 09/12/15.
 * LukeSkywalker is singleton class which represents Jedi Luke Skywalker
 */
public abstract class WP implements Runnable {

    /**
     * minimum time between two attacks
     */
    final int MIN_ATTACK_INTERVAL = 30000;

    /**
     * maximum time between two attacks
     */
    final int MAX_ATTACK_INTERVAL = 100000;

    public abstract void attack();

    public abstract void defend();

    Random random = new Random();

    /**
     * health represents condition of character
     * when reduced to zero or less, character (thread) dies
     */
    private int health;


    /**
     * randomly generated unique identification number
     * id is generated outside this class
     */
    private String id;

    /**
     * list of war participans on the opposite side (enemies)
     * list is used to attact enemies
     */
    ArrayList<WarParticipant> enemyParticipants = new ArrayList<>();

    /**
     * name of character
     */
    private String name;


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
     * setter for enemyParticipants
     * @param enemyParticipants
     */
    public void setEnemyParticipants(ArrayList<WarParticipant> enemyParticipants) {
        this.enemyParticipants = enemyParticipants;
    }

    /**
     * getter for name
     * @return character name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for name
     * @param name character name
     */
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        int time;
        int numberOfEnemies;
        int targetIndex;
        while (health > 0) {
            time = MIN_ATTACK_INTERVAL+ random.nextInt(MAX_ATTACK_INTERVAL-MIN_ATTACK_INTERVAL);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            attack();
            /*
            numberOfEnemies = enemyParticipants.size();
            targetIndex = random.nextInt(numberOfEnemies);
            System.out.println(getName() + " napada " + enemyParticipants.get(targetIndex).getName());
            enemyParticipants.get(targetIndex).defend();
            */
        }
    }






}

