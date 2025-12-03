package com.example.simulacro.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.simulacro.Tipo;
import com.example.simulacro.entity.Vw;
import com.example.simulacro.service.VwService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;


//restController sirve para que lo que devuelva sea un json
//y el controller sirve para devolver una pagina web
@RestController
@RequestMapping("/vw")
public class VwController {

    @Autowired
    private VwService vwService;




    // el GET de todos Los modelos
    @GetMapping
    public List<Vw> getAll() {
        // llamamos al service
        return vwService.findAll();
    }



    // el GET de los modelos segun el tipo
    @GetMapping("/tipo/{tipo}")
    public List<Vw> getByTipo(@PathVariable Tipo tipo) {
        // llamamos al metodo que creamos antes en el service
        return vwService.findByTipos(tipo);
    }




    // el GET segun la fecha
    @GetMapping("/fecha/{fecha}")
    public List<Vw> getByFecha(@PathVariable Date fecha) {
        // llamamos al metodo que creamos antes en el service
        return vwService.findByFechas(fecha);
    }




    // el GET segun el nombre
    @GetMapping("/nombre/{nombre}")
    public List<Vw> getByFechaDeCreacion(@PathVariable String nombre) {
        // llamamos al metodo que creamos antes en el service
        return vwService.findByNombres(nombre);
    }




    // el PUT del tipo segun el id
    @PutMapping("/{id}/tipo")
    public ResponseEntity<Vw> updateCondicion(

            @PathVariable Long id,
            //aqui lo que esta haciendo es coger el tipo desde el cuerpo del postman
            @RequestBody String nuevoTipo) {

                //aqui llama al servicio para actualizar el tipo
        Vw tipoActualizado = vwService.updateTipo(id, nuevoTipo);

        //si el tipo por lo que sea es null devuelve un 400 bad request
        if (tipoActualizado == null) {
            return ResponseEntity.badRequest().build();
        }

        //si no es null devuelve el coche con el tipo ya actualizado
        return ResponseEntity.ok(tipoActualizado);
    }



    // esto es el POST
    @PostMapping
    public ResponseEntity<Vw> create(@RequestBody Vw vw) {

        //ponemos el id en null porque es autoincremental en la BD
        vw.setId(null);
        
        //devolvemos el coche guardado
        return ResponseEntity.ok(vwService.save(vw));
    
    }


    // esto es el DELETE y lo hacemos mediante el id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        //aqui lo que hace es que si es distetinto de los ids que hay da error
        if (!vwService.existsById(id)) {

            return ResponseEntity.notFound().build();

        }

        //si el id existe le borra
        vwService.deleteById(id);

        return ResponseEntity.noContent().build();

    }


    //segun darle a postman tenemos que crear uno nuevo de lo que hay encima del boton azul
    //una vez creado le seleccionamos y cuando estemos dentro apareceran 3 botones
    //que estan debajo del boton azul de antes. le daremos al del medio y crearemos un nuevo enviroment
    //ponemos en variable esto baseURL y debajo esto otro simulacroPath
    //luego a la derecha de baseURL le ponemos http://localhost:8080
    //y a la derecha de simulacroPath ponemos la ruta que tengamos en el @requesmaping en este caso /vw
}
