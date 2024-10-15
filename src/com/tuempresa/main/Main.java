/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuempresa.main;

/**
 *
 * @author DELL 3520
 */
import com.tuempresa.dao.PrestamoDAO;
import com.tuempresa.model.Prestamo;

public class Main {
    public static void main(String[] args) {
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        prestamoDAO.crearBaseDeDatosYTabla();

        // Ejemplo de inserción
        Prestamo prestamo = new Prestamo(0, 1000.0, 5.0, "2024-10-15");
        prestamoDAO.insertarPrestamo(prestamo);
        
        // Consultar y mostrar préstamos
        prestamoDAO.consultarPrestamos().forEach(p -> 
            System.out.println("ID: " + p.getId() + ", Monto: " + p.getMonto() + ", Interés: " + p.getInteres() + ", Fecha: " + p.getFecha()));
    }
}



