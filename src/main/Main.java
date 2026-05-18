package main;

import model.Contacto;
import service.ContactoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactoService service = new ContactoService();
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
                    System.out.println(service.getContactos());
                    break;
                case 2:{
                if(service.agendaLlena()){
                    break;
                }
                    System.out.println("Ingrese el nombre y apellido del contacto a agregar.");
                    System.out.println("Nombre: ");
                    String firstName = scan.next();
                    System.out.println("Apellido: ");
                    String lastName = scan.next();
                    if(service.existeContacto(service.buscarContacto(firstName,lastName))){
                        System.out.println("Ese contacto ya existe. No pueden haber duplicados");
                        break;
                    }
                    System.out.println("Ingrese el número de teléfono del contacto: ");
                    Long numTel = scan.nextLong();
                    Contacto contacto = new Contacto(firstName,lastName,numTel);
                    service.addContacto(contacto);
                    break;}
                case 3:{
                    System.out.println("Ingrese el nombre y apellido del contacto a borrar.");
                    System.out.println("Nombre: ");
                    String firstName = scan.next();
                    System.out.println("Apellido: ");
                    String lastName = scan.next();
                    if(service.existeContacto(service.buscarContacto(firstName,lastName))){
                        service.eliminarContacto(firstName,lastName);
                    } else{
                        System.out.println("No se encontró el contacto.");
                    }
                    break;}
                case 4:{
                    System.out.println("Ingrese el nombre y apellido del contacto a modificar.");
                    System.out.println("Nombre: ");
                    String firstName = scan.next();
                    System.out.println("Apellido: ");
                    String lastName = scan.next();
                    if(service.existeContacto(service.buscarContacto(firstName,lastName))){
                        service.modificarTelefono(firstName,lastName);
                    } else{
                        System.out.println("No se encontró el contacto.");
                    }
                    break;}
                case 5:{
                    System.out.println("Ingrese el nombre y apellido del contacto a evaluar.");
                    System.out.println("Nombre: ");
                    String firstName = scan.next();
                    System.out.println("Apellido: ");
                    String lastName = scan.next();
                    if(service.existeContacto(service.buscarContacto(firstName,lastName))){
                        System.out.println("Ese contacto si existe.");
                        break;
                    } else{
                        System.out.println("Ese contacto no existe.");
                    }
                    break;}
                case 6:{
                    System.out.println("Ingrese el nombre y apellido del contacto a buscar.");
                    System.out.println("Nombre: ");
                    String firstName = scan.next();
                    System.out.println("Apellido: ");
                    String lastName = scan.next();
                    if(service.existeContacto(service.buscarContacto(firstName,lastName))){
                        System.out.println(service.buscarContacto(firstName,lastName));;
                    } else{
                        System.out.println("No se tiene a ese contacto.");
                    }
                    break;}
                case 7:
                    System.out.println("Se tienen un total de "+service.espaciosLibres()+" espacios disponibles.");
                    break;
                case 8:
                    if(service.agendaLlena()){
                        System.out.println("Agenda llena.");
                    } else {
                        System.out.println("Agenda no llena.");
                    }
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
