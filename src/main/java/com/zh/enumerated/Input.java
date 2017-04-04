package com.zh.enumerated;

import java.util.Random;

/**
 * 枚举实现状态机
 * Created by zh on 2017-03-19.
 */
public enum  Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    int value;
    Input(int value) {
        this.value = value;
    }
    Input() {}
    int amount() {
        return value;
    }
    static Random random = new Random(47);
    public static Input randomSelection() {
        //Don't include STOP
        return values()[random.nextInt(values().length - 1)];
    }
}