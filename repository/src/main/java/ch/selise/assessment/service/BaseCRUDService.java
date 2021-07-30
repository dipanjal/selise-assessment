package ch.selise.assessment.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author dipanjal
 * @since 0.0.1
 */
public abstract class BaseCRUDService<ENTITY, REPO extends JpaRepository<ENTITY, Long>> {

    protected REPO repository;

    public BaseCRUDService(REPO repository){
        this.repository = repository;
    }

    public ENTITY save(ENTITY entity) {
        return repository.save(entity);
    }

    public List<ENTITY> findAll() {
        return repository.findAll();
    }

}
