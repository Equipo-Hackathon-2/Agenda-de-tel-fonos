package service;

import exceptions.ContactNotFoundException;
import model.Contacto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactoService {
    private final ArrayList<Contacto> contactos=new ArrayList<>();

    private final int maxContactos;

    Scanner scan = new Scanner(System.in);

    public ContactoService() {
        this.maxContactos = 10;
    }
    public ContactoService(int maxContactos) {

        this.maxContactos = maxContactos;
    }

    //---Metodo para agregar contacto a la lista

    public void addContacto(Contacto contacto) {
        if(contacto.getFirstName().trim().isEmpty()
                ||
                contacto.getLastName().trim().isEmpty()) {
            System.out.println(
                    "Nombre y apellido obligatorios");
            return;
        }
        if(agendaLlena()) {
            return;
        }
        if(existeContacto(contacto)) {

            System.out.println("El contacto ya existe");
            return;
        }
        contactos.add(contacto);
        System.out.println("Contacto agregado");
    }

    //---Verificar si un contacto existe en la lista
    public boolean existeContacto(
            Contacto contacto) {
        if (contacto == null) {
            return false;
        }

        for (Contacto c : contactos) {
            if (c.getFirstName()
                    .equalsIgnoreCase(
                            contacto.getFirstName())
                    &&
                    c.getLastName()
                            .equalsIgnoreCase(
                                    contacto.getLastName())) {
                return true;
            }
        }
        return false;
    }
    //--Mostrar la lista de contactos
    public List<Contacto> getContactos () {
        return contactos;
    }
    //--Buscar Contacto(String nombre,String Apellido)
    public Contacto buscarContacto(String firstName, String lastName) {
        for (Contacto contacto : contactos) {

            if (contacto.getFirstName().trim()
                    .equalsIgnoreCase(firstName.trim())
                    &&
                    contacto.getLastName().trim()
                            .equalsIgnoreCase(lastName.trim())) {

                return contacto;
            }
        }

        throw new ContactNotFoundException(
                "No se encontró el contacto: "
                        + firstName + " " + lastName
        );
    }
    //--Eliminar contacto
    public void eliminarContacto(String firstName, String lastName) {
        Contacto contacto = buscarContacto(firstName, lastName);
        contactos.remove(contacto);
        System.out.println("Contacto " + firstName + " " + lastName + " eliminado de manera correcta");
    }
    //--Modificar telefono
    public void modificarTelefono(String firstName, String lastName) {
        Contacto contacto = buscarContacto(firstName, lastName);
        System.out.print("Introduce el nuevo número telefónico: ");
        contacto.setContactNumber(scan.nextLong());
        System.out.println("Teléfono del contacto " + firstName + " " + lastName + " editado de manera correcta");
    }

    //--Agenda llena
    public boolean agendaLlena() {
        if (contactos.size() >= maxContactos) {
            System.out.println(
                    "La agenda está llena. No hay espacio disponible para nuevos contactos.");
            return true;
        }
        return false;
    }
    //--Espacios libres
    public int espaciosLibres(){
        int numContactos = contactos.size();
        return maxContactos - numContactos;
    }
}