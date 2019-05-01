package YELL.main.rest;

import YELL.main.domain.Account;
import YELL.main.rest.errors.BadRequestAlertException;
import YELL.main.rest.util.HeaderUtil;
import YELL.main.rest.util.PaginationUtil;
import YELL.main.service.AccountService;
import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing AccountM.
 */
@RestController
@RequestMapping("/api")
public class AccountResource {

    private final Logger log = LoggerFactory.getLogger(AccountResource.class);

    private static final String ENTITY_NAME = "accountM";

    private final AccountService accountService;

    public AccountResource(AccountService accountMService) {
        this.accountService = accountMService;
    }

    /**
     * POST  /account-ms : Create a new accountM.
     *
     * @param accountM the accountM to create
     * @return the ResponseEntity with status 201 (Created) and with body the new accountM, or with status 400 (Bad Request) if the accountM has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/account-ms")
    @Timed
    public ResponseEntity<Account> createAccountM(@RequestBody Account accountM) throws URISyntaxException {
        log.debug("REST request to save AccountM : {}", accountM);
        if (accountM.getId() != null) {
            throw new BadRequestAlertException("A new accountM cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Account result = accountService.save(accountM);
        return ResponseEntity.created(new URI("/api/account-ms/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /account-ms : Updates an existing accountM.
     *
     * @param accountM the accountM to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated accountM,
     * or with status 400 (Bad Request) if the accountM is not valid,
     * or with status 500 (Internal Server Error) if the accountM couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/account-ms")
    @Timed
    public ResponseEntity<Account> updateAccountM(@RequestBody Account accountM) throws URISyntaxException {
        log.debug("REST request to update AccountM : {}", accountM);
        if (accountM.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Account result = accountService.save(accountM);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, accountM.getId().toString()))
            .body(result);
    }

    /**
     * GET  /account-ms : get all the accountMS.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of accountMS in body
     */
    @GetMapping("/account-ms")
    @Timed
    public ResponseEntity<List<Account>> getAllAccountMS(Pageable pageable) {
        log.debug("REST request to get a page of AccountMS");
        Page<Account> page = accountService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/account-ms");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /account-ms/:id : get the "id" accountM.
     *
     * @param id the id of the accountM to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the accountM, or with status 404 (Not Found)
     */
    @GetMapping("/account-ms/{id}")
    @Timed
    public ResponseEntity<Account> getAccountM(@PathVariable Long id) {
        log.debug("REST request to get AccountM : {}", id);
        Optional<Account> accountM = accountService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accountM);
    }

    /**
     * DELETE  /account-ms/:id : delete the "id" accountM.
     *
     * @param id the id of the accountM to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/account-ms/{id}")
    @Timed
    public ResponseEntity<Void> deleteAccountM(@PathVariable Long id) {
        log.debug("REST request to delete AccountM : {}", id);
        accountService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
