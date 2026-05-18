package main;

import exceptions.ContactNotFoundException;
import model.Contacto;
import service.ContactoService;

public class ContactoMain {

    public static void main(String[] args) {
        Contacto dulce = new Contacto("Dulce",
                        "Villafaña",
                        5571655683L);

        Contacto oscar = new Contacto("Oscar",
                        "Molina",
                        561007958L);

        Contacto olaf = new Contacto("Olaf",
                        "Martínez",
                        5525624519L);

        Contacto liz = new Contacto("Liz",
                        "Martínez",
                        5585367897L);

        Contacto gustavo = new Contacto("Gustavo",
                        "Quiroz",
                        5613739322L);

        ContactoService service = new ContactoService();//Llamar a service
        //--Agregar contacto a la lista
        service.addContacto(dulce);
        service.addContacto(oscar);
        service.addContacto(olaf);
        service.addContacto(liz);
        service.addContacto(gustavo);
        //--Existe contacto
        System.out.println(
                service.existeContacto(dulce));
        //--Mostrar la lista de contactos
        System.out.println(
                service.getContactos());
        //--Buscar contactos
        try {
            System.out.println(
                    service.buscarContacto(
                            "Juan",
                            "Villafaña"));
        } catch (ContactNotFoundException e) {
            System.out.println(
                    e.getMessage());
        }
        //--Modifcar teléfono
        try {service.modificarTelefono(
                    "Juan",
                    "Villafaña");
        } catch (ContactNotFoundException e) {
            System.out.println(
                    e.getMessage());
        }
        //--Eliminar contacto
        try {
            service.eliminarContacto(
                    "Juan",
                    "Villafaña");
        } catch (ContactNotFoundException e) {
            System.out.println(
                    e.getMessage());
        }

        System.out.println(
                service.getContactos());
        //--Agenda llena
        System.out.println(
                service.agendaLlena());
        //--Espacios disponibles en la agenda
        System.out.println(
                service.espaciosLibres());
    }
}
