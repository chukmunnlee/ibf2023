package day09.revision.car;

public class MainCar {

   public static void main(String[] args) {
      Car toyota = new Car();
      toyota.setMake("toyota");
      Car.assignRegistration(toyota);

      Car honda = new Car();
      honda.setMake("honda");
      Car.assignRegistration(honda);

      toyota.setWheels(4);
      System.out.printf("1. toyota: %s, %s, %d\n", toyota.getRegistration()
         , toyota.getMake(), toyota.getWheels());

      honda.setWheels(2);
      System.out.printf("2. honda: %s, %s, %d\n", honda.getRegistration()
         , honda.getMake(), honda.getWheels());

      System.out.printf("3. toyota: %s, %d\n", toyota.getMake(), toyota.getWheels());

      Honda civic = new Honda();

      System.out.printf("3. civic: %s, %d\n", civic.getMake(), civic.getWheels());
      civic.horn();
   }
   
}