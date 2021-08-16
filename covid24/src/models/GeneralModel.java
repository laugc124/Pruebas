package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.db.Models;


public class GeneralModel extends Models{

    
    public ArrayList<Departamento> getDepartamentoList(){
        ArrayList<Departamento> depList = new ArrayList();
        
        try(Connection conn = super.conectar()){
            String query = "SELECT dep.id, dep.nombre, dep.codigo FROM departamento dep order by dep.codigo";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                Departamento dep = new Departamento();
                dep.setId( result.getInt("id") );
                dep.setNombre( result.getString("nombre") );
                dep.setCodigo( result.getInt("codigo") );
                depList.add( dep );
            }
        } catch(Exception e){
            System.out.println("No se puede cargar la lista de Departamento");
        }
        
        return depList;
    }
    
    public ArrayList<Municipio> getMunicipioList(){
        ArrayList<Municipio> munList = new ArrayList();
        
        try(Connection conn = super.conectar()){
            String query = "SELECT mun.id, mun.nombre, mun.codigo FROM municipio mun order by mun.codigo";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                Municipio mun = new Municipio();
                mun.setId( result.getInt("id") );
                mun.setNombre( result.getString("nombre") );
                mun.setCodigo( result.getInt("codigo") );
                munList.add(mun);
            }
        } catch(Exception e){
            System.out.println("No se puede cargar la lista de Departamento");
        }
        
        return munList;
    }
    
    
    
    
    @Override
    public Object find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void startDbTest() {
        try(Connection conn = startpruebas()){
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
