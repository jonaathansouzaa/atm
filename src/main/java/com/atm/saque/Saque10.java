package com.atm.saque;

import com.atm.enumerations.NotaEnum;

import java.util.ArrayList;

public class Saque10 extends Saque {

    @Override
    public Integer doSaque(Integer value, ArrayList<NotaEnum> notes) {
        if (isAvailableToReduce(value)) {
            return reduceValue(value, notes);
        } else {
            return value;
        }
    }

    @Override
    public Saque next() {
        return null;
    }

    @Override
    public NotaEnum getNota() {
        return NotaEnum.NOTA_10;
    }

}
