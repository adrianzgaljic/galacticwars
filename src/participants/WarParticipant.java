package participants;

import java.util.ArrayList;

/**
 * Created by adrianzgaljic on 09/12/15.
 * Abstract class which is extended by all participants in battle, e.g. soldiers, aircrafts, vehicles.
 */
public abstract class WarParticipant implements Runnable {

    public abstract void attack();

    public abstract void defend();

    public abstract String getName();

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

    @Override
    public void run() {
        int time;
        int numberOfEnemies;
        int targetIndex;
        while (health > 0) {
            time = random.nextInt(10000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            numberOfEnemies = enemyParticipants.size();
            targetIndex = random.nextInt(numberOfEnemies);
            System.out.println(getName() + " napada " + enemyParticipants.get(targetIndex).getName());
            enemyParticipants.get(targetIndex).defend();
        }
    }


}
