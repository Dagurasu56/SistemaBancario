package com.dagurasu56.sistemabancario.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GerenciadoraContasTest_Ex4 {

  @Test
  public void testTransfereValor() {
    ContaCorrente conta01 = new ContaCorrente(1, 200, true);
    ContaCorrente conta02 = new ContaCorrente(2, 0, true);

    List<ContaCorrente> contasDoBanco = new ArrayList<>();
    contasDoBanco.add(conta01);
    contasDoBanco.add(conta02);

    GerenciadoraContas gerContas = new GerenciadoraContas(contasDoBanco);

    boolean sucesso = gerContas.transfereValor(1, 100, 2);

    assertTrue(sucesso);
    assertThat(conta02.getSaldo(), is(100.0));
  }
}
