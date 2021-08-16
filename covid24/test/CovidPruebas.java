/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.DepartamentoController;
import controller.MunicipioController;
import java.util.List;
import models.Departamento;
import models.GeneralModel;
import models.Municipio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.db.DBConf;

/**
 *
 * @author agos1
 */
public class CovidPruebas {
    
    MunicipioController municipiocontroller = new MunicipioController();
    DepartamentoController DepartamentoCtl = new DepartamentoController();
    
    public CovidPruebas() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DBConf.testMode = true;
        new GeneralModel().startpruebas();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     //@Test
     //public void hello() {}
     
     @Test
     public void readMunicipioTest(){
         Municipio municipio = new Municipio();
         municipio.find(2);
         assertEquals(municipio.getNombre(), "ABEJORRAL");
         
     }
     
     @Test
     public void deleteMunicipioTest(){
         Municipio municipio = (Municipio) new Municipio().find(1);
         
         municipio.delete();
         Municipio municipioValidacion = (Municipio) new Municipio().find(1);
         if (municipioValidacion !=null){
             assertTrue(false);
         }
         
     }
     
     @Test
     public void editarDepartamentoTest() throws Exception{
       List<Departamento> DepList = DepartamentoCtl.getDepartamentoList();
       String deptnombre = DepList.get(10).getNombre();
       
       DepartamentoCtl.saveDepartamento(11,"cambio providencia", "56");
       List<Departamento> DepList1 = DepartamentoCtl.getDepartamentoList();
       String deptnuevo = DepList1.get(10).getNombre();
       
       Assert.assertNotEquals(deptnombre,deptnuevo);
     }
     
     @Test
     public void crearDepartamentoTest() throws Exception{
         List<Departamento> deptlist = DepartamentoCtl.getDepartamentoList();
         int cantdepartamento = deptlist.size();
         DepartamentoCtl.saveDepartamento(null, "nuevo antioquia", "100");
         List<Departamento> deptlist1 = DepartamentoCtl.getDepartamentoList();
         Assert.assertNotEquals(cantdepartamento,deptlist1.size());
     }
}
