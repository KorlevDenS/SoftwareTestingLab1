package com.denis.korolev.task1;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

@Getter
@Setter
public class Sec {

    private int rowMembersNumber;
    private int accuracy;

    public Sec(int rowMembersNumber, int accuracy) {
        this.rowMembersNumber = rowMembersNumber;
        this.accuracy = accuracy;
    }

    public BigDecimal calculateSec(double degrees) {
        BigDecimal radians = degreesToRadians(degrees);
        BigDecimal sum = BigDecimal.ZERO;
        for (int row = 0; row < this.rowMembersNumber; row++) {
            BigInteger rowFactorial = calculateFactorial( 2 * row);
            BigDecimal poweredX = radians.pow(2 * row);
            BigDecimal numerator = new BigDecimal(BigInteger.valueOf(-1).pow(row)
                    .multiply(calculateEulerNumber(2 * row)))
                    .multiply(poweredX);
            sum = sum.add((numerator.setScale(this.accuracy, RoundingMode.HALF_EVEN))
                    .divide((new BigDecimal(rowFactorial).setScale(this.accuracy, RoundingMode.HALF_EVEN)), RoundingMode.HALF_EVEN));
        }
        return sum;
    }

    private static BigDecimal degreesToRadians(double degrees) {
        return BigDecimal.valueOf(degrees)
                .multiply(BigDecimal.valueOf(Math.PI).divide(BigDecimal.valueOf(180), RoundingMode.HALF_EVEN));
    }

    private BigInteger calculateFactorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /** Formula of calculating even Euler numbers was created by Ralf Stephan Feb 24 2005*/
    private BigInteger calculateEulerNumber(int index) {
        if (index % 2 != 0) {
            return BigInteger.ZERO;
        }
        int n = (index + 2) / 2;
        BigInteger[] sequence = new BigInteger[n];
        sequence[0] = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            sequence[i] = calculateA(i, sequence);
        }
        return sequence[sequence.length - 1];
    }

    private BigInteger calculateA(int n, BigInteger[] sequence) {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            sum = sum.add(sequence[i].multiply(binomialCoefficient(2 * n, 2 * i)));
        }
        return sum.negate();
    }

    private BigInteger binomialCoefficient(int n, int k) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            result = result.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
        }
        return result;
    }
}
