package AVilchis.ProgramacionNCapasNoviembre25.DAO;

import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Usuario;

public interface IUsuarioJPA {

    public Result GetAll();

    public Result GetById(int IdUsuario);

    public Result Add(Usuario usuario);

    public Result Update(Usuario usuario);

    public Result Delete(int IdUsuario);

  public Result CambiarStatus(int IdUsuario, int status);
}
