package YELL.main.rest;

import YELL.main.domain.AccountMedic;
import YELL.main.rest.errors.BadRequestAlertException;
import YELL.main.rest.util.HeaderUtil;
import YELL.main.rest.util.PaginationUtil;
import YELL.main.service.AccountMedicService;
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
 * REST controller for managing AccountMedic.
 */
@RestController
@RequestMapping("/api")
public class AccountMedicResource {

    private final Logger log = LoggerFactory.getLogger(AccountMedicResource.class);

    private static final String ENTITY_NAME = "accountMedic";

    private final AccountMedicService accountMedicService;

    public AccountMedicResource(AccountMedicService accountMedicService) {
        this.accountMedicService = accountMedicService;
    }

    /**
     * POST  /account-medics : Create a new accountMedic.
     *
     * @param accountMedic the accountMedic to create
     * @return the ResponseEntity with status 201 (Created) and with body the new accountMedic, or with status 400 (Bad Request) if the accountMedic has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/account-medics")
    @Timed
    public ResponseEntity<AccountMedic> createAccountMedic(@RequestBody AccountMedic accountMedic) throws URISyntaxException {
        log.debug("REST request to save AccountMedic : {}", accountMedic);
        if (accountMedic.getId() != null) {
            throw new BadRequestAlertException("A new accountMedic cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccountMedic result = accountMedicService.save(accountMedic);
        return ResponseEntity.created(new URI("/api/account-medics/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /account-medics : Updates an existing accountMedic.
     *
     * @param accountMedic the accountMedic to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated accountMedic,
     * or with status 400 (Bad Request) if the accountMedic is not valid,
     * or with status 500 (Internal Server Error) if the accountMedic couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/account-medics")
    @Timed
    public ResponseEntity<AccountMedic> updateAccountMedic(@RequestBody AccountMedic accountMedic) throws URISyntaxException {
        log.debug("REST request to update AccountMedic : {}", accountMedic);
        if (accountMedic.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccountMedic result = accountMedicService.save(accountMedic);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, accountMedic.getId().toString()))
            .body(result);
    }

    /**
     * GET  /account-medics : get all the accountMedics.
     *
     * @param pageable the pagination information
     * @param filter the filter of the request
     * @return the ResponseEntity with status 200 (OK) and the list of accountMedics in body
     */
    @GetMapping("/account-medics")
    @Timed
    public ResponseEntity<List<AccountMedic>> getAllAccountMedics(Pageable pageable, @RequestParam(required = false) String filter) {
        if ("catagory-is-null".equals(filter)) {
            log.debug("REST request to get all AccountMedics where catagory is null");
            return new ResponseEntity<>(accountMedicService.findAllWhereCatagoryIsNull(),
                    HttpStatus.OK);
        }
        if ("id-is-null".equals(filter)) {
            log.debug("REST request to get all AccountMedics where id is null");
            return new ResponseEntity<>(accountMedicService.findAllWhereIdIsNull(),
                    HttpStatus.OK);
        }
        log.debug("REST request to get a page of AccountMedics");
        Page<AccountMedic> page = accountMedicService.findAll(Pageable.unpaged());
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/account-medics");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /account-medics/:id : get the "id" accountMedic.
     *
     * @param id the id of the accountMedic to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the accountMedic, or with status 404 (Not Found)
     */
    @GetMapping("/account-medics/{id}")
    @Timed
    public ResponseEntity<AccountMedic> getAccountMedic(@PathVariable Long id) {
        log.debug("REST request to get AccountMedic : {}", id);
        Optional<AccountMedic> accountMedic = accountMedicService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accountMedic);
    }

    /**
     * DELETE  /account-medics/:id : delete the "id" accountMedic.
     *
     * @param id the id of the accountMedic to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/account-medics/{id}")
    @Timed
    public ResponseEntity<Void> deleteAccountMedic(@PathVariable Long id) {
        log.debug("REST request to delete AccountMedic : {}", id);
        accountMedicService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
