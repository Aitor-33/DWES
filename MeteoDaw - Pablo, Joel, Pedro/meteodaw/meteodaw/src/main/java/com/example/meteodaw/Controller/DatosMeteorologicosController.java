package com.example.meteodaw.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.meteodaw.entity.Ciudad;
import com.example.meteodaw.entity.DatosMeteorologicos;
import com.example.meteodaw.repository.CiudadRepository;
import com.example.meteodaw.repository.DatosMeteorologicosRepository;

@RestController
@RequestMapping("/api")
public class DatosMeteorologicosController {
    
    private final CiudadRepository ciudadRepository;
    private final DatosMeteorologicosRepository datosMeteorologicosRepository;

    public DatosMeteorologicosController(CiudadRepository ciudadRepository, 
    DatosMeteorologicosRepository datosMeteorologicosRepository){
        this.ciudadRepository = ciudadRepository;
        this.datosMeteorologicosRepository = datosMeteorologicosRepository;
    }

    //GET datos meteorologicos de una ciudad por ID de la ciudad
    //Ejemplo: GET /api/ciudades/1/datosmeteorologicos
    @GetMapping("/ciudades/{ciudadId}/datosmeteorologicos")
    public ResponseEntity<List<DatosMeteorologicos>> getDatosPorCiudad(@PathVariable Long ciudadId) {
        
        if(!ciudadRepository.existsById(ciudadId)){
            return ResponseEntity.notFound().build();
        }

        List<DatosMeteorologicos> datosMeteorologicos = datosMeteorologicosRepository.findByCiudadId(ciudadId);
        return ResponseEntity.ok(datosMeteorologicos);
    }

    //GET datos metorologicos por ID de datos meteorologicos
    //Ejemplo: GET /api/datosmeteorologicos/1
    @GetMapping("/datosmeteorologicos/{id}")
    public ResponseEntity getDatosPorId(@PathVariable Long id) {
        return datosMeteorologicosRepository.findById(id)
        .map(ResponseEntity::ok)//esto es lo mismo que el .ok()
        .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //este es el POST de un dato meteorologico
    @PostMapping("/datosmeteorologicos")
    public ResponseEntity<DatosMeteorologicos> crearDato(@RequestBody DatosMeteorologicos datosMeteorologicos) {

        //este if hace que si el dato ciudad es = null o el id de la ciudad es = a null de un badRequest
        if (datosMeteorologicos.getCiudad() == null || datosMeteorologicos.getCiudad().getId() == null){
            return ResponseEntity.badRequest().build();
        }

        //aqui hace una variable ciudadId y le da el id de la ciudad que has puesto en el body
        Long ciudadId = datosMeteorologicos.getCiudad().getId();

        //Luego aqui crea un objeto ciudad que le da el valor de el id que has recogido arriba para que sea esa ciudad
        Ciudad ciudad = ciudadRepository.findById(ciudadId).orElse(null);
        
        if (ciudad == null){
            return ResponseEntity.badRequest().build();
        }

        //aqui hace un set de la ciudad con el nuevo objeto de ciudad que hemos hecho
        datosMeteorologicos.setCiudad(ciudad);

        //aqui hace un objeto de datos meteorologicos y llama al punto save para guardar el Datos que le has pasado en el body
        DatosMeteorologicos datoGuardado = datosMeteorologicosRepository.save(datosMeteorologicos);

        URI location = URI.create("/api/datosmeteorologicos" + datoGuardado.getId()); //aqi quiza falte una / al final de datosmeteorologicos
        return ResponseEntity.created(location).body(datoGuardado);
    }


    //esto es un DELETE de un dato meteorologico por su id
    @DeleteMapping("/datosmeteorologicos/{id}")
    public ResponseEntity<Void> borrarDato(@PathVariable Long id) {

        //este if lo que hace es llamar al repository a la funcion existById y si no devuelve un id da el error
    if (!datosMeteorologicosRepository.existsById(id)) {
        return ResponseEntity.notFound().build();
    }

    //si a pasado por el if sin dar el error borra el dato meteorologico
    datosMeteorologicosRepository.deleteById(id);
    return ResponseEntity.noContent().build(); // 204
    }

    //PUT de la temperatura en datos meteorologicos
    @PutMapping("/datosmeteorologicos/{id}/temperatura")
    public ResponseEntity<DatosMeteorologicos> actualizarTemperatura(
        @PathVariable Long id,
        @RequestBody Double nuevaTemperatura) {//aqui nos esta pidiendo que en la ruyta le pasemos el id y el body la temperatura

    return datosMeteorologicosRepository.findById(id)
        .map(dato -> {
            dato.setTemperatura(nuevaTemperatura);
            return ResponseEntity.ok(datosMeteorologicosRepository.save(dato));
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //put probabilidad
    @PutMapping("/datosmeteorologicos/{id}/probabilidadlluvia")
    public ResponseEntity<DatosMeteorologicos> actualizarProbabilidad(
        @PathVariable Long id,
        @RequestBody Double nuevaProbabilidad) {//aqui nos pide el id por la ruta y la probabilidad en el body

    return datosMeteorologicosRepository.findById(id)
        .map(dato -> {
            dato.setProbabilidadLluvia(nuevaProbabilidad);
            return ResponseEntity.ok(datosMeteorologicosRepository.save(dato));
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
