import java.util.Random;
import java.util.Scanner;

public class StarSystem {

  public static void main(String[] args) {
    Random rng = new Random();
    Scanner input = new Scanner(System.in);
    // creating a new planet
    Planet p1 = new Planet(1, 1, 1, 1, "gas", 0);

    // creating an array of planets (the "solar system")
    Planet[] planets = new Planet[10];
    // creating an "option" to let the user add one more planet
    int op = -1;
    int i = 0;
    int distance = 0;

    do {
      System.out.println("Do you want to add a new planet to the star system? ");
      System.out.println("Press 0 to exit: ");
      op = input.nextInt();

      if (op == 0) {
        System.out.println("The star system has ended!");
        break;
      } else {
        try {
          // The planet will move further and further away from the star
          distance += rng.nextInt(1000000000) / 400000;

          p1.setDistanceFromStar(distance);

          if (p1.getDistanceFromStar() > 8000) {
            p1.setType("gas");
          } else {
            p1.setType("rocky");
          }

          if (p1.getType().equals("gas")) {
            p1.setTemperature((double) rng.nextInt(1000000) * (-1));
          } else {
            p1.setTemperature(rng.nextInt(1000000));
          }

          p1.setMass((double) rng.nextInt(500) * 100);
          p1.setNumberOfMoons(rng.nextInt(7));
          p1.setDiameter(rng.nextInt(4) * 1000000);

          planets[i] = new Planet(p1.getDistanceFromStar(), p1.getMass(), p1.getNumberOfMoons(), p1.getDiameter(), p1.getType(), p1.getTemperature());
        } catch (ArrayIndexOutOfBoundsException exception) {
          Planet[] newPLanet = new Planet[planets.length + 1];

          System.arraycopy(planets, 0, newPLanet, 0, planets.length);

          planets = newPLanet;
          planets[i] = new Planet(p1.getDistanceFromStar(), p1.getMass(), p1.getNumberOfMoons(), p1.getDiameter(), p1.getType(), p1.getTemperature());
        } finally {
          i++;
          System.out.println("A new planet has emerged in the star system.");
        }
      }
    } while (op != 0);

    // displaying the planets in the star system
    for (Planet planet : planets) {
      System.out.println(planet);
    }
  }
}
