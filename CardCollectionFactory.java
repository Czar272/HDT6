import java.util.Map;
import java.util.Scanner;

public class CardCollectionFactory {
    public static CardCollection createCardCollection() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona una implementación de Map:");
        System.out.println("1) HashMap");
        System.out.println("2) TreeMap");
        System.out.println("3) LinkedHashMap");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                return new HashMapCardCollection();
            case 2:
                return new TreeMapCardCollection();
            case 3:
                return new LinkedHashMapCardCollection();
            default:
                throw new IllegalArgumentException("Opción inválida");
        }
    }
}
