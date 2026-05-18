package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("Agenda Telefónica");
            System.out.println("1. Lista de Contactos    2. Añadir Contacto");
            System.out.println("3. Borrar Contacto       4. Modificar Tel. Contacto");
            System.out.println("5. ¿Existe Contacto?     6. Buscar Contacto");
            System.out.println("7. Espacios disponibles  8. ¿Agenda llena?");
            System.out.println("0. Salir del menú");
            System.out.println("Introduce tu opción: ");
            opcion = scan.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Opcion 1");
                    break;
                case 2:
                    System.out.println("Opcion 2");
                    break;
                case 3:
                    System.out.println("Opcion 3");
                    break;
                case 4:
                    System.out.println("Opcion 4");
                    break;
                case 5:
                    System.out.println("Opcion 5");
                    break;
                case 6:
                    System.out.println("opcion 6");
                    break;
                case 7:
                    System.out.println("Opcion 7");
                    break;
                case 8:
                    System.out.println("Opcion 8");
                    break;
                case 0:
                    System.out.println("Vuelva pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while(opcion != 0);
    }
}
