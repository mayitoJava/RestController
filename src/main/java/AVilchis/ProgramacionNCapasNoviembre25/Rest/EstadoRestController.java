package AVilchis.ProgramacionNCapasNoviembre25.Rest;

import AVilchis.ProgramacionNCapasNoviembre25.DAO.EstadoJPADAOImplementation;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Estado")
public class EstadoRestController {
    
    @Autowired
    private EstadoJPADAOImplementation estadoJPADAOImplementation;
    
    @GetMapping
    public ResponseEntity GetAll(){
        Result result = estadoJPADAOImplementation.GetAll();
        return ResponseEntity.status(result.StatusCode).body(result);
    }
    
    @GetMapping("/GetEstadoByPais/{IdPais}")
    public ResponseEntity GetById(@PathVariable("IdPais") int IdPais){
        Result result = estadoJPADAOImplementation.GetById(IdPais);
        return ResponseEntity.status(result.StatusCode).body(result);
    }
    
}
