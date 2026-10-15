package ra.baitap81.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {
    public double divide(double a, double b){
        if(b==0){
            throw new ArithmeticException("Không thể chia cho 0");
        }
        return a/b;
    }
}
