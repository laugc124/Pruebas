package controller;

import java.util.ArrayList;
import models.Departamento;
import models.GeneralModel;
import models.Municipio;


public class MunicipioController {
    
    
    public ArrayList<Municipio> getMunicipioList(){
        ArrayList<Municipio> munList;
        
        munList = new GeneralModel().getMunicipioList();
        
        return munList;
    }
    
    
    public void saveMunicipio(Integer id, Integer departamento_id,String name, Integer code) throws Exception{
        int codigo = 0;
        String departamento = null;
        Municipio new_mun = null;
        new_mun.setNombre(name);
        new_mun.setDepartamento(departamento);
        new_mun.setCodigo(codigo);
        
        
    }
}
