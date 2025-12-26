package AVilchis.ProgramacionNCapasNoviembre25.DAO;

import AVilchis.ProgramacionNCapasNoviembre25.JPA.Municipio;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MunicipioJPADAOImplementation implements IMunicipioJPA{
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public Result GetAll(){
        Result result = new Result();
        try{
            TypedQuery<Municipio> queryMunicipio = entityManager.createQuery("FROM Municipio", Municipio.class);
            List<Municipio> municipios = queryMunicipio.getResultList();
            result.Object = municipios;
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
    public Result GetById(int IdEstado){
        Result result = new Result();
        try{
            String jpql = "SELECT m FROM Municipio m WHERE m.Estado.IdEstado = :IdParam ";
            List<Municipio> listaMunicipios = entityManager
                    .createQuery(jpql, Municipio.class)
                    .setParameter("IdParam", IdEstado)
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
