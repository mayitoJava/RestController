package AVilchis.ProgramacionNCapasNoviembre25.Rest;

import AVilchis.ProgramacionNCapasNoviembre25.DAO.PaisJPADAOImplementation;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pais")
public class PaisRestController {
    
    @Autowired
    private PaisJPADAOImplementation paisJPADAOImplementation;
    
    @GetMapping
    public ResponseEntity GetAll(){
        Result result = paisJPADAOImplementation.GetAll();
        return ResponseEntity.status(result.StatusCode).body(result);
    }
    
}
