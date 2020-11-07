package com.javacourse.homework1;

record Addition() implements MathematicalOperation{
    @Override
    public Long calculate(Long a, Long b) {
        return a + b;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Addition);
    }
}
