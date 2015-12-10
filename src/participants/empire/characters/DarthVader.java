package participants.empire.characters;

import participants.WarParticipant;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by adrianzgaljic on 09/12/15.
 * DarthVader is singleton class which represents despicable Sith Darth Vader
 */
public class DarthVader extends WarParticipant{

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
     * setter for rebelParticipants
     * @param rebelParticipants
     */
    public void setRebelParticipants(ArrayList<WarParticipant> rebelParticipants) {
        this.rebelParticipants = rebelParticipants;
    }

    /**
     * list of war participans on the opposite side (enemies)
     * list is used to attact enemies
     */
    ArrayList<WarParticipant> rebelParticipants = new ArrayList<>();


    /**
     * name of character
     */
    private final String name = "Darth Vader";

    /**
     * only instance of DarthVader class
     */
    private static DarthVader darthVader = new DarthVader();

    /**
     * private Constructor prevents any other
     * class from instantiating
     */
    private DarthVader(){}

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
     * getter for only instance of DartVader class
     * @return DarthVader instance
     */
    public static DarthVader getInstance(){
        return darthVader;
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
            numberOfEnemies =  rebelParticipants.size();
            targetIndex = random.nextInt(numberOfEnemies);
            System.out.println(getName()+" napada "+rebelParticipants.get(targetIndex).getName());
            rebelParticipants.get(targetIndex).defend();
        }
    }*/
}
