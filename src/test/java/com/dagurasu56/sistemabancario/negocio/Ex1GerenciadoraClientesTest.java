package com.dagurasu56.sistemabancario.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import org.junit.Test;

public class Ex1GerenciadoraClientesTest {

  @Test
  public void testPesquisaCliente() {
    var cliente01 = new Cliente(1, "João", 31, "joao@gmail.com", 1, true);
    var cliente02 = new Cliente(2, "Maria", 34, "maria@gmail.com", 2, true);

    var clientesDoBanco = new ArrayList<Cliente>();
    clientesDoBanco.add(cliente01);
    clientesDoBanco.add(cliente02);

    var gerClientes = new GerenciadoraClientes(clientesDoBanco);

    var cliente = gerClientes.pesquisaCliente(1);

    assertThat(cliente.getId(), is(1));
    assertThat(cliente.getEmail(), is("joao@gmail.com"));
  }
}
