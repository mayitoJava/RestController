package AVilchis.ProgramacionNCapasNoviembre25.DAO;

import AVilchis.ProgramacionNCapasNoviembre25.JPA.Result;

public interface IColoniaJPA {
    public Result GetAll();
    public Result GetById(int IdMunicipio);
}
