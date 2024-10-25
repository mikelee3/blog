package com.example.blog;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.junit.jupiter.api.Assertions;
import jakarta.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class EntityTestUtils {
    /**
     * Asserts that the proxy and unwrapped entity behave correctly in terms of equals() and hashCode().
     *
     * @param <T>           the type of the entity
     * @param entityClass   the entity class
     * @param id            An existing entity ID
     * @param entityManager the EntityManager used to fetch the entity
     */
    public static <T, ID> void assertEntityProxyBehaviorForSets(Class<T> entityClass, ID id, EntityManager entityManager) {
        // Fetch a proxy instance
        T proxyEntity = entityManager.getReference(entityClass, id);

        // Unwrap the proxy entity
        T unproxiedEntity = (T) Hibernate.unproxy(proxyEntity);

        // Assert that proxyEntity is still a proxy
        Assertions.assertInstanceOf(HibernateProxy.class, proxyEntity);

        // Assert that unproxiedEntity is not a proxy
        Assertions.assertFalse(unproxiedEntity instanceof HibernateProxy);

        // Test that equals() and hashCode() behave as expected
        Set<T> entities = new HashSet<>();
        entities.add(proxyEntity);
        entities.add(unproxiedEntity);

        // If equals() and hashCode() are properly implemented, the set should have only one element
        Assertions.assertEquals(1, entities.size());
    }
}
