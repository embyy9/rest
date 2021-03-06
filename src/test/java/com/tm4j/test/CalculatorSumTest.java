package com.tm4j.test;

import org.junit.Assert;
import org.junit.Test;

import com.adaptavist.tm4j.junit.annotation.TestCase;
import com.tm4j.main.Calculator;

public class CalculatorSumTest {
    
    @Test
    @TestCase(key = "Q1-T1")
    public void sumTwoNumbersAndPass() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(5, calculator.sum(3, 2));
    }
 
 
    @Test
    @TestCase(name = "calculate 1 + 3")
    public void notMappedToTestCaseAndPass() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(4, calculator.sum(1, 3));
    }
    
    @Test
    @TestCase(name = "An unnamed Test Case")
    public void unnamedTestCase() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(11, calculator.sum(1, 10));
    }
 
    @Test
    @TestCase(name = "Mapped to a Test Case Name and Pass")
    public void mappedToATestCaseNameAndPass() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(4, calculator.sum(2, 2));
    }
 
}