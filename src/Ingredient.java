public class Ingredient {
    private String name;
    private String measure;
    private double amount;

    public Ingredient(String name, String measure, double amount) {
        this.name = name;
        this.measure = measure;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getMeasure() {
        return measure;
    }

    public double getAmount() {
        return amount;
    }

}
