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
public class MetodosOrdenamiento {
    public MetodosOrdenamiento(){
        
    }
    //------------ORDENAMIENTOS INTERNOS------------------------------
    //-METODO DE ORDENAMIENTO POR EL ALGORITMO DE RADIX
    public void radix(int[] CUI){
        int x,i,j;
        for(x=Integer.SIZE-1;x>=0;x--){
            int aux[]=new int[CUI.length];
            j=0;
            for(i=0;i<CUI.length;i++){
                boolean mover=CUI[i]<< x>=0;
                if(x==0? !mover:mover){
                    aux[j]=CUI[i];
                    j++;
                }else{
                    CUI[i-j]=CUI[i];
                }
            }
            for(i=j;i<aux.length;i++){
                aux[i]=CUI[i-j];
            }
            CUI=aux;
        }
        System.out.println("Metodo de Radix:");
        mostrarResultado(CUI);
    }
    //-METODO DE ORDENAMIENTO POR EL ALGORITMO DE QUICKSORT
    public void quickSort(int[] CUI,int primero,int ultimo){
        int i,j,pivote,aux;
        i=primero;
        j=ultimo;
        pivote=CUI[(primero+ultimo)/2];
        do{
            while(CUI[i]<pivote){
                i++;
            }
            while(CUI[j]>pivote){
                j--;
            }
            if(i<=j){
                aux=CUI[i];
                CUI[i]=CUI[j];
                CUI[j]=aux;
                i++;
                j--;
            }
        }while(i<=j);
        if(primero<j){
            quickSort(CUI,primero,j);
        }
        if(i<ultimo){
            quickSort(CUI,i,ultimo);
        }
        //System.out.println("Metodo QuickSort\n");
        //mostrarResultado(CUI);
    }
    //-METODO PARA MOSTRAR EL ARREGLO ORDENADO
    public void mostrarResultado(int[] CUI){
        for(int i=0;i<CUI.length;i++){
            System.out.print(CUI[i]+" ");
        }
    }
    //--------------------ORDENAMIENTOS EXTERNOS-------------------
    //-METODO DE ORDENAMIENTO POR EL ALGORITMO DE INTERCALACION
    public void intercalacion(int[] CUI1,int[] CUI2){
        int i,j,k;
        int arreglo[] = new int[CUI1.length+CUI2.length];
        for(i=j=k=0;i<CUI1.length && j<CUI2.length;k++){
            if(CUI1[i]<CUI2[j]){
                arreglo[k]=CUI1[i];
                i++;
            }else{
                arreglo[k]=CUI2[j];
                j++;
            }
        }
        for(;i<CUI1.length;i++, k++){
            arreglo[k]=CUI1[i];
        }
        for(;j<CUI2.length;j++, k++){
            arreglo[k]=CUI2[j];
        }
        System.out.println("\nMetodo de Intercalacion");
        mostrarResultado(arreglo);
    }
    //-METODO DE ORDENAMIENTO POR EL ALGORITMO DE MEZCLA DIRECTA
    public int[] mezclaDirecta(int[] CUI){
        int i,j,k;
        if(CUI.length>1){
            int izquierdo=CUI.length/2,
                derecho=CUI.length-izquierdo,
                izquierdoCUI[]=new int[izquierdo],
                derechoCUI[]=new int[derecho];
            for(i=0;i<izquierdo;i++){
                izquierdoCUI[i]=CUI[i];
            }
            for(i=izquierdo;i<izquierdo+derecho;i++){
                derechoCUI[i-izquierdo]=CUI[i];
            }
            izquierdoCUI=mezclaDirecta(izquierdoCUI);
            derechoCUI=mezclaDirecta(derechoCUI);
            i=0;
            j=0;
            k=0;
            while(izquierdoCUI.length!=j && derechoCUI.length!=k){
                if(izquierdoCUI[j]<derechoCUI[k]){
                    CUI[i]=izquierdoCUI[j];
                    i++;
                    j++;
                }else{
                    CUI[i]=derechoCUI[k];
                    i++;
                    k++;
                }
            }
            while(izquierdoCUI.length!=j){
                CUI[i]=izquierdoCUI[j];
                i++;
                j++;
            }
            while(derechoCUI.length!=k){
                CUI[i]=derechoCUI[k];
                i++;
                k++;
            }
        }
        return CUI;
    }
    //-METODO DE ORDENAMIENTO POR MEZCLA NATURAL
    public void mezclaNatural(int CUI[]){
        System.out.println("\nMetodo de Mezcla Natural");
        int izquierda=0, izq=0, derecha=CUI.length-1, der=derecha;
        boolean ordenado=false;
        do{
            ordenado=true;
            izquierda=0;
            while(izquierda<derecha){
                izq=izquierda;
                while(izq<derecha && CUI[izq]<=CUI[izq+1]){
                    izq++;
                }
                der=izq+1;
                while(der==derecha-1 || der<derecha && CUI[der]<=CUI[der+1]){
                    der++;
                }
                if(der<=derecha){
                    mezclaDirectaAux(CUI);
                    ordenado=false;
                }
                izquierda=izq;
            }
        }while(!ordenado);
        mostrarResultado(CUI);
    }
    public void mezclaDirectaAux(int[] CUI){
        int i,j,k;
        if(CUI.length>1){
            int izquierdo=CUI.length/2,
                derecho=CUI.length-izquierdo,
                izquierdoCUI[]=new int[izquierdo],
                derechoCUI[]=new int[derecho];
            for(i=0;i<izquierdo;i++){
                izquierdoCUI[i]=CUI[i];
            }
            for(i=izquierdo;i<izquierdo+derecho;i++){
                derechoCUI[i-izquierdo]=CUI[i];
            }
            izquierdoCUI=mezclaDirecta(izquierdoCUI);
            derechoCUI=mezclaDirecta(derechoCUI);
            i=0;
            j=0;
            k=0;
            while(izquierdoCUI.length!=j && derechoCUI.length!=k){
                if(izquierdoCUI[j]<derechoCUI[k]){
                    CUI[i]=izquierdoCUI[j];
                    i++;
                    j++;
                }else{
                    CUI[i]=derechoCUI[k];
                    i++;
                    k++;
                }
            }
            while(izquierdoCUI.length!=j){
                CUI[i]=izquierdoCUI[j];
                i++;
                j++;
            }
            while(derechoCUI.length!=k){
                CUI[i]=derechoCUI[k];
                i++;
                k++;
            }
        }
    }
}
