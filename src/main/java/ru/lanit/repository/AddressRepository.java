package ru.lanit.repository;

import org.springframework.stereotype.Component;
import ru.lanit.entity.Address;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class AddressRepository {

    @PersistenceContext
    protected EntityManager em;

    @Transactional
    public void save(Address address) {
        em.persist(address);
        em.flush();
    }
}
