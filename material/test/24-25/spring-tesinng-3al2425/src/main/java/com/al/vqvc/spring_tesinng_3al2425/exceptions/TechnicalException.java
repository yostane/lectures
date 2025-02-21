package com.al.vqvc.spring_tesinng_3al2425.exceptions;

public class TechnicalException extends Exception {
  private TechnicalExceptionType type;

  public TechnicalExceptionType getType() {
    return type;
  }

  public TechnicalException(TechnicalExceptionType type, String message) {
    super(message);
    this.type = type;
  }
}
