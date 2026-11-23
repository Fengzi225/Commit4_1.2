/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();

      if (s.getStudents().isEmpty()){
        s.addStudent(new Student("Krzysztof", 20));
        s.addStudent(new Student("Janusz", 40));
      }

      Scanner scanner = new Scanner(System.in);
      boolean running = true;

      while(running){
        System.out.println("\n1 - Dodaj studenta");
        System.out.println("2 - Wyświetl studentów");
        System.out.println("0 - Zakończ");
        System.out.println("Wybierz opcję: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice){
          case 1:
            System.out.print("Podaj imię studenta: ");
            String name = scanner.nextLine();

            if(name.isBlank()){
              System.out.println("Imię nie może być puste");
              break;
            }
            System.out.print("Podaj wiek studenta: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            if(age < 0){
              System.out.println("Wiek nie może być ujemny");
              break;
            }
            s.addStudent(new Student(name,age));
            System.out.println("Dodano studenta");
            break;
            
          case 2:
            var students = s.getStudents();
            for (Student current : students) {
              System.out.println(current.ToString());
            }
            break;

          case 0:
            running = false;
            break;

          default:
            System.out.println("Nieprawidlowa opcja");
        }
      }
      scanner.close();
    } catch (IOException e) {
      System.out.print("Blad  podczas operacji na pliku: " + e.getMessage());
    }
  }
}