package AVilchis.ProgramacionNCapasNoviembre25.Rest;

import AVilchis.ProgramacionNCapasNoviembre25.DAO.ColoniaJPADAOImplementation;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/colonia")
public class ColoniaRestController {
    
    @Autowired
    private ColoniaJPADAOImplementation coloniaJPADAOImplementation;
    
    @GetMapping
    public ResponseEntity GetAll(){
        Result result = coloniaJPADAOImplementation.GetAll();
        return ResponseEntity.status(result.StatusCode).body(result);
    }
    
    @GetMapping("GetColoniaByMunicipio/{IdMunicipio}")
    public ResponseEntity GetById(@PathVariable("IdMunicipio") int IdMunicipio){
        Result result = coloniaJPADAOImplementation.GetById(IdMunicipio);
        return ResponseEntity.status(result.StatusCode).body(result);
    }
    
}
