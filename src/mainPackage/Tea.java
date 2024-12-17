package mainPackage;

public class Tea extends Food implements Nutritions {
    private String color;

    public Tea(String color) {
        super("Чай");
        this.color = color;
    }

    public void consume() {
        System.out.println(this + " выпит");
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Tea)) return false;
            return color.equals(((Tea)arg0).color);
        } else
            return false;
    }

    @Override
    public String toString() {
        return super.toString() + " цвета '" + color + "'";
    }

    public double calculateCalories() {
        switch (color.toLowerCase()) {
            case "чёрный":
                return 3;
            case "зелёный":
                return 1;
            case "цветной":
                return 2;
            default:
                System.out.println(this + " отсутствует в списке продуктов. Калорийность данного продукта не учитывается.");
                return 0;
        }
    }
}