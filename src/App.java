import java.io.*;

public class App {
    public static void main(String[] args) {
        Console console = System.console();

        // Demande le nom de la personne :
        System.out.println("Bonjour Monsieur ! Veuillez rentre un nom :");
        String name = console.readLine();

        // Demande l'âge de la personne :
        byte age = 0;
        while (age <= 0) {
            System.out.println("Donnez votre âge maintenant :");
            try {
                age = Byte.parseByte(console.readLine());
                if (age <= 0) {
                    System.out.println("Veuillez rentrer un âge convenable, bordel de merde !");
                }

            } catch (NumberFormatException e) {
                System.out.println("ERREUR : Veuillez rentrer un nombre correct !");
            }
        }
        System.out.println("Vous vous appellez " + name + ", et vous avez " + age + " ans !");

    }
}
