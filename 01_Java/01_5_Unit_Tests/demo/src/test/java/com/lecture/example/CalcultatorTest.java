package com.lecture.example;

import org.junit.Assert;
import org.junit.Test;

public class CalcultatorTest {

    @Test
    public void testSquareFunction() {
        Assert.assertEquals(4, Calculator.square(2));
    }

}
