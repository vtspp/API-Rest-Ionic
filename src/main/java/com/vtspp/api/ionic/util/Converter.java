package com.vtspp.api.ionic.util;

import com.vtspp.api.ionic.domain.ItemOrderPK;
import com.vtspp.api.ionic.domain.Order;
import com.vtspp.api.ionic.domain.Product;

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
            throw new NullPointerException(String.format("A Classe %s não possui nenhum elemento para ser utilizado.",
                                                                                     elements.getClass().getName()));
        }

        for (int i = 0; i < elements.length; i++) {

            if (elements[i].equals(elements[code])) return elements[code];
        }
        throw new IllegalArgumentException(String.format("Id %d inválida.", code));
    }

    public static ItemOrderPK toItemOrderPK (Integer value) {
        ItemOrderPK itemOrderPK = new ItemOrderPK();
        itemOrderPK.setProduct(new Product(value, null, null,null));
        itemOrderPK.setOrder(new Order(value,null, null, null, null));
        return itemOrderPK;
    }

}
