package com.dagurasu56.sistemabancario.negocio;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GerenciadoraContasTest_Ex3 {

  @Test
  public void testTransfereValor() {

    ContaCorrente conta01 = new ContaCorrente(1, 200, true);
    ContaCorrente conta02 = new ContaCorrente(2, 0, true);

    List<ContaCorrente> contasDoBanco = new ArrayList<>();
    contasDoBanco.add(conta01);
    contasDoBanco.add(conta02);

    GerenciadoraContas gerContas = new GerenciadoraContas(contasDoBanco);

    gerContas.transfereValor(1, 100, 2);

    assertThat(conta02.getSaldo(), is(100.0));
    assertThat(conta01.getSaldo(), is(100.0));
  }
}
