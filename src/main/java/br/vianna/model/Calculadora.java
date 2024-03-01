package br.vianna.model;

public class Calculadora {

    private int valor1, valor2;
    private Eoperador operador;

    public Calculadora() {
    }

    public Calculadora(int valor1, int valor2, String operador) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        setOperador(operador);
    }

    public int getValor1() {
        return valor1;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }

    public int getValor2() {
        return valor2;
    }

    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }

    public Eoperador getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        if(operador.equals("MAIS")){
            this.operador = Eoperador.MAIS;
        } else if(operador.equals("MENOS")){
            this.operador = Eoperador.MENOS;
        } else if(operador.equals("DIVISAO")){
            this.operador = Eoperador.DIVISAO;
        } else {
            this.operador = Eoperador.MULTIPLICACAO;
        }
    }

    public int operacao(){
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
