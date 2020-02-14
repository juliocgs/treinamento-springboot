package br.com.cast.treinamento.exceptions;

public class BusinessException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1656758663542295732L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException() {
        super();
    }

}
