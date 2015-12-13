package participants.empire.characters;

import participants.WarParticipant;
import participants.rebelalliance.characters.LukeSkywalker;
import weapons.LightSaber;
import weapons.PureForce;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by adrianzgaljic on 09/12/15.
 * DarthVader is singleton class which represents despicable Sith Darth Vader
 */
public class DarthVader extends WarParticipant {


        Random random = new Random();

        /**
        * war participants weapons
        */
        ArrayList<Weapon> weapons = new ArrayList<>(Arrays.asList(
            new LightSaber("red", 120), new PureForce()));


        /**
         * only instance of DarthVader class
         */
        private static DarthVader darthVader  = new DarthVader();

        /**
         * private Constructor prevents any other
         * class from instantiating
         */
        private DarthVader(){
        }

        @Override
        public String getName() {
            return "Darth Vader";
        }


        /**
         * getter for only instance of DarthVader  class
         * @return DarthVader instance
         */
        public static DarthVader getInstance(){
            return darthVader;
        }


        @Override
        public void attack(WarParticipant target) {
            if (target.getClass().equals(LukeSkywalker.class)){
                System.out.println(getName() + ": Luke come to the dark side!");
            }
            weapons.get(random.nextInt(weapons.size())).fire(target, this, 1);

        }

        @Override
        public void defend(WarParticipant attacker, int force) {

            if (attacker.getClass().equals(LukeSkywalker.class)){
                System.out.println(getName()+": I'm your father Lukeee!");
            }
            setHealth(getHealth()-force);
            System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");

        }

    }
