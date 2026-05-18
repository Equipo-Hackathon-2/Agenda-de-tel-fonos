package service;
import exceptions.ContactNotFoundException;
import model.Contacto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactoService {
        Scanner scan = new Scanner(System.in);
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
        public void eliminarContacto(String firstName, String lastName) throws ContactNotFoundException {
            Contacto contacto = buscarContacto(firstName, lastName);
            contactos.remove(contacto);
            System.out.println("Contacto " + firstName + lastName + " eliminado de manera correcta");
            throw new ContactNotFoundException(
                    "No se encontró un contacto con el nombre "
                            + firstName + " " + lastName
            );
        }

        //--Modificar telefono
        public void modificarTelefono(String firstName, String lastName) throws ContactNotFoundException{
            Contacto contacto = buscarContacto(firstName, lastName);
            System.out.println("Introduce el nuevo número de telefono: ");
            contacto.setContactNumber(scan.nextLong());
            System.out.println("Número de teléfono del contacto " + firstName + lastName + " modificado de manera correcta");
            throw new ContactNotFoundException(
                    "No se encontró un contacto con el nombre "
                            + firstName + " " + lastName
            );
        }

        //--Agenda llena

        //--Espacios libres

}
