package com.dagurasu56.sistemabancario.negocio;

public class ContaCorrente {

  private int id;

  private double saldo;

  private boolean ativa;

  public ContaCorrente(int id, double saldo, boolean ativa) {
    this.id = id;
    this.saldo = saldo;
    this.ativa = ativa;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public boolean isAtiva() {
    return ativa;
  }

  public void setAtiva(boolean ativa) {
    this.ativa = ativa;
  }

  @Override
  public String toString() {

    return "========================="
        + "Id: "
        + this.id
        + "\n"
        + "Saldo: "
        + this.saldo
        + "\n"
        + "Status: "
        + (ativa ? "Ativa" : "Inativa")
        + "\n"
        + "=========================";
  }
}
