/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.ProyectoVentas.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import pe.edu.upeu.ProyectoVentas.Modelo.Categoria;
import pe.edu.upeu.ProyectoVentas.com.Conexion;

/**
 *
 * @author alum.fial7
 */
public class ProductoDAO {
    int op=0;
    Connection cx;
    Statement st;
    ResultSet rs;
    Categoria ct = new Categoria();
    private String sql;
    private int id;
    public int RegistrarProducto(int idc,String cat, double precio, int cant)
    {
         sql="INSERT INTO Producto VALUES (null,'"+cat+"','"+precio+"','"+cant+"','"+idc+"')";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            op = st.executeUpdate(sql);
            cx.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error"+ex);
        }    
        return op;
    }
    
}
