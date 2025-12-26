package AVilchis.ProgramacionNCapasNoviembre25.DAO;

import AVilchis.ProgramacionNCapasNoviembre25.JPA.Pais;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PaisJPADAOImplementation implements IPaisJPA{
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public Result GetAll(){
        Result result = new Result();
        try{
            TypedQuery<Pais> queryPais = entityManager.createQuery("FROM Pais", Pais.class);
            List<Pais> paises = queryPais.getResultList();
            result.Object = paises;
            result.Correct = true;
            result.StatusCode = 200;
        }catch(Exception ex){
            result.Correct = false;
            result.ex = ex;
            result.StatusCode = 500;
        }
        return result;
    }
}
