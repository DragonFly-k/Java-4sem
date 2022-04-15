package Planet;

public class Planet {
    private String name;
    private float radius;
    private float temperature;
    private boolean atmosphere;
    private boolean life;
    private String sputnik;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public boolean isAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(boolean atmosphere) {
        this.atmosphere = atmosphere;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public String getSputnik() {
        return sputnik;
    }

    public void setSputnik(String sputnik) {
        this.sputnik = sputnik;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", radius=" + radius +
                ", temperature=" + temperature +
                ", atmosphere=" + atmosphere +
                ", life=" + life +
                ", sputnik='" + sputnik + '\'' +
                '}';
    }
}