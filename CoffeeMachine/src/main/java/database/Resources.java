package database;

import model.CoffeeBeansResource;
import model.MilkResource;
import model.WaterResource;

import java.util.Objects;

public class Resources {
    //Хранит ресурсы кофемашины
    private final MilkResource totalMilkAmount = new MilkResource();
    private final WaterResource totalWaterAmount = new WaterResource();
    private final CoffeeBeansResource totalCoffeeBeansAmount = new CoffeeBeansResource();

    public Resources() {
    }

    public Resources(double totalMilkAmount, double totalWaterAmount, double totalCoffeeBeansAmount) {
        setTotalMilkAmount(totalMilkAmount);
        setTotalWaterAmount(totalWaterAmount);
        setTotalCoffeeBeansAmount(totalCoffeeBeansAmount);
    }

    public double getTotalMilkAmount() {
        return totalMilkAmount.getTotalResourceAmount();
    }

    public void setTotalMilkAmount(double totalMilkAmount) {
        this.totalMilkAmount.setTotalResourceAmount(totalMilkAmount);
    }

    public double getTotalWaterAmount() {
        return totalWaterAmount.getTotalResourceAmount();
    }

    public void setTotalWaterAmount(double totalWaterAmount) {
        this.totalWaterAmount.setTotalResourceAmount(totalWaterAmount);
    }

    public double getTotalCoffeeBeansAmount() {
        return totalCoffeeBeansAmount.getTotalResourceAmount();
    }

    public void setTotalCoffeeBeansAmount(double totalCoffeeBeansAmount) {
        this.totalCoffeeBeansAmount.setTotalResourceAmount(totalCoffeeBeansAmount);
    }

    @Override
    public String toString() {
        return "Resources:\n" +
                "totalMilkAmount=" + totalMilkAmount +
                "\ntotalWaterAmount=" + totalWaterAmount +
                "\ntotalCoffeeBeansAmount=" + totalCoffeeBeansAmount +
                '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resources resources = (Resources) o;
        return Objects.equals(totalMilkAmount, resources.totalMilkAmount) && Objects.equals(totalWaterAmount, resources.totalWaterAmount) && Objects.equals(totalCoffeeBeansAmount, resources.totalCoffeeBeansAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalMilkAmount, totalWaterAmount, totalCoffeeBeansAmount);
    }
}
