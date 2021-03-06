/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Clases.clsReportePorDepartamento;
import Clases.clsReportePorEdad;
import Clases.clsReportePorEstadoActual;
import Clases.clsReportePorMunicipio;
import controller.CasosController;
import controller.DepartamentoController;
import controller.MunicipioController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import models.Departamento;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.DefaultTableXYDataset;


/**
 *
 * @author user
 */



public class View extends javax.swing.JFrame {

    DepartamentoController depController = new DepartamentoController();
    MunicipioController municipioController = new MunicipioController();
    CasosController casoscontroller = new CasosController();
    
    LinkedList<clsReportePorEdad> ListaPorEdad = new LinkedList<>();
    LinkedList<clsReportePorMunicipio> ListaPorMunicipio = new LinkedList<>();
    LinkedList<clsReportePorDepartamento> ListaPorDepartamento = new LinkedList<>();
    LinkedList<clsReportePorEstadoActual> ListaPorEstadoActual = new LinkedList<>();
    
    
    private Departamento departamento = null;
    private ArrayList<Departamento> globalDepList = new ArrayList();
    
    public View() {
        initComponents();
        this.showPanelFrom();
        this.casoscontroller = new CasosController();
        this.ListaPorEdad = casoscontroller.listaporedad();
        this.ListaPorMunicipio = casoscontroller.listapormunicipio();
        this.ListaPorDepartamento = casoscontroller.listaPorDepartamento();
        this.ListaPorEstadoActual = casoscontroller.listaPorEstadoActual();               
        this.fillDepList();
        this.generaciondereporteporedad();
        this.generaciondereportepormunicipio();
        this.generaciondeReportePorDepartamento();
        this.generaciondeReportePorEstadoActual();
    }
    
