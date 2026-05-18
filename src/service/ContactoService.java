package service;

import exceptions.ContactNotFoundException;
import model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactoService {
        private final ArrayList<Contacto> contactos=new ArrayList<>();
        //---Metodo para agregar contacto a la lista

        //---Verificar si un contacto existe en la lista

        //--Mostrar la lista de contactos
        public List<Contacto> getContactos(){
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

}
