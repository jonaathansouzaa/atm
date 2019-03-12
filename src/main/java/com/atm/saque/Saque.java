package com.atm.saque;

import com.atm.enumerations.NotaEnum;

import java.util.ArrayList;

public abstract class Saque {

    public abstract Saque next();

    public abstract NotaEnum getNota();

    public Integer doSaque(Integer valor, ArrayList<com.atm.enumerations.NotaEnum> notas) {
        if (isAvailableToReduce(valor)) {
            return reduceValue(valor, notas);
        } else {
            return next().doSaque(valor, notas);
        }
    }

    protected boolean isAvailableToReduce(Integer valor) {
        return (valor - getNota().getValor()) >= 0;
    }

    protected Integer reduceValue(Integer valor, ArrayList<NotaEnum> notas) {
        valor -= getNota().getValor();
        notas.add(getNota());
        return valor;
    }


}
