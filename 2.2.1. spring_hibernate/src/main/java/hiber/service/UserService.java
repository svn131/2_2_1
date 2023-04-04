package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getListUsers();

    void add(Car car);

    List<Car> getListCars();

    User getOwner(String model, int series);

}
