package com.example.simulacro.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.simulacro.Tipo;
import com.example.simulacro.entity.Vw;
import com.example.simulacro.repository.VwRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VwService {

    private final VwRepository VwRepository;

    public VwService(VwRepository VwRepository) {
        this.VwRepository = VwRepository;
    }

    // metodo del service para recoger todos los modelos de coches
    // esto posteriormente sera el GET de todos los modelos
    public List<Vw> findAll() {
        return VwRepository.findAll();
    }

    // metodo que devuelve la condicion
    // esto posteriormente sera el GET de los modelos segun el tipo que pongamos
    public List<Vw> findByTipos(Tipo tipo) {
        // este metodo es el que creamos antes en el repository
        return VwRepository.findByTipo(tipo);
    }

    // metodo que devuelve el nombre
    // esto posteriormente sera el GET de los modelos segun el nombre que pongamos
    public List<Vw> findByNombres(String nombre) {
        // este metodo es el que creamos antes en el repository
        return VwRepository.findByNombre(nombre);
    }

    // metodo que devuelve la condicion
    // esto posteriormente sera el GET de los modelos segun la fehca de creacion que
    // pongamos
    public List<Vw> findByFechas(Date fehca) {
        // este metodo es el que creamos antes en el repository
        return VwRepository.findByFecha(fehca);
    }

    // metodo que inserta en la base de datos el objeto vw que le damos
    // esto posteriormente sera el POST osea crear
    public Vw save(Vw vw) {
        return VwRepository.save(vw);
    }

    // esto posteriormente sera el PUT osea actualizar

    public Vw updateTipo(Long id, String nuevoTipo) {

        // aqui lo que hace es ver si el tipo que vamos a cambiar no esta vacio
        //y si lo esta devuelve null
        if (nuevoTipo == null) {
            return null;
        }

        // aqui lo que hace es coger el tipo que hemos metido y ponerle en mayusculas y quitarle los espacios
        //para que no haya errores por el formato
        String tipoNormal = nuevoTipo.trim().toUpperCase();

        // aqui lo que hace es comprobar si el tipo que hemos metido es distinto a los que hay
        // y si es distinto a los que hay devuelve null
        if (!tipoNormal.equals("SUV") &&
                !tipoNormal.equals("DEPORTIVO") &&
                !tipoNormal.equals("HTBACH")) {
            return null;
        }

        // aqui lo que hace es si no ha dado null es registrarlo en la base de datos mediante el id
        Vw vw = VwRepository.findById(id).orElse(null);

        // aqui actualiza el tipo
        vw.setTipo(Tipo.valueOf(tipoNormal));

        // y aui guarda el cambio y hace el return
        return VwRepository.save(vw);
    } // auqui termino el put


    //aqui lo que hace es comprobar si el id existe en la base de datos
    public boolean existsById(Long id) {
        return VwRepository.existsById(id);
    }


    //aqui lo que se hace es el DELETE
    //borra de la base de datos mediante el id
    // aqui comprueba si existe con el metodo anterior y si existe lo elimina
    //y si no existe lanza una excepcion de que ese id no esta en la base de datos
    public void deleteById(Long id) {


        if (VwRepository.existsById(id)) {

            VwRepository.deleteById(id);

        } else {

            throw new EntityNotFoundException("Vw con id " + id + " no existe");
        }
    }

}
