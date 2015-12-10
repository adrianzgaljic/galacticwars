package participants.empire.characters;

import participants.WarParticipant;
import weapons.LightSaber;
import weapons.Weapon;

import java.util.Random;

/**
 * Created by adrianzgaljic on 09/12/15.
 * DarthVader is singleton class which represents despicable Sith Darth Vader
 */
public class DarthVader extends WarParticipant {


        Random random = new Random();

       /**
           * war participants weapon
        */
        private Weapon weapon = new LightSaber("red",120);


        /**
         * name of character
         */
        private final String name = "Darth Vader";

        /**
         * only instance of DarthVader class
         */
        private static  DarthVader darthVader  = new DarthVader();

        /**
         * private Constructor prevents any other
         * class from instantiating
         */
        private DarthVader(){}

        @Override
        public String getName() {
            return name;
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
            weapon.fire(target, this);


        }

        @Override
        public void defend(WarParticipant attacker, int force) {


            setHealth(getHealth()-force);
            System.out.println(getName() + " primio udarac od "+attacker.getName()+", još mu je preostalo "+getHealth()+" zdravlja");

        }

    }
