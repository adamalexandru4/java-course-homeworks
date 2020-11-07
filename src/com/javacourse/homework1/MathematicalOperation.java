package com.javacourse.homework1;

public sealed interface MathematicalOperation permits Addition, Subtraction {
    Long calculate(Long a, Long b);
}
