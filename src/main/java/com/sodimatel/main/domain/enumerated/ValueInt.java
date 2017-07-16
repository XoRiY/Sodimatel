package com.sodimatel.main.domain.enumerated;
public enum ValueInt {
    MIN(0), UN(1), DIX(10), VINT(20), TRENTE(30), QUARANTE(40), CINQUENTE(50), SOIXANTE(60), CENT(100), CENT_CINQUANTE(150), DEUX_CENT(200), MAX(250);

    private int id;
    ValueInt(int id) { this.id = id; }
    public int getValue() { return id; }
}
