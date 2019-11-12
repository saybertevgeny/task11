package ru.lanit.repository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.entity.Person;
import ru.lanit.exception.NotFoundEntityException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class PersonRepository {

    @PersistenceContext
    protected EntityManager em;

    public List<Person> getList() {
        CriteriaQuery<Person> criteriaQuery = em.getCriteriaBuilder().createQuery(Person.class);
        Root<Person> rootEntry = criteriaQuery.from(Person.class);
        criteriaQuery.select(rootEntry);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Person getById(int id) throws NotFoundEntityException {
        Person person = em.find(Person.class, id);
        if (person == null) {
            throw new NotFoundEntityException();
        }
        return person;
    }

    @Transactional
    public void save(Person person) {
        em.persist(person);
        em.flush();
    }
}
