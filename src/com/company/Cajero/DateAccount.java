package com.company.Cajero;

import javax.swing.*;
import java.util.ArrayList;

public class DateAccount {

    private ArrayList<Object> datosPersonales = new ArrayList<>();
    private String nombre;
    private String celular;
    private String identificacion;
    private String puntero;
    private double saldo =1000000;
    private double retiro;
    private double abono;
    private int swicth,i=0,j=1,k=2,m=3,numUse,completo;


    public void SignUpAdd(){// agregar cuenta



        do {

               identificacion = JOptionPane.showInputDialog("ingrese su identificacion");
               nombre = JOptionPane.showInputDialog("ingrese su nombre");
               celular = JOptionPane.showInputDialog("ingresa el num celular");
               this.datosPersonales.add(i, identificacion);
               this.datosPersonales.add(j, nombre);
               this.datosPersonales.add(k, celular);
               this.datosPersonales.add(m, saldo);
               i = k + 1;
               j = i + 1;
               k = j + 1;
               m = k + 1;
            swicth = Integer.parseInt(JOptionPane.showInputDialog("si desea agg otro nombre y cedula,\n ingrese <1> de lo contrario <2>"));
        } while (swicth == 1);

        System.out.println(" Los datos ingresados son " + datosPersonales.toString());

    }

    public void BuscarDato(){

        puntero = JOptionPane.showInputDialog("ingrese su numero de documento");
        numUse= Integer.parseInt(String.valueOf(this.datosPersonales.indexOf(puntero)));
        System.out.println("Identificacion: "+datosPersonales.get(numUse)+"\nNombre: "
                        + datosPersonales.get(numUse+1) +"\nCelular: "+datosPersonales.get(numUse+2));

    }// metodo auxiliar

    public void DeleteAccount(){

        puntero = JOptionPane.showInputDialog("ingrese su numero\n de cc de la cuenta a eliminar");
        numUse= Integer.parseInt(String.valueOf(this.datosPersonales.indexOf(puntero)));
        i = +numUse;
        j= +i;
        m=+j;
        datosPersonales.remove(numUse);
        datosPersonales.remove(i);
        datosPersonales.remove(j);
        datosPersonales.remove(m);



        System.out.print(getDatosPersonales());
    }

    public void RetirarDinero(){
        puntero = JOptionPane.showInputDialog("ingrese su numero de documento \n para ingresar a su cuenta");
        numUse= Integer.parseInt(String.valueOf(this.datosPersonales.indexOf(puntero)));
        completo = numUse+3;
        retiro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a retirar"));
        saldo = (double) datosPersonales.get(completo);
        if(retiro <= saldo && retiro <=300000) {
            saldo = saldo - retiro;
            System.out.println("\n_________________RETIRO________________");
            System.out.print("Usted retiro: " + retiro + "$ a su cuenta");
        }
        if(retiro > saldo || retiro > 300000){
            System.out.println("La transaccion es mayor a el saldo actual \n o al es mayor al retiro maximo permitido");
        }

        datosPersonales.set(completo,saldo);
    }

    public void DepositarDinero(){
        puntero = JOptionPane.showInputDialog("ingrese su numero de documento \n para ingresar a su cuenta");
        numUse= Integer.parseInt(String.valueOf(this.datosPersonales.indexOf(puntero)));
        completo =numUse+3;
        abono = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a depositar"));
        saldo = (double) datosPersonales.get(completo);
        if(abono <= 300000) {
            saldo = saldo + abono;
            System.out.println("\n______________DEPOSITO________________");
            System.out.print("Usted deposito: " + abono + "$ a su cuenta ");
        }
        if(abono > 300000){
            System.out.println("La transaccion es mayor\n a el deposito maximo permitido");
        }

        datosPersonales.set(completo,saldo);
    }

    public void ConsultarSaldo() {
        puntero = JOptionPane.showInputDialog("ingrese su numero de documento \n para ingresar a su cuenta");
        numUse= Integer.parseInt(String.valueOf(this.datosPersonales.indexOf(puntero)));
        System.out.println("\n________________SALDO ACTUAL_____________");
        System.out.println("Identificacion: "+datosPersonales.get(numUse)+"\nNombre: "
                + datosPersonales.get(numUse+1) +"\nCelular: "+datosPersonales.get(numUse+2)
                +"\nSaldo :"+datosPersonales.get(numUse+3));
    }




    public ArrayList<Object> getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(ArrayList<Object> datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
