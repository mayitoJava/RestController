package AVilchis.ProgramacionNCapasNoviembre25.Rest;

import AVilchis.ProgramacionNCapasNoviembre25.DAO.DireccionJPADAOImplementation;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Direccion;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/direccion")
public class DireccionRestController {

    @Autowired
    DireccionJPADAOImplementation direccionJPADAOImplementation;

    @GetMapping("/{IdDireccion}")
    public ResponseEntity GetById(@PathVariable("IdDireccion") int IdDireccion) {
        Result result = direccionJPADAOImplementation.GetById(IdDireccion);
        return ResponseEntity.status(result.StatusCode).body(result);
    }

    @PostMapping("agregar/{IdUsuario}")
    public ResponseEntity Add(@PathVariable("IdUsuario") int IdUsuario, @RequestBody Direccion direccion) {
        Result result = direccionJPADAOImplementation.Add(direccion, IdUsuario);
        return ResponseEntity.status(result.StatusCode).body(result);
    }

    @PutMapping("editar")
    public ResponseEntity Update(@RequestBody Direccion direccion) {
        Result result = direccionJPADAOImplementation.Update(direccion);
        return ResponseEntity.status(result.StatusCode).body(result);
    }

    @DeleteMapping("/{IdDireccion}")
    public ResponseEntity Delete(@PathVariable int IdDireccion) {
        Result result = direccionJPADAOImplementation.Delete(IdDireccion);
        return ResponseEntity.status(result.StatusCode).body(result);
    }
}
