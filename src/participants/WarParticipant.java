package participants;


import demo.Health;

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
     * flag which is set when war participant starts
     * by default set to false to prevent striking target which hasn't started
      */
    private boolean started = false;



    /**
     * health represents condition of character
     * when reduced to zero or less, character (thread) dies
     */
    private int health;


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

    /**
     * war participant's health can be reduced to less than zero when attacked with greater force than health left
     * it's not possible to have negative health, so this method returns 0 for all health values <=0
     * @return health
     */
    public int getHealth() {
        if (health<=0){
            return  0;
        } else {
            return health;
        }

    }

    public void setEnemyParticipants(ArrayList<WarParticipant> enemyParticipants) {
        this.enemyParticipants = enemyParticipants;
    }

    public String getName() {
        return name;
    }


    /**
     * This method is called when war participant is starded, it represents participant's life cycle
     */
    @Override
    public void run() {
        //time between attacks
        int time;
        //number of enemiy participants
        int numberOfEnemies;
        //index of randomly choosen enemy
        int targetIndex;
        //target enemy
        WarParticipant target;
        System.out.println(getName()+" startao");
        Long startTime;

        while (getHealth() > 0 && !Health.isOver) {
            started = true;
            numberOfEnemies = enemyParticipants.size();
            if (numberOfEnemies>0){
                targetIndex = random.nextInt(numberOfEnemies);
                target = enemyParticipants.get(targetIndex);
                if (target.started){
                    attack(target);
                }
            }
            time = MIN_ATTACK_INTERVAL+ random.nextInt(MAX_ATTACK_INTERVAL-MIN_ATTACK_INTERVAL);

            startTime = System.currentTimeMillis();
            while(System.currentTimeMillis()-startTime<time && getHealth()>0){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
        System.out.println(getName() + " umireeem");

        //remove itself from enemy list of enemies when dead
        if (enemyParticipants.size()>0){
                enemyParticipants.get(0).enemyParticipants.remove(this);
        }

    }

    /**
     * method called when army participant
     */
    public void switchSides(){
        System.out.println(getName() + " prelazi na suparničku stranu");
        enemyParticipants.add(this);
        if (enemyParticipants.size()>0){
            enemyParticipants.get(0).enemyParticipants.remove(this);
            this.enemyParticipants = enemyParticipants.get(0).enemyParticipants;
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

