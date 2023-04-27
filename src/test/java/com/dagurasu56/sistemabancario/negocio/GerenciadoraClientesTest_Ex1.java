package com.dagurasu56.sistemabancario.negocio;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

public class GerenciadoraClientesTest_Ex1 {

  @Test
  public void testPesquisaCliente() {
    Cliente cliente01 = new Cliente(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
    Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);

    List<Cliente> clientesDoBanco = new ArrayList<>();
    clientesDoBanco.add(cliente01);
    clientesDoBanco.add(cliente02);

    GerenciadoraClientes gerClientes = new GerenciadoraClientes(clientesDoBanco);

    Cliente cliente = gerClientes.pesquisaCliente(1);

    assertThat(cliente.getId(), is(1));
    assertThat(cliente.getEmail(), is("gugafarias@gmail.com"));
  }
}
