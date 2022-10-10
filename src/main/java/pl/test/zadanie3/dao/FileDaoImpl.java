package pl.test.zadanie3.dao;

import pl.test.zadanie3.model.WorkspaceFile;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class FileDaoImpl implements FileDao {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public FileDaoImpl() {
        factory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        entityManager = factory.createEntityManager();
    }

    @Override
    public void save(WorkspaceFile file) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(file);
        tx.commit();
    }

    @Override
    public WorkspaceFile load(String file) {
        return entityManager.find(WorkspaceFile.class, file);
    }

    @Override
    public List<WorkspaceFile> loadAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<WorkspaceFile> criteria = builder.createQuery(WorkspaceFile.class);
        criteria.from(WorkspaceFile.class);
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public List loadQuery(String query) {
        return entityManager.createNativeQuery(query, WorkspaceFile.class).getResultList();
    }

    @Override
    public void cleanUp() {
        entityManager.close();
        factory.close();
    }
}
