package units;

import org.junit.Assert;

import java.math.BigDecimal;

public class Tester {

    public static Builder test(double v, Unit unit) {
        return new Builder(v, unit);
    }

    public static class Builder {
        private BigDecimal value;
        private BigDecimal resultEsperado;
        private Unit para;
        private Unit de;

        private Builder(double v, Unit unit) {
            value = new BigDecimal(String.valueOf(v));
            de = unit;
        }

        public void isEquals(double result, Unit para_) {
            para = para_;
            resultEsperado = new BigDecimal(String.valueOf(result));
            BigDecimal res1 = de.convert(value, para);
            Assert.assertTrue(resultEsperado.compareTo(res1) == 0);
            Assert.assertEquals(0, resultEsperado.compareTo(res1));
        }
    }

}