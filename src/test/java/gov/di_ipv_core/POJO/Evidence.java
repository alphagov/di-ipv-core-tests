package gov.di_ipv_core.POJO;

public class Evidence{
    private int strength;

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "strength=" + strength +
                ", validity=" + validity +
                '}';
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public Evidence(int strength, int validity) {
        this.strength = strength;
        this.validity = validity;
    }

    private int validity;
}