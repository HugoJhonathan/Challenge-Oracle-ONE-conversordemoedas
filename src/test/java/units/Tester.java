package units;

import application.Conversor;
import application.Result;
import org.junit.Assert;

public class Tester {

    public static Builder test(double v, Unit unit) {
        return new Builder(v, unit);
    }

    public static class Builder {
        private double value;
        private double resultEsperado;
        private Unit para;
        private Unit de;

        private Builder(double v, Unit unit) {
            value = v;
            de = unit;
        }

        public void isEquals(double result, Unit para_) {
            para = para_;
            resultEsperado = result;
            Result res1 = Conversor.convert(value, de, para);
            Assert.assertEquals(resultEsperado, res1.getResult(), 0.0);
        }
    }

}