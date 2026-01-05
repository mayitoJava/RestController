package AVilchis.ProgramacionNCapasNoviembre25.DAO;

import AVilchis.ProgramacionNCapasNoviembre25.JPA.Direccion;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DireccionJPADAOImplementation implements IDireccionJPA {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public Result Add(Direccion direccion, int IdUsuario) {
        Result result = new Result();
        try {
            direccion.usuario = new Usuario();
            direccion.usuario.setIdUsuario(IdUsuario);
            entityManager.persist(direccion);
            result.Correct = true;
            if (result.Correct) {
                result.Object = "Agregado";
                result.StatusCode = 201;
            } else {
                result.StatusCode = 500;
                result.Object = "No agregado";
            }
        } catch (Exception ex) {
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.StatusCode = 500;
        }
        return result;
    }

    @Transactional
    @Override
    public Result Update(Direccion direccion) {
        Result result = new Result();
        try {
            Direccion dir = entityManager.find(direccion.getClass(), direccion.getIdDireccion());
            direccion.usuario = new Usuario();
            direccion.usuario.setIdUsuario(dir.usuario.getIdUsuario());
            entityManager.merge(direccion);
            result.Object = direccion;
            result.Correct = true;
            result.StatusCode = 200;
        } catch (Exception ex) {
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.StatusCode = 500;
        }
        return result;
    }

    @Transactional
    @Override
    public Result Delete(int IdDireccion) {
        Result result = new Result();
        try {
            Direccion direccion = entityManager.find(Direccion.class, IdDireccion);
            entityManager.remove(direccion);

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
    public Result GetById(int IdDireccion) {
        Result result = new Result();
        try {
            Usuario direccionid = entityManager.find(Usuario.class, IdDireccion);
            result.Object = direccionid;
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
