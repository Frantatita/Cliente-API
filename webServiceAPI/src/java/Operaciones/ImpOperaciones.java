/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import pojo.ResultadoOperacion;

/**
 *
 * @author reyes
 */
public class ImpOperaciones {

    
    public static ResultadoOperacion sumar (int numero1, int numero2){
        ResultadoOperacion resultado = new ResultadoOperacion();
        resultado.setError(false);
        resultado.setTipoOperacion("suma");
        resultado.setResultado(numero1+numero2);
        return resultado; 
    }

    public static ResultadoOperacion restar(int numero1, int numero2){
        ResultadoOperacion resultado = new ResultadoOperacion();
        resultado.setError(false);
        resultado.setTipoOperacion("resta");
        resultado.setResultado(numero1-numero2);
        return resultado;
    }
    
    public static ResultadoOperacion multiplicar(int numero1, int numero2){
        ResultadoOperacion resultado = new ResultadoOperacion();
        resultado.setError(false);
        resultado.setTipoOperacion("Multiplicacion");
        resultado.setResultado(numero1*numero2);
        return resultado;
    }
    
    public static ResultadoOperacion dividir(int numero1, int numero2){
        ResultadoOperacion resultado = new ResultadoOperacion();
        resultado.setError(false);
        resultado.setTipoOperacion("Division");
        resultado.setResultado(numero1/numero2);
        return resultado; 
    }

}