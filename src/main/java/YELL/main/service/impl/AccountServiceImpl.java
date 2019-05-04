package YELL.main.service.impl;

import YELL.main.domain.Account;
import YELL.main.repository.AccountRepository;
import YELL.main.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing AccountM.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountMRepository;

    public AccountServiceImpl(AccountRepository accountMRepository) {
        this.accountMRepository = accountMRepository;
    }

    /**
     * Save a accountM.
     *
     * @param accountM the entity to save
     * @return the persisted entity
     */
    @Override
    public Account save(Account accountM) {
        log.debug("Request to save AccountM : {}", accountM);        return accountMRepository.save(accountM);
    }

    /**
     * Get all the accountMS.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Account> findAll(Pageable pageable) {
        log.debug("Request to get all AccountMS");
        return accountMRepository.findAll(pageable);
    }


    /**
     * Get one accountM by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Account> findOne(Long id) {
        log.debug("Request to get AccountM : {}", id);
        return accountMRepository.findById(id);
    }

    /**
     * Delete the accountM by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AccountM : {}", id);
        accountMRepository.deleteById(id);
    }
}
