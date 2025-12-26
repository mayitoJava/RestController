package AVilchis.ProgramacionNCapasNoviembre25.DAO;

import AVilchis.ProgramacionNCapasNoviembre25.JPA.Direccion;
import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;

public interface IDireccionJPA {
    public Result Add(Direccion direccion, int IdUsuario);
    public Result Update(Direccion direccion);
    public Result Delete(int IdDireccion);
}
