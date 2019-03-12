package com.atm.saque;

import com.atm.enumerations.NotaEnum;

import java.util.ArrayList;

public class Saque100 extends Saque {

    @Override
    public Saque next() {
        return new Saque50();
    }

    @Override
    public NotaEnum getNota() {
        return NotaEnum.NOTA_100;
    }

}
