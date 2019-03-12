package com.atm.saque;

import com.atm.enumerations.NotaEnum;

import java.util.ArrayList;

public class Saque20 extends Saque {

    @Override
    public Saque next() {
        return new Saque10();
    }

    @Override
    public NotaEnum getNota() {
        return NotaEnum.NOTA_20;
    }

}
