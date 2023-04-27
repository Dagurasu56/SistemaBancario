package com.dagurasu56.sistemabancario.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Ex8GerenciadoraClientesTest {

  private GerenciadoraClientes gerClientes;
  private final int idCLiente01 = 1;
  private final int idCLiente02 = 2;

  @Before
  public void setUp() {
    var cliente01 = new Cliente(idCLiente01, "João", 31, "joao@gmail.com", 1, true);
    var cliente02 = new Cliente(idCLiente02, "Maria", 34, "maria@gmail.com", 2, true);

    var clientesDoBanco = new ArrayList<Cliente>();
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
    var cliente = gerClientes.pesquisaCliente(idCLiente01);

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
