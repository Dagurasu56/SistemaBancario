package com.dagurasu56.sistemabancario.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import org.junit.Test;

public class Ex2GerenciadoraClientesTest {

  private GerenciadoraClientes gerClientes;

  @Test
  public void testPesquisaCliente() {
    var cliente01 = new Cliente(1, "João", 31, "joao@gmail.com", 1, true);
    var cliente02 = new Cliente(2, "Maria", 34, "maria@gmail.com", 2, true);

    var clientesDoBanco = new ArrayList<Cliente>();
    clientesDoBanco.add(cliente01);
    clientesDoBanco.add(cliente02);

    gerClientes = new GerenciadoraClientes(clientesDoBanco);

    var cliente = gerClientes.pesquisaCliente(1);

    assertThat(cliente.getId(), is(1));
  }

  @Test
  public void testRemoveCliente() {
    var cliente01 = new Cliente(1, "João", 31, "joao@gmail.com", 1, true);
    var cliente02 = new Cliente(2, "Maria", 34, "maria@gmail.com", 2, true);

    var clientesDoBanco = new ArrayList<Cliente>();
    clientesDoBanco.add(cliente01);
    clientesDoBanco.add(cliente02);

    gerClientes = new GerenciadoraClientes(clientesDoBanco);

    boolean clienteRemovido = gerClientes.removeCliente(2);

    assertThat(clienteRemovido, is(true));
    assertThat(gerClientes.getClientesDoBanco().size(), is(1));
    assertNull(gerClientes.pesquisaCliente(2));
  }
}
