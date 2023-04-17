package model;

import java.util.Objects;

public abstract class Resource {
    //Абстрактный класс модель "Ингридиент"
    private double totalResourceAmount;
    //Количество ресурса

    public Resource() {
    }

    public Resource(double totalResourceAmount) {
        setTotalResourceAmount(totalResourceAmount);
    }

    public double getTotalResourceAmount() {
        return totalResourceAmount;
    }

    public void setTotalResourceAmount(double totalResourceAmount) {
        validate(totalResourceAmount);
        this.totalResourceAmount = totalResourceAmount;
    }

    public abstract void validate(double resourceAmount);

    public abstract String getName();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Double.compare(resource.totalResourceAmount, totalResourceAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalResourceAmount);
    }
}
