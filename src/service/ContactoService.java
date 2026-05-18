package service;

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

        //--Eliminar contacto

        //--Modificar telefono

        //--Agenda llena

        //--Espacios libres
        public int espaciosLibres(){
            int limite = 10;
            int numContactos = contactos.size();

            return limite - numContactos;
        }

}
