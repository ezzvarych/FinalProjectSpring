package com.example.demo.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Password encoder stub to not use real encoder
 */
public class OwnPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}
