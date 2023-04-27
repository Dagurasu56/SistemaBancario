package com.dagurasu56.sistemabancario.negocio;

import java.util.List;

public class GerenciadoraContas {

  private final List<ContaCorrente> contasDoBanco;

  public GerenciadoraContas(List<ContaCorrente> contasDoBanco) {
    this.contasDoBanco = contasDoBanco;
  }

  public List<ContaCorrente> getContasDoBanco() {
    return contasDoBanco;
  }

  public ContaCorrente pesquisaConta(int idConta) {

    for (ContaCorrente contaCorrente : contasDoBanco) {
      if (contaCorrente.getId() == idConta) return contaCorrente;
    }
    return null;
  }

  public void adicionaConta(ContaCorrente novaConta) {
    this.contasDoBanco.add(novaConta);
  }

  public boolean removeConta(int idConta) {

    boolean contaRemovida = false;

    for (int i = 0; i < contasDoBanco.size(); i++) {
      ContaCorrente conta = contasDoBanco.get(i);
      if (conta.getId() == idConta) {
        contasDoBanco.remove(i);
        break;
      }
    }

    return contaRemovida;
  }

  public boolean contaAtiva(int idConta) {

    boolean contaAtiva = false;

    for (ContaCorrente conta : contasDoBanco) {
      if (conta.getId() == idConta && (conta.isAtiva())) {
        contaAtiva = true;
        break;
      }
    }

    return contaAtiva;
  }

  public boolean transfereValor(int idContaOrigem, double valor, int idContaDestino) {

    boolean sucesso;

    ContaCorrente contaOrigem = pesquisaConta(idContaOrigem);
    ContaCorrente contaDestino = pesquisaConta(idContaDestino);

    //		if(contaOrigem.getSaldo() >= valor){
    contaDestino.setSaldo(contaDestino.getSaldo() + valor);
    contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
    sucesso = true;
    //		}

    return sucesso;
  }
}
