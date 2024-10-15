/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuempresa.dao;

/**
 *
 * @author DELL 3520
 */
import com.tuempresa.model.Prestamo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {
    private Connection connection;

    public PrestamoDAO() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prestamos_db", "root", "mi_contraseña");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearBaseDeDatosYTabla() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "mi_contraseña");
             Statement stmt = connection.createStatement()) {
            
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS prestamos_db");
            stmt.executeUpdate("USE prestamos_db");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS prestamos ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "monto DOUBLE NOT NULL, "
                    + "interes DOUBLE NOT NULL, "
                    + "fecha VARCHAR(10) NOT NULL)");

            System.out.println("Base de datos y tabla creadas con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO prestamos (monto, interes, fecha) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, prestamo.getMonto());
            stmt.setDouble(2, prestamo.getInteres());
            stmt.setString(3, prestamo.getFecha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Prestamo> consultarPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM prestamos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Prestamo prestamo = new Prestamo(rs.getInt("id"), rs.getDouble("monto"), rs.getDouble("interes"), rs.getString("fecha"));
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamos;
    }
}


