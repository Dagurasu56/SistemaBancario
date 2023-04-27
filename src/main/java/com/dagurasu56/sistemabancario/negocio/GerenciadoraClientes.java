package com.dagurasu56.sistemabancario.negocio;

import java.util.List;

public class GerenciadoraClientes {

  private final List<Cliente> clientesDoBanco;

  public GerenciadoraClientes(List<Cliente> clientesDoBanco) {
    this.clientesDoBanco = clientesDoBanco;
  }

  public List<Cliente> getClientesDoBanco() {
    return clientesDoBanco;
  }

  public Cliente pesquisaCliente(int idCliente) {

    for (Cliente cliente : clientesDoBanco) {
      if (cliente.getId() == idCliente) return cliente;
    }
    return null;
  }

  public void adicionaCliente(Cliente novoCliente) {
    clientesDoBanco.add(novoCliente);
  }

  public boolean removeCliente(int idCliente) {
    boolean clienteRemovido = false;

    for (int i = 0; i < clientesDoBanco.size(); i++) {
      Cliente cliente = clientesDoBanco.get(i);
      if (cliente.getId() == idCliente) {
        clientesDoBanco.remove(i);
        clienteRemovido = true;
        break;
      }
    }

    return clienteRemovido;
  }

  public boolean clienteAtivo(int idCliente) {
    boolean clienteAtivo = false;

    for (Cliente cliente : clientesDoBanco) {
      if (cliente.getId() == idCliente && (cliente.isAtivo())) {
        clienteAtivo = true;
        break;
      }
    }

    return clienteAtivo;
  }

  public void limpa() {
    this.clientesDoBanco.clear();
  }

  public boolean validaIdade(int idade) throws IdadeNaoPermitidaException {

    if (idade < 18 || idade > 65)
      throw new IdadeNaoPermitidaException(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA);

    return true;
  }
}
