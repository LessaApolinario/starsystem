import java.util.Random;

public class Planet {
  Random rng = new Random();
  private String name; // the name of the planet
  private int distanceFromStar; // how far is the planet from the star
  private double mass; // how heavy the planet is
  private int numberOfMoons; // How many stars orbit the planet
  private boolean hasRings; // does he have rings or not?
  private int diameter; // How wide is the planet
  private String type; // rocky or gas planet
  private double temperature; // How hot is the planet

  public Planet(int distanceFromStar, double mass, int numberOfMoons, int diameter, String type, double temperature) {
    // setting up a random name for the planet
    String[] names = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Kepler-452b", "HD 209458b"};
    int index = rng.nextInt(names.length);
    this.name = names[index];

    if (distanceFromStar > 0) {
      this.distanceFromStar = distanceFromStar;
    }

    if (mass > 0) {
      this.mass = mass;
    }

    if (numberOfMoons >= 0) {
      this.numberOfMoons = numberOfMoons;
    }

    // determining whether the planet has rings
    int num = rng.nextInt(2);

    if (num == 1) {
      this.hasRings = true;
    } else {
      this.hasRings = false;
    }

    if (diameter > 0) {
      this.diameter = diameter;
    }

    this.type = type;

    this.temperature = temperature;
  }

  // getters and setters
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setDistanceFromStar(int distanceFromStar) {
    if (distanceFromStar > 0) {
      this.distanceFromStar = distanceFromStar;
    }
  }

  public int getDistanceFromStar() {
    return distanceFromStar;
  }

  public void setMass(double mass) {
    if (mass > 0) {
      this.mass = mass;
    }
  }

  public double getMass() {
    return mass;
  }

  public void setNumberOfMoons(int numberOfMoons) {
    if (numberOfMoons >= 0) {
      this.numberOfMoons = numberOfMoons;
    }
  }

  public int getNumberOfMoons() {
    return numberOfMoons;
  }

  public void setDiameter(int diameter) {
    if (diameter > 0) {
      this.diameter = diameter;
    }
  }

  public int getDiameter() {
    return diameter;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  public double getTemperature() {
    return temperature;
  }

  @Override
  public String toString() {
    if (this.hasRings) {
      return "" + getName() + " is " + getDistanceFromStar() + " km from its star and has rings." + " Its mass is " + getMass() + " kg and it has " + getNumberOfMoons() + " moons in its orbit. In addition, its diameter measures " + getDiameter() + " km, it is " + getType() + " and its temperatures is " + getTemperature() + " degrees Celsius.";
    }

    return "" + getName() + " is " + getDistanceFromStar() + " km from its star and has no rings." + " Its mass is " + getMass() + " kg and it has " + getNumberOfMoons() + " moons in its orbit. In addition, its diameter measures " + getDiameter() + " km, it is " + getType() + " and its temperatures is " + getTemperature() + " degrees Celsius.";
  }
}
