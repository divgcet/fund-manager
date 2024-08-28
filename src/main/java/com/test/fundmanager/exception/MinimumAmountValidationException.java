package com.test.fundmanager.exception;

import java.math.BigDecimal;

public class MinimumAmountValidationException extends RuntimeException {
    public MinimumAmountValidationException(BigDecimal minimumAmount) {
        super("Minimum "+ minimumAmount + "£ required to subscribe to this Fund");
    }
}
