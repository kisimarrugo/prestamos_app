/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuempresa.model;

/**
 *
 * @author DELL 3520
 */
public class Prestamo {
     private int id;
    private double monto;
    private double interes;
    private String fecha;

    public Prestamo(int id, double monto, double interes, String fecha) {
        this.id = id;
        this.monto = monto;
        this.interes = interes;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public double getInteres() {
        return interes;
    }

    public String getFecha() {
        return fecha;
    }

    // Otras funciones pueden ir aquí
}


