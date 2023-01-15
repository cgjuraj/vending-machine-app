package com.techelevator;

import com.techelevator.models.Money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class QuarterChangeTest {

    @Before
    public void setup() {
        Money change = new Money();
    }

    @Test
    public void test1() {
        Money change = new Money();
        BigDecimal output = new BigDecimal(0.75);
        BigDecimal actualOutput = new BigDecimal(change.changeGiven(output));
        Assert.assertEquals(new BigDecimal("0.00"), actualOutput.toString());
    }
}
