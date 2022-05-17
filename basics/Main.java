package basics;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int dogCount = 2;
    System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

    int catCount = 0;
    System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + "."); 
    
    int turtleCount = 0;
    System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

    flipNHeads(1);
    clock();
  }

  public static String pluralize(String word, int animalCount) {
    if (animalCount == 0 || animalCount > 1) {
      return word + "s";
    } else {
      return word;
    }
  }

  public static void flipNHeads(int n) {
    Random rand = new Random(); 
    int flips = 0;
    int headcount = 0; 
    while (headcount != n) {
      float rando = rand.nextInt(10);
      rando /= 10;
      flips++;
      if(rando < 0.5){
        continue;
        
      } else {
        headcount++;
      }
      System.out.println("It took " + flips + " flip(s) to flip " + n + " heads in a row.");
    }

  }

  public static void clock() {
    String tempTime = "";
    while (true) {
      LocalDateTime present = LocalDateTime.now();
      DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("HH:mm:ss:");
      String formatDateTime = present.format(formattedTime);
      if(!formatDateTime.equals(tempTime)) {
        System.out.println(formatDateTime);
      }
      tempTime = formatDateTime;
    }

  }
}