package com.dagurasu56.sistemabancario.negocio;

public class IdadeNaoPermitidaException extends Exception {

  public static final String MSG_IDADE_INVALIDA = "A idade do cliente precisa estar entre 18 e 65 anos.";

  public IdadeNaoPermitidaException(String msg) {
    super(msg);
  }
}
