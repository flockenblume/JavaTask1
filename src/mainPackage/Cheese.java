package mainPackage;

public class Cheese extends Food implements Nutritions {
    public Cheese() {
        super("Сыр");
    }
    public void consume() {
        System.out.println(this + " съеден");
    }

    public double calculateCalories() {
        return 402;
    }
}
