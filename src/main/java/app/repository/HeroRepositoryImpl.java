package app.repository;

import app.domain.entities.Hero;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class HeroRepositoryImpl implements HeroRepository {

    private final EntityManager entityManager;

    @Inject
    public HeroRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Hero hero) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(hero);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<Hero> findHeroesOrderedByLevelDesc() {
        return this.entityManager.createQuery("SELECT h FROM Hero AS h ORDER BY h.level DESC ", Hero.class)
                .getResultList();
    }

    @Override
    public Hero findById(String id) {
        return this.entityManager.createQuery("SELECT h FROM Hero AS h WHERE h.id = :id", Hero.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void delete(String id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery("DELETE FROM Hero AS h WHERE h.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        this.entityManager.getTransaction().commit();
    }
}
