package AVilchis.ProgramacionNCapasNoviembre25.DAO;

import AVilchis.ProgramacionNCapasNoviembre25.JPA.Estado;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EstadoJPADAOImplementation implements IEstadoJPA {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Result GetAll() {
        Result result = new Result();
        try {
            TypedQuery<Estado> queryEstado = entityManager.createQuery("FROM Estado", Estado.class);
            List<Estado> estados = queryEstado.getResultList();
            result.Object = estados;
            result.Correct = true;
            result.StatusCode = 200;
        } catch (Exception ex) {
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.StatusCode = 400;
        }
        return result;
    }

    @Transactional
    @Override
    public Result GetById(int IdPais) {
        Result result = new Result();
        try {
            String jpql = "SELECT e FROM Estado e WHERE e.Pais.IdPais = :IdParam ";
            List<Estado> listaEstados = entityManager
                    .createQuery(jpql, Estado.class)
                    .setParameter("IdParam", IdPais)
                    .getResultList();
            result.Object = listaEstados;
            result.Correct = true;
            result.StatusCode = 200;
        } catch (Exception ex) {
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.StatusCode = 400;
        }
        return result;
    }
    
}
