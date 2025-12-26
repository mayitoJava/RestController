package AVilchis.ProgramacionNCapasNoviembre25.DAO;

import AVilchis.ProgramacionNCapasNoviembre25.JPA.Colonia;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ColoniaJPADAOImplementation implements IColoniaJPA{
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public Result GetAll(){
         Result result = new Result();
        try{
            TypedQuery<Colonia> queryColonia = entityManager.createQuery("FROM Colonia", Colonia.class);
            List<Colonia> colonias = queryColonia.getResultList();
            result.Object = colonias;
            result.Correct = true;
            result.StatusCode = 200;
        }catch (Exception ex){
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.StatusCode = 400;
        }
        return result;
    }
    
    @Transactional
    @Override
    public Result GetById(int IdMunicipio){
        Result result = new Result();
        try{
            String jpql = "SELECT c FROM Colonia c WHERE c.Municipio.IdMunicipio = :IdParam ";
            List<Colonia> listaMunicipios = entityManager
                    .createQuery(jpql, Colonia.class)
                    .setParameter("IdParam", IdMunicipio)
                    .getResultList();
            result.Object = listaMunicipios;
            result.Correct = true;
            result.StatusCode = 200;
        }catch(Exception ex){
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.StatusCode = 400;
        }
        return result;
    }
    
}
