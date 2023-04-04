package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    private SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override

    public List<User> getListUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }


    public User getOwner(String model1, int series1) {
        TypedQuery<User> zapros = sessionFactory.getCurrentSession().createQuery(
                "select car.user from Car car where car.model = :model and car.series = :series", User.class);
        zapros.setParameter("model", model1);
        zapros.setParameter("series", series1);
        return zapros.getSingleResult();
    }


}
