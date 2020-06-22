package com.code.challenge.shipping.excpetions;

public class OptionNotFoundException extends RuntimeException {
    public OptionNotFoundException(Long id) {
        super("Not found shipping option: " + id);
    }
}
