package com.dagurasu56.sistemabancario.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class Ex10GerenciadoraClientesTest {

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
  }

  @After
  public void tearDown() {
    gerClientes.limpa();
  }

  @Test
  public void testPesquisaCliente() {
    var cliente = gerClientes.pesquisaCliente(idCLiente01);

    assertThat(cliente.getId(), is(idCLiente01));
  }

  @Test
  public void testPesquisaClienteInexistente() {
    var cliente = gerClientes.pesquisaCliente(1001);

    assertNull(cliente);
  }

  @Test
  public void testRemoveCliente() {
    boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);

    assertThat(clienteRemovido, is(true));
    assertThat(gerClientes.getClientesDoBanco().size(), is(1));
    assertNull(gerClientes.pesquisaCliente(idCLiente02));
  }

  @Test
  public void testRemoveClienteInexistente() {

    boolean clienteRemovido = gerClientes.removeCliente(1001);

    assertThat(clienteRemovido, is(false));
    assertThat(gerClientes.getClientesDoBanco().size(), is(2));
  }

  @Test
  @ParameterizedTest
  public void testClienteIdadeAceitavel() throws IdadeNaoPermitidaException {
    var cliente = new Cliente(idCLiente01, "João", 31, "joao@gmail.com", 1, true);

    boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

    assertTrue(idadeValida);
  }

  @Test
  public void testClienteIdadeAceitavel_02() throws IdadeNaoPermitidaException {
    var cliente = new Cliente(idCLiente01, "João", 31, "joao@gmail.com", 1, true);

    boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

    assertTrue(idadeValida);
  }

  @Test
  public void testClienteIdadeAceitavel_03() throws IdadeNaoPermitidaException {
    var cliente = new Cliente(idCLiente01, "João", 31, "joao@gmail.com", 1, true);

    boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

    assertTrue(idadeValida);
  }

  @Test
  public void testClienteIdadeAceitavel_04() {
    var cliente = new Cliente(idCLiente01, "João", 17, "joao@gmail.com", 1, true);

    try {
      gerClientes.validaIdade(cliente.getIdade());
      fail();
    } catch (Exception e) {
      assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
    }
  }

  @Test
  public void testClienteIdadeAceitavel_05() {
    var cliente = new Cliente(idCLiente01, "João", 66, "joao@gmail.com", 1, true);

    try {
      gerClientes.validaIdade(cliente.getIdade());
      fail();
    } catch (Exception e) {
      assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
    }
  }
}
