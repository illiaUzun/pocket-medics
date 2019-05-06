package YELL.main.service.impl;

import YELL.main.domain.AccountMedic;
import YELL.main.repository.AccountMedicRepository;
import YELL.main.service.AccountMedicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing AccountMedic.
 */
@Service
@Transactional
public class AccountMedicServiceImpl implements AccountMedicService {

    private final Logger log = LoggerFactory.getLogger(AccountMedicServiceImpl.class);

    private final AccountMedicRepository accountMedicRepository;

    public AccountMedicServiceImpl(AccountMedicRepository accountMedicRepository) {
        this.accountMedicRepository = accountMedicRepository;
    }

    /**
     * Save a accountMedic.
     *
     * @param accountMedic the entity to save
     * @return the persisted entity
     */
    @Override
    public AccountMedic save(AccountMedic accountMedic) {
        log.debug("Request to save AccountMedic : {}", accountMedic);        return accountMedicRepository.save(accountMedic);
    }

    /**
     * Get all the accountMedics.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<AccountMedic> findAll(Pageable pageable) {
        log.debug("Request to get all AccountMedics");
        return accountMedicRepository.findAll(pageable);
    }



    /**
     *  get all the accountMedics where Catagory is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<AccountMedic> findAllWhereCatagoryIsNull() {
        log.debug("Request to get all accountMedics where Catagory is null");
        return StreamSupport
            .stream(accountMedicRepository.findAll().spliterator(), false)
            .filter(accountMedic -> accountMedic.getCategory() == null)
            .collect(Collectors.toList());
    }


    /**
     *  get all the accountMedics where Id is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<AccountMedic> findAllWhereIdIsNull() {
        log.debug("Request to get all accountMedics where Id is null");
        return StreamSupport
            .stream(accountMedicRepository.findAll().spliterator(), false)
            .filter(accountMedic -> accountMedic.getId() == null)
            .collect(Collectors.toList());
    }

    /**
     * Get one accountMedic by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AccountMedic> findOne(Long id) {
        log.debug("Request to get AccountMedic : {}", id);
        return accountMedicRepository.findById(id);
    }

    /**
     * Delete the accountMedic by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AccountMedic : {}", id);
        accountMedicRepository.deleteById(id);
    }
}
