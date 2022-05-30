import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeroesMain {
    public static void main(String[] args) {
        try (// Objects of the hero class can be instantiated here
                Scanner s = new Scanner(System.in)) {
            System.out.println("Create a Hero object");
            System.out.println("Name: ");
            String name = s.nextLine();
            System.out.println("Role: ");
            String role = s.nextLine();
            System.out.println("Age: ");
            int age = s.nextInt();
            s.nextLine();
            System.out.println("Difficulty: ");
            String difficulty = s.nextLine();
            System.out.println("Weapons: ");

            List<String> weapons = new ArrayList<String>();
            int weaponLimit = 0;
            do {
                System.out.println("Add a weapon");
                String add = s.nextLine();
                weaponLimit++;
                weapons.add(add);
            } while (weaponLimit < 3);

            // s.nextLine();
            System.out.println("Abilities: ");
            List<String> abilities = new ArrayList<String>();
            int abilityLimit = 0;
            do {
                System.out.println("Add an ability"); 
                String add2 = s.nextLine();
                abilityLimit++;
                abilities.add(add2);
            } while (abilityLimit < 3);

            // s.nextLine();
            System.out.println("Occupation: ");
            String occupation = s.nextLine();
            System.out.println("Base of operation: ");
            String boa = s.nextLine();
            System.out.println("Affiliation: ");
            String affiliation = s.nextLine();

            Heroes hero2 = new Heroes(name, age, role, difficulty, weapons, abilities, occupation, boa, affiliation);

            // Usig the default hero method which should return information about default
            // hero - Soldier 76
            Heroes hero1 = new Heroes();
            System.out.println(hero1);
            System.out.println(hero2);

        }
        catch(Exception e){
            System.out.println("Something went wrong");
        }

       // Writing to  file
       
        try {
            //creating a writer object
            BufferedWriter bw = new BufferedWriter(new FileWriter("heroes.txt"));

            //writing to a text file
            bw.write("Testing");
            bw.newLine();
            bw.write("Ending test");

            bw.close();

        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
