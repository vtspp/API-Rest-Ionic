package com.vtspp.api.ionic.util;

import static com.vtspp.api.ionic.util.Check.isNull;

public class Converter {

    /**
     * @Autor Victor Pinho
     * @since 08/03/2021
     * Dado um valor inteiro e um tipo enum, retorna o valor enumerado de acordo com a posição.
     * Caso contrário, lança uma @IllegalArgumentException.
     * Também pode lançar uma @NullPointerException caso esteja nulo o parâmetro elements
     *
     * @param elements  Valores constantes no enum
     * @param code Valor inteiro que será usado para buscar se uma determinada posição possui o valor
     * */
    public static <T> T toEnum (T [] elements , Integer code) throws IllegalArgumentException, NullPointerException{

        if (isNull(elements)) {
            throw new NullPointerException(String.format("A Classe %s Não possui nenhum elemento para ser utilizado.",
                                                                                     elements.getClass().getName()));
        }

        for (int i = 0; i < elements.length; i++) {

            if (elements[i].equals(code)) return elements[code];
        }
        throw new IllegalArgumentException(String.format("Id %d inválida.", code));
    }

}
