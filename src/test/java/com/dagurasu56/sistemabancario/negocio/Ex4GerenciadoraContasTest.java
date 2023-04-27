package com.dagurasu56.sistemabancario.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.Test;

public class Ex4GerenciadoraContasTest {

  @Test
  public void testTransfereValor() {
    var conta01 = new ContaCorrente(1, 200, true);
    var conta02 = new ContaCorrente(2, 0, true);

    var contasDoBanco = new ArrayList<ContaCorrente>();
    contasDoBanco.add(conta01);
    contasDoBanco.add(conta02);

    var gerContas = new GerenciadoraContas(contasDoBanco);

    boolean sucesso = gerContas.transfereValor(1, 100, 2);

    assertTrue(sucesso);
    assertThat(conta02.getSaldo(), is(100.0));
  }
}
