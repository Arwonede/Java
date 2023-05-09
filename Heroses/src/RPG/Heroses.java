package RPG;

public class Heroses{

    //zmienne prywatne i chronione w danym pakiecie
    private double strenght, defence, intelligence, dextrity, agility, speed;
    protected String fly;

    //uzycie getter i setter do wprowadzania i wyswietlania prywatnych zmiennych
    public double getStrenght() {
        return strenght;
    }

    public void setStrenght(double strenght) {
        this.strenght = strenght;
    }

    public double getDefence() {
        return defence;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public double getDextrity() {
        return dextrity;
    }

    public void setDextrity(double dextrity) {
        this.dextrity = dextrity;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    //metoda bochater posiadający atrybuty
    public Heroses (double strenght, double defence, double intelligence, double dextrity, double agility, double speed){
        this.strenght = strenght;
        this.defence = defence;
        this.intelligence = intelligence;
        this.dextrity = dextrity;
        this.agility = agility;
        this.speed = speed;
    }

    //przeciązenie bochatera o możliwość latania
    public Heroses (double strenght, double defence, double intelligence, double dextrity, double agility, double speed, String fly){
        this.strenght = strenght;
        this.defence = defence;
        this.intelligence = intelligence;
        this.dextrity = dextrity;
        this.agility = agility;
        this.speed = speed;
        this.fly = fly;
    }
}