    private void showPanelFrom(){
        this.jPanel1.setVisible( departamento != null );
        
        if( departamento != null && departamento.getId() != null ){
            this.btnDelete.setVisible( true );
            this.depNombre.setText( departamento.getNombre() );
            this.depCodigo.setText( departamento.getCodigo().toString() );
        } else {
            this.btnDelete.setVisible( false );
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        departamentoList = new javax.swing.JList<>();
        btnNewDepartamento = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        depNombre = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        depCodigo = new javax.swing.JTextField();
        jpreporteporedad = new javax.swing.JPanel();
        bExportarInf1 = new javax.swing.JButton();
        jpreportepormunicipio = new javax.swing.JPanel();
        bExportarPorMunicipo = new javax.swing.JButton();
        jpReportePorDepartamento = new javax.swing.JPanel();
        bExportarPorDepartamento = new javax.swing.JButton();
        jpReporteEstadoActual = new javax.swing.JPanel();
        bExportarPorEstadoActual = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Departamentos");

        departamentoList.setToolTipText("");
        departamentoList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departamentoListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(departamentoList);

        btnNewDepartamento.setText("Nuevo Departamento");
        btnNewDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewDepartamentoActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Codigo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(depNombre)
            .addComponent(depCodigo)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(depNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(depCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewDepartamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNewDepartamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Departamentos", jPanel2);

        bExportarInf1.setText("Exportar");
        bExportarInf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExportarInf1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpreporteporedadLayout = new javax.swing.GroupLayout(jpreporteporedad);
        jpreporteporedad.setLayout(jpreporteporedadLayout);
        jpreporteporedadLayout.setHorizontalGroup(
            jpreporteporedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpreporteporedadLayout.createSequentialGroup()
                .addContainerGap(466, Short.MAX_VALUE)
                .addComponent(bExportarInf1)
                .addContainerGap())
        );
        jpreporteporedadLayout.setVerticalGroup(
            jpreporteporedadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpreporteporedadLayout.createSequentialGroup()
                .addComponent(bExportarInf1)
                .addGap(0, 327, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reporte por edad", jpreporteporedad);

        bExportarPorMunicipo.setText("Exportar");
        bExportarPorMunicipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExportarPorMunicipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpreportepormunicipioLayout = new javax.swing.GroupLayout(jpreportepormunicipio);
        jpreportepormunicipio.setLayout(jpreportepormunicipioLayout);
        jpreportepormunicipioLayout.setHorizontalGroup(
            jpreportepormunicipioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpreportepormunicipioLayout.createSequentialGroup()
                .addGap(0, 476, Short.MAX_VALUE)
                .addComponent(bExportarPorMunicipo))
        );
        jpreportepormunicipioLayout.setVerticalGroup(
            jpreportepormunicipioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpreportepormunicipioLayout.createSequentialGroup()
                .addComponent(bExportarPorMunicipo)
                .addGap(0, 327, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reporte Casos por Municipio", jpreportepormunicipio);

        bExportarPorDepartamento.setText("Exportar");
        bExportarPorDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExportarPorDepartamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpReportePorDepartamentoLayout = new javax.swing.GroupLayout(jpReportePorDepartamento);
        jpReportePorDepartamento.setLayout(jpReportePorDepartamentoLayout);
        jpReportePorDepartamentoLayout.setHorizontalGroup(
            jpReportePorDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpReportePorDepartamentoLayout.createSequentialGroup()
                .addGap(0, 476, Short.MAX_VALUE)
                .addComponent(bExportarPorDepartamento))
        );
        jpReportePorDepartamentoLayout.setVerticalGroup(
            jpReportePorDepartamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpReportePorDepartamentoLayout.createSequentialGroup()
                .addComponent(bExportarPorDepartamento)
                .addGap(0, 327, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reporte Casos por departamento", jpReportePorDepartamento);

        bExportarPorEstadoActual.setText("Exportar");
        bExportarPorEstadoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExportarPorEstadoActualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpReporteEstadoActualLayout = new javax.swing.GroupLayout(jpReporteEstadoActual);
        jpReporteEstadoActual.setLayout(jpReporteEstadoActualLayout);
        jpReporteEstadoActualLayout.setHorizontalGroup(
            jpReporteEstadoActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpReporteEstadoActualLayout.createSequentialGroup()
                .addGap(0, 476, Short.MAX_VALUE)
                .addComponent(bExportarPorEstadoActual))
        );
        jpReporteEstadoActualLayout.setVerticalGroup(
            jpReporteEstadoActualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpReporteEstadoActualLayout.createSequentialGroup()
                .addComponent(bExportarPorEstadoActual)
                .addGap(0, 327, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reporte por estado actual", jpReporteEstadoActual);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Integer id = this.departamento.getId();
        this.depController.deleteDepartamento(id);
        this.btnCancelActionPerformed(evt);
        this.fillDepList();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String nombre = this.depNombre.getText();
        String strCode = this.depCodigo.getText();
        try{
            depController.saveDepartamento(this.departamento.getId(), nombre, strCode);
            JOptionPane.showMessageDialog(this, "Se guardo correctamente.");
            this.limpiarDepForm();
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage() );
        }        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.limpiarDepForm();
        this.departamento = null;
        this.showPanelFrom();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNewDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewDepartamentoActionPerformed
        this.departamento = new Departamento();
        this.showPanelFrom();
    }//GEN-LAST:event_btnNewDepartamentoActionPerformed

    private void departamentoListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departamentoListMouseClicked
        JList target = (JList) evt.getSource();
        int index = target.locationToIndex( evt.getPoint() );
        this.departamento = this.globalDepList.get(index);
        this.showPanelFrom();
    }//GEN-LAST:event_departamentoListMouseClicked

    private void bExportarInf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExportarInf1ActionPerformed
        // bExportarInf1
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        book.setSheetName(0, "informe por edad");
        
        String[] headers = new String[]{
            "edad",
            "cantidad casos",
        };
        CellStyle headerCellStyle = book.createCellStyle();
        HSSFFont font = book.createFont();
        font.setBold(true);
        headerCellStyle.setFont(font);
        
        HSSFRow headersRow = sheet.createRow(0);
        for (int i = 0; i < headers.length ; i++){
            String header = headers[i];
            HSSFCell cell = headersRow.createCell(i);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue(header);                       
        }
        
        for (int i = 0; i < ListaPorEdad.size() ; i++){
            HSSFRow row = sheet.createRow(i+1);
            int edad = ListaPorEdad.get(i).getEdad();
            int cantidadCasos = ListaPorEdad.get(i).getAmountcasosporedad();
            row.createCell(0).setCellValue(edad);
            row.createCell(1).setCellValue(cantidadCasos);
        }
        try {
            FileOutputStream file = new FileOutputStream("reporte por edad.xls");
            book.write(file);
            file.close();
            JOptionPane.showMessageDialog(this, "exportado correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bExportarInf1ActionPerformed

    private void bExportarPorMunicipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExportarPorMunicipoActionPerformed
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        book.setSheetName(0, "informe por municipio");
        
        String[] headers = new String[]{
            "municipio",
            "cantidad casos",
        };
        CellStyle headerCellStyle = book.createCellStyle();
        HSSFFont font = book.createFont();
        font.setBold(true);
        headerCellStyle.setFont(font);
        
        HSSFRow headersRow = sheet.createRow(0);
        for (int i = 0; i < headers.length ; i++){
            String header = headers[i];
            HSSFCell cell = headersRow.createCell(i);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue(header);                       
        }
        
        for (int i = 0; i < ListaPorMunicipio.size() ; i++){
            HSSFRow row = sheet.createRow(i+1);
            String municipio = ListaPorMunicipio.get(i).getNombremunicipio();
            int cantidadCasos = ListaPorMunicipio.get(i).getAmountcasospormunicipio();
            row.createCell(0).setCellValue(municipio);
            row.createCell(1).setCellValue(cantidadCasos);
        }
        try {
            FileOutputStream file = new FileOutputStream("reporte por municipio.xls");
            book.write(file);
            file.close();
            JOptionPane.showMessageDialog(this, "exportado correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_bExportarPorMunicipoActionPerformed

    private void bExportarPorEstadoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExportarPorEstadoActualActionPerformed
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        book.setSheetName(0, "informe por estado actual");
        
        String[] headers = new String[]{
            "estado actual",
            "cantidad casos",
        };
        CellStyle headerCellStyle = book.createCellStyle();
        HSSFFont font = book.createFont();
        font.setBold(true);
        headerCellStyle.setFont(font);
        
        HSSFRow headersRow = sheet.createRow(0);
        for (int i = 0; i < headers.length ; i++){
            String header = headers[i];
            HSSFCell cell = headersRow.createCell(i);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue(header);                       
        }
        
        for (int i = 0; i < ListaPorEstadoActual.size() ; i++){
            HSSFRow row = sheet.createRow(i+1);
            String estadoactual = ListaPorEstadoActual.get(i).getEstadoactual();
            int cantidadCasos = ListaPorEstadoActual.get(i).getAmountestadoactual();
            row.createCell(0).setCellValue(estadoactual);
            row.createCell(1).setCellValue(cantidadCasos);
        }
        try {
            FileOutputStream file = new FileOutputStream("reporte por estado actual.xls");
            book.write(file);
            file.close();
            JOptionPane.showMessageDialog(this, "exportado correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bExportarPorEstadoActualActionPerformed

    private void bExportarPorDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExportarPorDepartamentoActionPerformed
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        book.setSheetName(0, "informe por departamento");
        
        String[] headers = new String[]{
            "departamento",
            "cantidad casos",
        };
        CellStyle headerCellStyle = book.createCellStyle();
        HSSFFont font = book.createFont();
        font.setBold(true);
        headerCellStyle.setFont(font);
        
        HSSFRow headersRow = sheet.createRow(0);
        for (int i = 0; i < headers.length ; i++){
            String header = headers[i];
            HSSFCell cell = headersRow.createCell(i);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue(header);                       
        }
        
        for (int i = 0; i < ListaPorDepartamento.size() ; i++){
            HSSFRow row = sheet.createRow(i+1);
            String departamento = ListaPorDepartamento.get(i).getNombredepartamento();
            int cantidadCasos = ListaPorDepartamento.get(i).getAmountcasospordepartamento();
            row.createCell(0).setCellValue(departamento);
            row.createCell(1).setCellValue(cantidadCasos);
        }
        try {
            FileOutputStream file = new FileOutputStream("reporte por departamento.xls");
            book.write(file);
            file.close();
            JOptionPane.showMessageDialog(this, "exportado correctamente");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bExportarPorDepartamentoActionPerformed

    public void limpiarDepForm(){
        this.depNombre.setText("");
        this.depCodigo.setText("");
        this.fillDepList();
    }
    
    public void fillDepList(){
        this.globalDepList = this.depController.getDepartamentoList();
        DefaultListModel model = new DefaultListModel();
        
        int count = 0;
        for(Departamento dep : this.globalDepList){
            model.add(count, dep.getCodigo() + ". " + dep.getNombre() );
            count++;
        }
        
        this.departamentoList.setModel( model );
    }
    
    private void generaciondereporteporedad(){
        LinkedList<clsReportePorEdad> reporte = casoscontroller.listaporedad();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (clsReportePorEdad reportePorEdad : reporte) {
            dataset.addValue(reportePorEdad.getAmountcasosporedad(), "casos", reportePorEdad.getEdad().toString());
                       
        }
        JFreeChart chart = ChartFactory.createLineChart("Casos Covid","edad","casos",dataset,PlotOrientation.VERTICAL,true,true,false);
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        jpreporteporedad.setLayout(new java.awt.BorderLayout());
        jpreporteporedad.add(panel,BorderLayout.CENTER);
        jpreporteporedad.validate();
        
    }
    
    
    private void generaciondereportepormunicipio(){
        LinkedList<clsReportePorMunicipio> reporte = casoscontroller.listapormunicipio();
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (clsReportePorMunicipio reportePorMunicipio : reporte) {
            dataset.setValue(reportePorMunicipio.getNombremunicipio(), reportePorMunicipio.getAmountcasospormunicipio());
            
        }
        JFreeChart chartmunicipio = ChartFactory.createPieChart("casos covid por municipio", dataset);
        ChartPanel panel = new ChartPanel(chartmunicipio);
        panel.setMouseWheelEnabled(true);
        jpreportepormunicipio.setLayout(new java.awt.BorderLayout());
        jpreportepormunicipio.add(panel,BorderLayout.CENTER);
        jpreportepormunicipio.validate();
                
    }
    
    private void generaciondeReportePorDepartamento(){
        LinkedList<clsReportePorDepartamento> reporte = casoscontroller.listaPorDepartamento();
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (clsReportePorDepartamento reportePorDepartamento : reporte) {
            dataset.setValue(reportePorDepartamento.getNombredepartamento(), reportePorDepartamento.getAmountcasospordepartamento());
            
        }
        JFreeChart chartdepartamento = ChartFactory.createPieChart("casos covid por departamento", dataset);
        ChartPanel panel = new ChartPanel(chartdepartamento);
        panel.setMouseWheelEnabled(true);
        jpReportePorDepartamento.setLayout(new java.awt.BorderLayout());
        jpReportePorDepartamento.add(panel,BorderLayout.CENTER);
        jpReportePorDepartamento.validate();
                
    }
    
    private void generaciondeReportePorEstadoActual(){
        LinkedList<clsReportePorEstadoActual> reporte = casoscontroller.listaPorEstadoActual();
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (clsReportePorEstadoActual reportePorEstadoActual : reporte) {
            dataset.setValue(reportePorEstadoActual.getEstadoactual(), reportePorEstadoActual.getAmountestadoactual());
            
        }
        JFreeChart chart = ChartFactory.createPieChart("casos covid por estado actual", dataset);
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        jpReporteEstadoActual.setLayout(new java.awt.BorderLayout());
        jpReporteEstadoActual.add(panel,BorderLayout.CENTER);
        jpReporteEstadoActual.validate();
                
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bExportarInf1;
    private javax.swing.JButton bExportarPorDepartamento;
    private javax.swing.JButton bExportarPorEstadoActual;
    private javax.swing.JButton bExportarPorMunicipo;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNewDepartamento;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField depCodigo;
    private javax.swing.JTextField depNombre;
    private javax.swing.JList<String> departamentoList;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpReporteEstadoActual;
    private javax.swing.JPanel jpReportePorDepartamento;
    private javax.swing.JPanel jpreporteporedad;
    private javax.swing.JPanel jpreportepormunicipio;
    // End of variables declaration//GEN-END:variables
}
