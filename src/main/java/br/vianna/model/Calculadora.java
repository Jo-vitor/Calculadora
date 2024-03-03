package br.vianna.model;

public class Calculadora {

    private double valor1, valor2;
    private Eoperador operador;

    public Calculadora() {
    }

    public Calculadora(double valor1, double valor2, String operador) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        setOperador(operador);
    }

    public double getValor1() {
        return valor1;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    public Eoperador getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        if(operador.equals("+")){
            this.operador = Eoperador.MAIS;
        } else if(operador.equals("-")){
            this.operador = Eoperador.MENOS;
        } else if(operador.equals("/")){
            this.operador = Eoperador.DIVISAO;
        } else {
            this.operador = Eoperador.MULTIPLICACAO;
        }
    }

    public double operacao(){
        if(operador == Eoperador.MAIS){
            return valor1+valor2;
        } else if(operador == Eoperador.MENOS){
            return valor1-valor2;
        } else if(operador == Eoperador.DIVISAO){
            return valor1/valor2;
        } else if(operador == Eoperador.MULTIPLICACAO){
            return valor1*valor2;
        } else {
            return 0;
        }
    }
}
