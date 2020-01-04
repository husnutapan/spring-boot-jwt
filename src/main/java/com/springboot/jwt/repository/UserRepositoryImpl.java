package com.springboot.jwt.repository;

import com.springboot.jwt.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    private Session session() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        CriteriaBuilder criteriaBuilder = session().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        Predicate usernamePredicate = criteriaBuilder.equal(root.get("username"), username);
        Query<User> query = session().createQuery(
                criteriaQuery.select(root).where(usernamePredicate));
        List<User> results = query.getResultList();
        return !results.isEmpty() ? Optional.ofNullable(results.get(0)) : Optional.empty();
    }
}
