package AVilchis.ProgramacionNCapasNoviembre25.Rest;

import AVilchis.ProgramacionNCapasNoviembre25.DAO.UsuarioJPADAOImplementation;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class UsuarioRestController {

    @Autowired
    UsuarioJPADAOImplementation usuarioJPADAOImplementation;

    @GetMapping
    public ResponseEntity GetAll() {
        Result result = usuarioJPADAOImplementation.GetAll();
        return ResponseEntity.status(result.StatusCode).body(result);
    }

    @GetMapping("/{IdUsuario}")
    public ResponseEntity GetById(@PathVariable("IdUsuario") int IdUsuario) {
        Result result = usuarioJPADAOImplementation.GetById(IdUsuario);
        return ResponseEntity.status(result.StatusCode).body(result);
    }

    @PostMapping
    public ResponseEntity Add(@RequestBody Usuario usuario) {
        Result result = usuarioJPADAOImplementation.Add(usuario);
        return ResponseEntity.status(result.StatusCode).body(result);
    }

    @PutMapping
    public ResponseEntity Update(@RequestBody Usuario usuario) {
        Result result = usuarioJPADAOImplementation.Update(usuario);
        return ResponseEntity.status(result.StatusCode).body(result);
    }

    @DeleteMapping("/{IdUsuario}")
    public ResponseEntity Delete(@PathVariable int IdUsuario) {
        Result result = usuarioJPADAOImplementation.Delete(IdUsuario);
        return ResponseEntity.status(result.StatusCode).body(result);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/status/{id}/{status}")
    public ResponseEntity<Result> CambiarStatus(
            @PathVariable int id,
            @PathVariable int status) {

        Result result = usuarioJPADAOImplementation.CambiarStatus(id, status);
        return ResponseEntity.status(result.StatusCode).body(result);
    }

    @PostMapping("/GetAllDinamico")
    public ResponseEntity getAllD(@RequestBody Usuario usuario) {
        Result result = usuarioJPADAOImplementation.GetAllDinamico(usuario);
        return ResponseEntity.status(result.StatusCode).body(result);
    }

}
