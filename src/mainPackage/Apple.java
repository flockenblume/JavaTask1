package mainPackage;

public class Apple extends Food implements Nutritions{
    private String size;
    public Apple(String size) {
        super("Яблоко");
        this.size = size;
    }
    public void consume() {
        System.out.println(this + " съедено");
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple)arg0).size);
        } else
            return false;
    }
    public String toString() {
        return super.toString() + " размера '" + size + "'";
    }

    public double calculateCalories() {
        switch (size.toLowerCase()) {
            case "маленькое":
                return 52;
            case "среднее":
                return 67;
            case "большое":
                return 82;
            default:
                System.out.println(this + " отсутствует в списке продуктов. Калорийность данного продукта не учитывается.");
                return 0;
        }
    }
}