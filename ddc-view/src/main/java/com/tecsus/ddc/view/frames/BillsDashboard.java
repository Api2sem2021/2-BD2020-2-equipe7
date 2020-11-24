/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecsus.ddc.view.frames;

import com.tecsus.ddc.bills.Bill;
import com.tecsus.ddc.controller.service.AbstractBillService;

import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author SND19050
 */
public class BillsDashboard extends javax.swing.JInternalFrame {

    private final AbstractBillService billService;

    /**
     * Creates new form BillsDashboard
     */
    public BillsDashboard(final AbstractBillService service) {
        this.billService = service;
        initComponents();
        populateTable();
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
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Número", "Tipo de conta", "Instalação", "Cliente", "Concessionária", "Data de vencimento", "Valor", "Data de cadastro", "Consumo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void populateTable() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<Bill> bills = billService.findAll();

        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < 8; ++i)
            for (Bill bill : bills) {
                table.addRow(new String[] {
                        bill.getNumConta(),
                        "",
                        bill.getInstalation().getNumInst(),
                        "",
                        "",
                        dateFormat.format(bill.getVencimento().toDate()),
                        bill.getValor().toString(),
                        "",
                        ""});
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
