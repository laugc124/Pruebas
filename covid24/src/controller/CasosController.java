/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Clases.clsReportePorDepartamento;
import Clases.clsReportePorEdad;
import Clases.clsReportePorEstadoActual;
import Clases.clsReportePorMunicipio;
import java.util.LinkedList;
import models.Casos;

/**
 *
 * @author user
 */
public class CasosController {
    private Casos casos;

    public CasosController() {
        this.casos = new Casos();
        
    }
    
    
    
    public LinkedList<clsReportePorEdad> listaporedad(){
        LinkedList<clsReportePorEdad> reporte = this.casos.ListaCasosPorEdad();
        return reporte;
        
    }
    
    public LinkedList<clsReportePorMunicipio> listapormunicipio(){
        LinkedList<clsReportePorMunicipio> reporte = this.casos.ListaCasosPorMunicipio();
        return reporte;
        
    }
    
    public LinkedList<clsReportePorDepartamento> listaPorDepartamento(){
        LinkedList<clsReportePorDepartamento> reporte = this.casos.ListaCasosPorDepartamento();
        return reporte;
    }
    
    public LinkedList<clsReportePorEstadoActual> listaPorEstadoActual(){
        LinkedList<clsReportePorEstadoActual> reporte = this.casos.ListaCasosPorEstadoActual();
        return reporte;
    }
    
    
}
