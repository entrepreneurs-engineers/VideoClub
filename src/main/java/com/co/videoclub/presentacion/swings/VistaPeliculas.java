
package com.co.videoclub.presentacion.swings;

import com.co.videoclub.controlador.OperacionesPeliculas;
import com.co.videoclub.controlador.OperacionesPeliculasImpl;
import com.co.videoclub.exception.BDException;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import com.co.videoclub.persistencia.dto.Categoria;
import com.co.videoclub.persistencia.dto.Pelicula;
import com.co.videoclub.util.DateUtil;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author davigofr
 */
public class VistaPeliculas extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private OperacionesPeliculas operacionesPeli;
    private Pelicula peliculaSelect;
    private final DateUtil dateUtil;
    
    public VistaPeliculas() {
        initComponents();
        listarPeliculas();
        dateUtil = new DateUtil();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMEditarP = new javax.swing.JPopupMenu();
        jMIEditarP = new javax.swing.JMenuItem();
        jMIEstadoP = new javax.swing.JMenuItem();
        jMIAlquilarP = new javax.swing.JMenuItem();
        jMIDevolverP = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTInformacionPeliculas = new javax.swing.JTable();
        jMBBarraPrincipal = new javax.swing.JMenuBar();
        jMFile = new javax.swing.JMenu();
        jMIsalir = new javax.swing.JMenuItem();
        jMOperaciones = new javax.swing.JMenu();
        jMIAgregarPelicula = new javax.swing.JMenuItem();

        jMIEditarP.setText("Editar pelicula");
        jMIEditarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEditarPActionPerformed(evt);
            }
        });
        jPMEditarP.add(jMIEditarP);

        jMIEstadoP.setText("Estado de la pelicula");
        jMIEstadoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIEstadoPActionPerformed(evt);
            }
        });
        jPMEditarP.add(jMIEstadoP);

        jMIAlquilarP.setText("Alquilar pelicula");
        jMIAlquilarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAlquilarPActionPerformed(evt);
            }
        });
        jPMEditarP.add(jMIAlquilarP);

        jMIDevolverP.setText("Devolver pelicula");
        jMIDevolverP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDevolverPActionPerformed(evt);
            }
        });
        jPMEditarP.add(jMIDevolverP);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listado de peliculas");
        setBounds(new java.awt.Rectangle(150, 60, 500, 500));
        setName("listadoPeliculas"); // NOI18N
        setResizable(false);

        jTInformacionPeliculas.setAutoCreateRowSorter(true);
        jTInformacionPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID pelicula", "Nombre", "Duracion (min)", "Descripción", "Año", "Categoria"
            }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTInformacionPeliculas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTInformacionPeliculas.setComponentPopupMenu(jPMEditarP);
        jTInformacionPeliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTInformacionPeliculas);

        jMFile.setText("Archivo");

        jMIsalir.setText("Salir");
        jMIsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIsalirActionPerformed(evt);
            }
        });
        jMFile.add(jMIsalir);

        jMBBarraPrincipal.add(jMFile);

        jMOperaciones.setText("Operaciones");

        jMIAgregarPelicula.setText("Agregar pelicula");
        jMIAgregarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAgregarPeliculaActionPerformed(evt);
            }
        });
        jMOperaciones.add(jMIAgregarPelicula);

        jMBBarraPrincipal.add(jMOperaciones);

        setJMenuBar(jMBBarraPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIsalirActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jMIsalirActionPerformed

    private void jMIAgregarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAgregarPeliculaActionPerformed
        NuevaPelicula peliNueva = new NuevaPelicula(this,true);
        peliNueva.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e){
                listarPeliculas();
            }
        });
        peliNueva.setVisible(Boolean.TRUE);
    }//GEN-LAST:event_jMIAgregarPeliculaActionPerformed

    private void jMIEditarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEditarPActionPerformed
        try{
            int filasSelect = jTInformacionPeliculas.getSelectedRowCount();
            if(filasSelect == 0){
                JOptionPane.showMessageDialog(this,"Debe seleccionar una pelicula", 
                        "Informacion", JOptionPane.OK_CANCEL_OPTION);
            }else if(filasSelect > 1){
                JOptionPane.showMessageDialog(this,"Debe seleccionar solo una pelicula"
                        + " para editar", 
                        "Informacion", JOptionPane.OK_CANCEL_OPTION);
            }else{
                peliculaSelect = new Pelicula();
                int filaSelect = jTInformacionPeliculas.getSelectedRow();
                int idPelicula = Integer.valueOf(String.valueOf(jTInformacionPeliculas.getValueAt(filaSelect, 0)));
                String nombrePelicula = String.valueOf(jTInformacionPeliculas.getValueAt(filaSelect, 1));
                int duracionP = Integer.valueOf(String.valueOf(jTInformacionPeliculas.getValueAt(filaSelect, 2).toString()));
                String descripcionP = String.valueOf(jTInformacionPeliculas.getValueAt(filaSelect, 3));
                String fechaLanzamiento = String.valueOf(jTInformacionPeliculas.getValueAt(filaSelect, 4));
                String descripcionCategP = String.valueOf(jTInformacionPeliculas.getValueAt(filaSelect, 5));
                int idCategoriaP = this.obtenerIdCategoria(descripcionCategP);

                Categoria categoriaP = new Categoria();
                categoriaP.setId(idCategoriaP);
                categoriaP.setNombre(descripcionCategP);

                Date fechaConvertida = (fechaLanzamiento == null || fechaLanzamiento.isEmpty()
                        || "null".equals(fechaLanzamiento))
                        ? null : dateUtil.convertirStringADate(fechaLanzamiento);

                peliculaSelect.setId(idPelicula);
                peliculaSelect.setNombre(nombrePelicula);
                peliculaSelect.setDuracion(duracionP);
                peliculaSelect.setDescripcion(descripcionP);
                peliculaSelect.setAño(fechaConvertida);
                peliculaSelect.setCategoria(categoriaP);

                setPeliculaSeleccionada(peliculaSelect);

                EditarPelicula editarP = new EditarPelicula(this,true);
                editarP.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e){
                        listarPeliculas();
                    }
                });
                editarP.setPeliculaSeleccionada(getPeliculaSeleccionada());
                editarP.setVisible(true);
            }
        } catch(ParseException ex){
            java.util.logging.Logger.getLogger(VistaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "La fecha de lanzamiento de la "
                    + "pelicula seleccionada es invalida, por favor contacte al administrador",
                    "Error en fecha de lanzamiento", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMIEditarPActionPerformed

    private void jMIEstadoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIEstadoPActionPerformed
        int filasSelect = jTInformacionPeliculas.getSelectedRowCount();
        if(filasSelect == 0){
            JOptionPane.showMessageDialog(this,"Debe seleccionar una pelicula", 
                    "Informacion", JOptionPane.OK_CANCEL_OPTION);
        }else if(filasSelect > 1){
            JOptionPane.showMessageDialog(this,"Debe seleccionar solo una pelicula"
                    + " para consultar el estado", 
                    "Informacion", JOptionPane.OK_CANCEL_OPTION);
        }else{
        }
    }//GEN-LAST:event_jMIEstadoPActionPerformed

    private void jMIAlquilarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAlquilarPActionPerformed
       int filasSelect = jTInformacionPeliculas.getSelectedRowCount();
        if(filasSelect == 0){
            JOptionPane.showMessageDialog(this,"Debe seleccionar una pelicula", 
                    "Informacion", JOptionPane.OK_CANCEL_OPTION);
        }else if(filasSelect > 1){
            JOptionPane.showMessageDialog(this,"Debe seleccionar solo una pelicula"
                    + " para consultar el estado", 
                    "Informacion", JOptionPane.OK_CANCEL_OPTION);
        }else{
        }
    }//GEN-LAST:event_jMIAlquilarPActionPerformed

    private void jMIDevolverPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDevolverPActionPerformed
        int filasSelect = jTInformacionPeliculas.getSelectedRowCount();
        if(filasSelect == 0){
            JOptionPane.showMessageDialog(this,"Debe seleccionar una pelicula", 
                    "Informacion", JOptionPane.OK_CANCEL_OPTION);
        }else if(filasSelect > 1){
            JOptionPane.showMessageDialog(this,"Debe seleccionar solo una pelicula"
                    + " para consultar el estado", 
                    "Informacion", JOptionPane.OK_CANCEL_OPTION);
        }else{
        }
    }//GEN-LAST:event_jMIDevolverPActionPerformed
    
    private void listarPeliculas(){
        TableModel modelo = jTInformacionPeliculas.getModel();
        try {
            int i = 0;
            List<Pelicula> peliculas = this.getOperacionesPeli().obtenerAllPeliculas();
            for (Pelicula pelicula : peliculas){
                modelo.setValueAt(pelicula.getId(), i, 0);
                modelo.setValueAt(pelicula.getNombre(), i, 1);
                modelo.setValueAt(pelicula.getDuracion(), i, 2);
                modelo.setValueAt(pelicula.getDescripcion(), i, 3);
                modelo.setValueAt(pelicula.getAño(), i, 4);
                modelo.setValueAt(pelicula.getCategoria().getNombre(), i, 5);
                i = i +1;
            }
            this.reasignarTamañoColumnaTable(jTInformacionPeliculas);
        } catch (BDException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error al consultar "
                    + "las peliculas, mensaje: " + ex.getMessage(), 
                    "Error de persistencia de datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private int obtenerIdCategoria(String categoria){
        int id = 0;
        try {
            id =  this.getOperacionesPeli().obtenerIdCategoria(categoria);
        } catch (BDException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error al consultar "
                    + "las categorias para editar la pelicula, mensaje: " + ex.getMessage(), 
                    "Error de persistencia de datos", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }
    
    private void reasignarTamañoColumnaTable(JTable tabla){
        final TableColumnModel columnaModel = tabla.getColumnModel();
        for(int columna = 0; columna < tabla.getColumnCount(); columna++){
            int anchoMin = 97;
            for(int fila = 0; fila < tabla.getRowCount(); fila++){
                TableCellRenderer render = tabla.getCellRenderer(fila, columna);
                Component comp = tabla.prepareRenderer(render, fila, columna);
                anchoMin = Math.max(comp.getPreferredSize().width + 1, anchoMin);
            }
            
            if(anchoMin > 350){
                anchoMin = 300;
            }
            columnaModel.getColumn(columna).setPreferredWidth(anchoMin);
        }
    }

    private OperacionesPeliculas getOperacionesPeli() {
        if(operacionesPeli == null){
            operacionesPeli = new OperacionesPeliculasImpl();
        }
        return operacionesPeli;
    }

    public void setOperacionesPeliculas(OperacionesPeliculas operacionesPeli) {
        this.operacionesPeli = operacionesPeli;
    }
    
    public Pelicula getPeliculaSeleccionada(){
        return peliculaSelect;
    }
    
    public void setPeliculaSeleccionada(Pelicula peliculaS){
        peliculaSelect = peliculaS;
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
            java.util.logging.Logger.getLogger(VistaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPeliculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VistaPeliculas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMBBarraPrincipal;
    private javax.swing.JMenu jMFile;
    private javax.swing.JMenuItem jMIAgregarPelicula;
    private javax.swing.JMenuItem jMIAlquilarP;
    private javax.swing.JMenuItem jMIDevolverP;
    private javax.swing.JMenuItem jMIEditarP;
    private javax.swing.JMenuItem jMIEstadoP;
    private javax.swing.JMenuItem jMIsalir;
    private javax.swing.JMenu jMOperaciones;
    private javax.swing.JPopupMenu jPMEditarP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTInformacionPeliculas;
    // End of variables declaration//GEN-END:variables
}
