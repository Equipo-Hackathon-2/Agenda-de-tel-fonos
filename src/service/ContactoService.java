package service;

import exceptions.ContactNotFoundException;
import model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactoService {
    private final ArrayList<Contacto> contactos=new ArrayList<>();

    private final int maxContactos;

    public ContactoService() {
        this.maxContactos = 10;
    }
    public ContactoService(int maxContactos) {

        this.maxContactos = maxContactos;
    }

    //---Metodo para agregar contacto a la lista

    public void addContacto(Contacto contacto) {

        // VALIDAR CAMPOS VACIOS
        if(contacto.getFirstName().trim().isEmpty()
                ||
                contacto.getLastName().trim().isEmpty()) {

            System.out.println(
                    "Nombre y apellido obligatorios");

            return;
        }

        if(agendaLlena()) {

            System.out.println(
                    "Agenda llena");

            return;
        }

        if(existeContacto(contacto)) {

            System.out.println(
                    "El contacto ya existe");

            return;
        }

        contactos.add(contacto);

        System.out.println(
                "Contacto agregado");
    }

    //---Verificar si un contacto existe en la lista

    public boolean existeContacto(
            Contacto contacto) {

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
    public Contacto buscarContacto(String firstName, String lastName)
            throws ContactNotFoundException {

        for (Contacto contacto : contactos) {

            if (contacto.getFirstName().equalsIgnoreCase(firstName)
                    && contacto.getLastName().equalsIgnoreCase(lastName)) {

                return contacto;
            }
        }

        throw new ContactNotFoundException(
                "No se encontró un contacto con el nombre "
                        + firstName + " " + lastName
        );
    }

    //--Eliminar contacto

    //--Modificar telefono

    //--Agenda llena

    //--Espacios libres
    public int espaciosLibres(){
        int numContactos = contactos.size();

        return maxContactos - numContactos;
    }
}