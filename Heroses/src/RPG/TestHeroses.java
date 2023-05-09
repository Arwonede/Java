package RPG;

public class TestHeroses {
    public static void main(String[] args) {

        //stworzenie bochatera
        Mage mage = new Mage (1.0, 1.0, 5.0, 3.0, 2.0, 5.0, 1);
        Knight knight = new Knight (5.0, 5.0, 1.0, 3.0, 2.0, 1.0, 1);
        Archer archer = new Archer (1.0, 1.0, 2.0, 5.0, 5.0, 3.0, 1);
        Vampire vampire = new Vampire (3.0, 2.0, 5.0, 1.0, 1.0, 5.0, 1, "Yes");
        Monk monk = new Monk (3.0, 5.0, 5.0, 1.0, 2.0, 1.0, 1, "No");

        //wysiwtlenie statystyk początkowych bochatera
        System.out.println(mage.getStatisticInfo());
        System.out.println(knight.getStatisticInfo());
        System.out.println(archer.getStatisticInfo());
        System.out.println(vampire.getStatisticInfo());
        System.out.println(monk.getStatisticInfo());

        //awans bochatera i przydzielanie pkt w drzewie talentow
        mage.lvlUp();
        knight.lvlUp();
        archer.lvlUp();
        vampire.lvlUp();
        monk.lvlUp();

        //ponowne wysiwtlenie statystyk bochatera
        System.out.println(mage.getStatisticInfo());
        System.out.println(knight.getStatisticInfo());
        System.out.println(archer.getStatisticInfo());
        System.out.println(vampire.getStatisticInfo());
        System.out.println(monk.getStatisticInfo());

    }
}
