package AVilchis.ProgramacionNCapasNoviembre25.DAO;

import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;

public interface IEstadoJPA {
    public Result GetAll();
    public Result GetById(int IdPais);
}
