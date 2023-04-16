package database;

import java.util.Objects;

public class Resources {
    //Хранит ресурсы кофемашины
    private double totalMilkAmount;
    private double totalWaterAmount;
    private double totalCoffeeBeansAmount;

    public Resources() {
    }

    public Resources(double totalMilkAmount, double totalWaterAmount, double totalCoffeeBeansAmount) {
        this();
        setTotalMilkAmount(totalMilkAmount);
        setTotalWaterAmount(totalWaterAmount);
        setTotalCoffeeBeansAmount(totalCoffeeBeansAmount);
    }

    public double getTotalMilkAmount() {
        return totalMilkAmount;
    }

    public void setTotalMilkAmount(double totalMilkAmount) {
        validate(totalMilkAmount);
        this.totalMilkAmount = totalMilkAmount;
    }

    public double getTotalWaterAmount() {
        return totalWaterAmount;
    }

    public void setTotalWaterAmount(double totalWaterAmount) {
        validate(totalWaterAmount);
        this.totalWaterAmount = totalWaterAmount;
    }

    public double getTotalCoffeeBeansAmount() {
        return totalCoffeeBeansAmount;
    }

    public void setTotalCoffeeBeansAmount(double totalCoffeeBeansAmount) {
        validate(totalCoffeeBeansAmount);
        this.totalCoffeeBeansAmount = totalCoffeeBeansAmount;
    }

    private void validate(double resourceAmount) {
        if (resourceAmount < 0) {
            throw new IllegalArgumentException("Error: Invalid amount of resource\n");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resources resources = (Resources) o;
        return Double.compare(resources.totalMilkAmount, totalMilkAmount) == 0 && Double.compare(resources.totalWaterAmount, totalWaterAmount) == 0 && Double.compare(resources.totalCoffeeBeansAmount, totalCoffeeBeansAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalMilkAmount, totalWaterAmount, totalCoffeeBeansAmount);
    }
}
