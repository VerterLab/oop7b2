package start.impl;

import java.util.List;

import start.Calcul;

public class ComplexCalc implements Calcul {

    private String result;
    double real_1, real_2, realRes;
    double image_1, image_2, imageRes;

    public ComplexCalc(List<Double> cmplex_1, List<Double> cmplex_2) {
        this.real_1 = cmplex_1.get(0);
        this.image_1 = cmplex_1.get(1);
        this.real_2 = cmplex_2.get(0);
        this.image_2 = cmplex_2.get(1);

    }

    @Override
    public void sum() {
        realRes = real_1 + real_2;
        imageRes = image_1 + image_2;
    }

    @Override
    public void subtraction() {
        realRes = real_1 - real_2;
        imageRes = image_1 - image_2;
    }

    @Override
    public void multiply() {
        realRes = real_1 * real_2 + (image_1 * image_2) * (-1);
        imageRes = real_1 * image_2 + real_2 * image_2;
    }

    @Override
    public void divide() {
        realRes = (real_1 * real_2 + image_1 * image_2) / (Math.pow(real_2, 2) + Math.pow(image_2, 2));
        imageRes = (real_2 * image_1 + real_1 * image_2 * (-1)) / (Math.pow(real_2, 2) + Math.pow(image_2, 2));
    }

    @Override
    public String result() {
        if (realRes == 0) {
            result = String.format("result = (%.2fi)", imageRes);
        } else if (imageRes == 0) {
            result = String.format("result = %.2f ", realRes);
        } else {
            result = String.format("result = (%.2f + %.2fi)", realRes, imageRes);
        }

        return result;
    }

    @Override
    public void clear() {
        result = null;
    }

}
