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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pe.edu.upeu.ProyectoVentas.Modelo.Categoria;
import pe.edu.upeu.ProyectoVentas.com.Conexion;

/**
 *
 * @author alum.fial7
 */
public class CategoriaDAO {
    Connection cx;
    Statement st;
    ResultSet rs;
    Categoria ct = new Categoria();
    private String sql;
    private int id;
    public ArrayList<Categoria> listarCategoria(){
    ArrayList<Categoria> lista = new ArrayList();
    String sql = "SELECT *FROM Categoria";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(ct.loadCategoria(rs));            
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }    
    return lista;
    
    }
    public int devolverIdCategoria(String cat){
        sql="SELECT * from Categoria WHERE categoria ='"+cat+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            id=rs.getInt("idCategoria");            
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }    
        return id;
    }
}
