package utils.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/covid";
    
    
    private String userTest = "root";
    private String passwordTest = "";
    private String urlTestInit = "jdbc:h2:mem:test;MODE=MYSQL;INIT=RUNSCRIPT FROM 'C:/Users/agos1/OneDrive/Escritorio/retos/Reto 6/covid-test-1.sql';DB_CLOSE_DELAY=-1";
    private String urlTest = "jdbc:h2:mem:test;MODE=MYSQL;";                             
    private String driverTest = "org.h2.Driver";
    
    

    public DB() {
        try{
            if( DBConf.testMode ){
                Class.forName( driverTest );
            }else{
                Class.forName( driver );
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Connection conectar(){
        Connection conn = null;
        if( DBConf.testMode ){
            try{
                conn = DriverManager.getConnection(this.urlTest, this.userTest, this.passwordTest);
            }catch(Exception e){
                e.printStackTrace();
                System.err.println("Error al obtener el conector de la base de datos de prueba");
            }
        } else {
            try{
                conn = (Connection) DriverManager.getConnection(url, user, password);
            } catch( Exception e){
                e.printStackTrace();
                System.err.println("Error al obtener el conector");
            }
        }
        
        return conn;
    }
     public Connection startTestDB(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(this.urlTestInit, this.userTest, this.passwordTest);
        } catch( Exception e){
            
            System.err.println("Error al obtener el conector al iniciar la base de datos");
        }
        return conn;
    }
    
    
    
    
    
}
