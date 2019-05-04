package YELL.main.service;


import YELL.main.domain.AccountMedic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing AccountMedic.
 */
public interface AccountMedicService {

    /**
     * Save a accountMedic.
     *
     * @param accountMedic the entity to save
     * @return the persisted entity
     */
    AccountMedic save(AccountMedic accountMedic);

    /**
     * Get all the accountMedics.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<AccountMedic> findAll(Pageable pageable);
    /**
     * Get all the AccountMedicDTO where Catagory is null.
     *
     * @return the list of entities
     */
    List<AccountMedic> findAllWhereCatagoryIsNull();
    /**
     * Get all the AccountMedicDTO where Id is null.
     *
     * @return the list of entities
     */
    List<AccountMedic> findAllWhereIdIsNull();


    /**
     * Get the "id" accountMedic.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<AccountMedic> findOne(Long id);

    /**
     * Delete the "id" accountMedic.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
