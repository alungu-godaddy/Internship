package com.example.demo;

import java.util.function.Function;

public class ToLowerCase implements Function<String, String> {
    @Override
    public String apply(String s) {
        return s.toLowerCase();
    }
}
