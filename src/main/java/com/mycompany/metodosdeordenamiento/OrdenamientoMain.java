/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.metodosdeordenamiento;

/**
 *
 * @author frankdev
 */
public class OrdenamientoMain {
    public static void main(String args[]){
        int CUI1[]={2,3,8,4,1,1,1,7,6,1,4,0,6};
        int CUI2[]={3,0,8,3,6,6,0,3,4,1,4,0,6};
        int CUI3[]={2,1,9,1,8,6,1,3,8,1,4,0,6};
        int CUI4[]={2,2,9,0,1,9,1,5,9,3,2};
        int A[]={1,3,5,6,22,44};
        int B[]={2,4,10,43,44,55,4576,45638};
        MetodosOrdenamiento Metodo = new MetodosOrdenamiento();
        
        //-ORDENAMIENTOS INTERNOS
        Metodo.radix(CUI1);
        System.out.println("\nMetodo de QuickSort:");
        Metodo.quickSort(CUI2, 0, CUI2.length-1);
        Metodo.mostrarResultado(CUI2);
        
        //-ORDENAMIENTOS EXTERNOS
        //-si deseas enviarle los areglos CUI1 y CUI2 debes tomar en
        //cuenta la programacion asincrona
        Metodo.intercalacion(A, B);
        System.out.println("\nMetodo de Mezcla Directa:");
        CUI3=Metodo.mezclaDirecta(CUI3);
        Metodo.mostrarResultado(CUI3);
        Metodo.mezclaNatural(CUI4);
    }
}
