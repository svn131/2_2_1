package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getListUsers();

    void add(Car car);

    List<Car> getListCars();

    User getOwner(String model, int series);

}

