package repository;

import model.Contacto;

import java.util.ArrayList;

public class ContactoRepository {

    private ArrayList<Contacto> contactos;

    public ContactoRepository() {

        contactos = new ArrayList<>();
    }

    public ArrayList<Contacto> getContactos() {

        return contactos;
    }

    public void save(Contacto contacto) {

        contactos.add(contacto);
    }

    public boolean delete(Contacto contacto) {

        return contactos.remove(contacto);
    }
}
