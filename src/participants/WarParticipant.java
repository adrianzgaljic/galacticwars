package participants;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by adrianzgaljic on 09/12/15.
 * WarParticipant represents all war participants e.g. Jedis, Siths, armies or vehicles
 */
public abstract class WarParticipant implements Runnable {

    /**
     * minimum time between two attacks
     */
    final int MIN_ATTACK_INTERVAL = 1000;

    /**
     * maximum time between two attacks
     */
    final int MAX_ATTACK_INTERVAL = 2000;

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



    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public void setEnemyParticipants(ArrayList<WarParticipant> enemyParticipants) {
        this.enemyParticipants = enemyParticipants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        int time;
        int numberOfEnemies;
        int targetIndex;
        WarParticipant target = null;
        System.out.println(getName()+" startao");
        while (getHealth() > 0) {
            time = MIN_ATTACK_INTERVAL+ random.nextInt(MAX_ATTACK_INTERVAL-MIN_ATTACK_INTERVAL);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            numberOfEnemies = enemyParticipants.size();
            if (numberOfEnemies>0){
                targetIndex = random.nextInt(numberOfEnemies);
                target = enemyParticipants.get(targetIndex);
                attack(target);
            }


        }
        System.out.println(getName() + " umireeem");
        try{
            target.enemyParticipants.remove(this);
        }catch(NullPointerException e){
            System.err.println("Target isn't initialized");
        }


    }

    /**
     * methot that represents attack on target
     * @param target randomly choosen enemy
     */
    public abstract void attack(WarParticipant target);

    /**
     * method which is called by attacker when war participant (target) is attacked
     * war participant can defend, lose some of it's health or die instantly
     * @param attacker enemy who is attacking this war participant
     * @param force  force used to attack
     */
    public abstract void defend(WarParticipant attacker, int force);






}

