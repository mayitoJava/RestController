package AVilchis.ProgramacionNCapasNoviembre25.DAO;

import AVilchis.ProgramacionNCapasNoviembre25.JPA.Usuario;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioJPADAOImplementation implements IUsuarioJPA {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Result GetAll() {
        Result result = new Result();
        try {
            TypedQuery<Usuario> queryUsuario = entityManager.createQuery("FROM Usuario", Usuario.class);
            List<Usuario> usuarios = queryUsuario.getResultList();
            result.Object = usuarios;
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
    public Result GetById(int IdUsuario) {
        Result result = new Result();
        try {
            Usuario usuarioid = entityManager.find(Usuario.class, IdUsuario);
            result.Object = usuarioid;
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
    public Result Add(Usuario usuario) {
        Result result = new Result();
        try {
            entityManager.persist(usuario);
            result.Object = usuario;
            result.Correct = true;
            result.StatusCode = 201;
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
    public Result Update(Usuario usuario) {
        Result result = new Result();
        try {
            entityManager.merge(usuario);
            result.Object = usuario;
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
    public Result Delete(int IdUsuario) {
        Result result = new Result();
        try {
            Usuario usuario = entityManager.find(Usuario.class, IdUsuario);
            entityManager.remove(usuario);

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
    public Result CambiarStatus(int IdUsuario, int status) {
        Result result = new Result();
        try {
            Usuario usuario = entityManager.find(Usuario.class, IdUsuario);

            if (usuario != null) {
                usuario.setStatus(status);
                entityManager.merge(usuario);

                result.Object = status;
                result.Correct = true;
                result.StatusCode = 200;
            } else {
                result.Correct = false;
                result.ErrorMessage = "Usuario no encontrado";
                result.StatusCode = 404;
            }
        } catch (Exception ex) {
            result.Correct = false;
            result.ErrorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.StatusCode = 400;
        }
        return result;
    }

    @Override
    public Result GetAllDinamico(Usuario usuario) {
        Result result = new Result();

        // Evitar null
        String nombre = usuario.getNombre() == null ? "" : usuario.getNombre();
        String apellidoPaterno = usuario.getApellidoPaterno() == null ? "" : usuario.getApellidoPaterno();
        String apellidoMaterno = usuario.getApellidoMaterno() == null ? "" : usuario.getApellidoMaterno();

        String jpql = "FROM Usuario "
                + "WHERE UPPER(Nombre) LIKE UPPER(:nombre) "
                + "AND UPPER(ApellidoPaterno) LIKE UPPER(:apellidoPaterno) "
                + "AND UPPER(ApellidoMaterno) LIKE UPPER(:apellidoMaterno)";

        TypedQuery<Usuario> queryUsuarios
                = entityManager.createQuery(jpql, Usuario.class);

        queryUsuarios.setParameter("nombre", "%" + nombre + "%");
        queryUsuarios.setParameter("apellidoPaterno", "%" + apellidoPaterno + "%");
        queryUsuarios.setParameter("apellidoMaterno", "%" + apellidoMaterno + "%");

        result.Object = queryUsuarios.getResultList();
        result.StatusCode = 200;
        result.Correct = true;

        return result;
    }

}
