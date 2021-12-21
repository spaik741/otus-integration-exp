package otus.integration.exp.service;

import org.springframework.stereotype.Service;
import otus.integration.exp.entity.Car;
import otus.integration.exp.entity.Kind;
import otus.integration.exp.entity.OrderWash;

import java.util.Comparator;
import java.util.List;

@Service
public class CarWashService {

    public Car washing (OrderWash order) throws Exception {
        List<Kind> kindList = order.getKinds();
        kindList.sort(Comparator.comparingInt(Kind::getNumber));
        for (Kind kind : kindList) {
            System.out.println("Car " + order.getCar().getBrand() +
                    " " + order.getCar().getModel() +" now " + kind.getDescription());
            Thread.sleep(1000);
        }
        return order.getCar();
    }
}
