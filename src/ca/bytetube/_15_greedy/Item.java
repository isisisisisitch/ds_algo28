package ca.bytetube._15_greedy;

public class Item {
    public int weight;
    public int value;
    public double density;


    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        density = value * 1.0 / weight;

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + value +
                ", density=" + density +
                '}';
    }
}
