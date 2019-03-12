package com.atm.saque;

import com.atm.enumerations.NotaEnum;

import java.util.ArrayList;

public class Saque50 extends Saque {

    @Override
    public Saque next() {
        return new Saque20();
    }

    @Override
    public NotaEnum getNota() {
        return NotaEnum.NOTA_50;
    }

}
