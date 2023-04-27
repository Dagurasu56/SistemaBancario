package com.dagurasu56.sistemabancario.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GerenciadoraClientesTest_Ex8 {

  private GerenciadoraClientes gerClientes;
  private final int idCLiente01 = 1;
  private final int idCLiente02 = 2;

  @Before
  public void setUp() {
    Cliente cliente01 =
        new Cliente(idCLiente01, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
    Cliente cliente02 =
        new Cliente(idCLiente02, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);

    List<Cliente> clientesDoBanco = new ArrayList<>();
    clientesDoBanco.add(cliente01);
    clientesDoBanco.add(cliente02);

    gerClientes = new GerenciadoraClientes(clientesDoBanco);

    // a) Abriu conex�o com o BD? Ent�o...
    // b) Criou arquivos e pastas aqui? Ent�o...
    // c) Inseriu clientes fict�cios na base de dados especificamente para os testes desta classe?
    // Ent�o...
  }

  @After
  public void tearDown() {
    gerClientes.limpa();

    // a) Fecha aqui!!!
    // b) Apaga todos eles aqui!!!
    // c) Apaga eles aqui!!!
  }

  @Test
  public void testPesquisaCliente() {
    Cliente cliente = gerClientes.pesquisaCliente(idCLiente01);

    assertThat(cliente.getId(), is(idCLiente01));
  }

  @Test
  public void testRemoveCliente() {
    boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);

    assertThat(clienteRemovido, is(true));
    assertThat(gerClientes.getClientesDoBanco().size(), is(1));
    assertNull(gerClientes.pesquisaCliente(idCLiente02));
  }
}
