import java.util.regex.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static int DemanderAge() {
        Scanner scanner = new Scanner(System.in);
        byte age = 0;
        while (age <= 0) {
            System.out.println("Donnez votre âge maintenant :");
            try {
                age = scanner.nextByte();
                if (age <= 0) {
                    System.out.println("ERREUR: Veuillez rentrer un âge au-dessus de 0 !");
                }

            } catch (InputMismatchException e) {
                System.out.println("ERREUR : Veuillez rentrer un nombre correct !");
                scanner.nextLine();
            }
        }
        return age;
    }

    public static String DemanderNom() {
        Scanner scanner = new Scanner(System.in);

        // Demande le nom de la personne :
        String name = "";
        while (!Pattern.matches("^[a-zA-Z]+$", name)) {
            System.out.println("Bonjour Monsieur ! Veuillez rentre un nom :");
            name = scanner.nextLine();

            if (name.isEmpty()) {
                System.out.println("ERREUR : Le nom ne doit pas être une chaine de caractères vide");
            } else if (name.contains(" ")) {
                System.out.println("ERREUR : Le nom ne doit pas contenir d'espace !");
            } else if (name.matches(".*[0-9].*")) {
                System.out.println("ERREUR: Le nom ne doit pas contenir de chiffre !");
            }
        }
        return name;
    }

    public static void main(String[] args) {
        // Demande le nom de la personne :
        String name = DemanderNom();

        // Demande l'âge de la personne :
        int age = DemanderAge();
        System.out.println("Vous vous appellez " + name + ", et vous avez " + age + " ans !");

    }
}
