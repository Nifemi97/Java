import java.util.Arrays;

/*Creating a hero
A hero consists of
Name
Age
Role - e.g tank, damage, support
Difficulty
Weapons - array
Abilities - array
Occupation
Base of operation
Affiliation


Catch phrase

*/

public class Heroes {

    // setting hero variables. setting the default hero to Soldier 76
    public String name = "Soldier 76";
    public int age = 000;
    public String role = "Damage";
    public String difficulty = "Easy";
    public String[] weapons = {"Heavy Pulse Rifle"};
    public String[] abilities = {"Sprint","Biotic Field","Helix Rockets","Tactical Visor"};
    public String occupation = "Vigilante";
    public String boa = "unknown";

    // default hero object
    public Heroes() {

    }

    // creating getters and setters for retrieving/setting information about hero
    // objects
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String[] getWeapons() {
        return weapons;
    }

    public void setWeapons(String[] weapons) {
        this.weapons = weapons;
    }

    public String[] getAbilities() {
        return abilities;
    }

    public void setAbilities(String[] abilities) {
        this.abilities = abilities;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBoa() {
        return boa;
    }

    public void setBoa(String boa) {
        this.boa = boa;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String affiliation;

    // information requried to create a new hero object
    public Heroes(String name, int age, String role, String difficulty, String[] weapons, String[] abilities,
            String occupation, String boa, String affiliation) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.difficulty = difficulty;
        this.weapons = weapons;
        this.abilities = abilities;
        this.occupation = occupation;
        this.boa = boa;
        this.affiliation = affiliation;
    }

    @Override
    public String toString() {
        return "Hero: " + name + " Age: " + age + " Role: " + role + " Difficulty: " + difficulty + " Weapons: " + weapons + " Abilities: " + abilities + " Occupation: " + occupation + 
        " Base of operation: " + boa + " Affiliation: " + affiliation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Heroes other = (Heroes) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        return true;
    }

}