package RPG;

import java.util.Scanner;

public class Monk extends Heroses implements Statistic, Lvl{

    //prywatna zmienna poziomu
    private int level;
    int i;

    //utworzenie obiektu mnicha
    Monk(double strenght, double defence, double intelligence, double dextrity, double agility, double speed, int level, String fly){
        super(strenght, defence, intelligence, dextrity, agility, speed, fly);
        this.level = level;
    }

    //wyswietlenie statystyk wykorzystując interfejs
    @Override
    public String getStatisticInfo() {
        return "MONK STATISTIC: \nSTRENGHT:\t\t" + getStrenght() + "\nDEFENCE:\t\t" + getDefence() + "\nINTELLIGENCE:\t"
                + getIntelligence() + "\nDEXTRITY:\t\t" + getDextrity() + "\nAGILITY:\t\t" + getAgility() + "\nSPEED:\t\t\t"
                + getSpeed() + "\nLEVEL:\t\t\t" + level + "\nFLY:\t\t\t" + fly + "\n";
    }

    //rozwój bochatera - rozdzielenie pkt doswiadczenia o indywidualne wskazniki
    @Override
    public void lvlUp() {
        this.level++;
        System.out.println("Congratulations, your character has advanced one level. " +
                "You have 10 points to allocate in the talent tree.");
        for (i = 10; i > 0; i--){
            System.out.println("Chose:\n1. Strenght\n2. Defence\n3. Intelligence\n4. Dextrity\n5. Agility\n6. Speed\n");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice < 7 && choice > 0){
                switch (choice) {
                    case 1:
                        super.setStrenght(super.getStrenght() + 1.05);
                        break;
                    case 2:
                        super.setDefence(super.getDefence() + 1.2);
                        break;
                    case 3:
                        super.setIntelligence(super.getIntelligence() + 1.1);
                        break;
                    case 4:
                        super.setDextrity(super.getDextrity() + 1.0);
                        break;
                    case 5:
                        super.setAgility(super.getAgility() + 1.02);
                        break;
                    case 6:
                        super.setSpeed(super.getSpeed() + 1.0);
                        break;
                }
            }else{
                System.out.println("You have given a wrong value!");
                i++;
            }
        }
    }
}
