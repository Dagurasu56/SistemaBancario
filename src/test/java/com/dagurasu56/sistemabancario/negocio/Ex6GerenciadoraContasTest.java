package com.dagurasu56.sistemabancario.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;

public class Ex6GerenciadoraContasTest {

  private GerenciadoraContas gerContas;

  @Test
  public void testTransfereValor() {
    int idConta01 = 1;
    int idConta02 = 2;
    var conta01 = new ContaCorrente(idConta01, 200, true);
    var conta02 = new ContaCorrente(idConta02, 0, true);

    var contasDoBanco = new ArrayList<ContaCorrente>();
    contasDoBanco.add(conta01);
    contasDoBanco.add(conta02);

    gerContas = new GerenciadoraContas(contasDoBanco);

    boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);

    assertTrue(sucesso);
    assertThat(conta02.getSaldo(), is(100.0));
    assertThat(conta01.getSaldo(), is(100.0));
  }

  @Test
  public void testTransfereValor_SaldoInsuficiente() {
    int idConta01 = 1;
    int idConta02 = 2;
    var conta01 = new ContaCorrente(idConta01, 100, true);
    var conta02 = new ContaCorrente(idConta02, 0, true);

    var contasDoBanco = new ArrayList<ContaCorrente>();
    contasDoBanco.add(conta01);
    contasDoBanco.add(conta02);

    gerContas = new GerenciadoraContas(contasDoBanco);

    boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);

    assertTrue(sucesso);
    assertThat(conta01.getSaldo(), is(-100.0));
    assertThat(conta02.getSaldo(), is(200.0));
  }
}
