package YELL.main.service;

import YELL.main.domain.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing AccountM.
 */
public interface AccountService {

    /**
     * Save a accountM.
     *
     * @param accountM the entity to save
     * @return the persisted entity
     */
    Account save(Account accountM);

    /**
     * Get all the accountMS.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<Account> findAll(Pageable pageable);


    /**
     * Get the "id" accountM.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Account> findOne(Long id);

    /**
     * Delete the "id" accountM.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
