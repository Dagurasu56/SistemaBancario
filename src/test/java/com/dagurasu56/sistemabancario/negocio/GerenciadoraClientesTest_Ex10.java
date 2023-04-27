package com.dagurasu56.sistemabancario.negocio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

public class GerenciadoraClientesTest_Ex10 {

  private GerenciadoraClientes gerClientes;
  private int idCLiente01 = 1;
  private int idCLiente02 = 2;

  @Before
  public void setUp() {
    Cliente cliente01 = new Cliente(idCLiente01, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
    Cliente cliente02 = new Cliente(idCLiente02, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);

    List<Cliente> clientesDoBanco = new ArrayList<>();
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
    Cliente cliente = gerClientes.pesquisaCliente(idCLiente01);

    assertThat(cliente.getId(), is(idCLiente01));
  }

  @Test
  public void testPesquisaClienteInexistente() {

    Cliente cliente = gerClientes.pesquisaCliente(1001);

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
  public void testClienteIdadeAceitavel() throws IdadeNaoPermitidaException {

    Cliente cliente = new Cliente(1, "Gustavo", 25, "guga@gmail.com", 1, true);

    boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

    assertTrue(idadeValida);
  }

  @Test
  public void testClienteIdadeAceitavel_02() throws IdadeNaoPermitidaException {

    Cliente cliente = new Cliente(1, "Gustavo", 18, "guga@gmail.com", 1, true);

    boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

    assertTrue(idadeValida);
  }

  @Test
  public void testClienteIdadeAceitavel_03() throws IdadeNaoPermitidaException {

    Cliente cliente = new Cliente(1, "Gustavo", 65, "guga@gmail.com", 1, true);

    boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

    assertTrue(idadeValida);
  }

  @Test
  public void testClienteIdadeAceitavel_04() throws IdadeNaoPermitidaException {

    /* ========== Montagem do Cen�rio ========== */
    Cliente cliente = new Cliente(1, "Gustavo", 17, "guga@gmail.com", 1, true);

    /* ========== Execu��o ========== */
    try {
      gerClientes.validaIdade(cliente.getIdade());
      fail();
    } catch (Exception e) {
      /* ========== Verifica��es ========== */
      assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
    }
  }

  @Test
  public void testClienteIdadeAceitavel_05() throws IdadeNaoPermitidaException {

    Cliente cliente = new Cliente(1, "Gustavo", 66, "guga@gmail.com", 1, true);
    try {
      gerClientes.validaIdade(cliente.getIdade());
      fail();
    } catch (Exception e) {
      assertThat(e.getMessage(), is(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
    }
  }
}
