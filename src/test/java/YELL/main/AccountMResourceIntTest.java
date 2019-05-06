package YELL.main;

import YELL.main.domain.Account;
import YELL.main.repository.AccountRepository;
import YELL.main.rest.AccountResource;
import YELL.main.rest.errors.ExceptionTranslator;
import YELL.main.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static YELL.main.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the AccountMResource REST controller.
 *
 * @see AccountResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class AccountMResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SURNAME = "AAAAAAAAAA";
    private static final String UPDATED_SURNAME = "BBBBBBBBBB";

    private static final String DEFAULT_TELEPHONE = "AAAAAAAAAA";
    private static final String UPDATED_TELEPHONE = "BBBBBBBBBB";

    private static final String DEFAULT_E_MAIL = "AAAAAAAAAA";
    private static final String UPDATED_E_MAIL = "BBBBBBBBBB";

    private static final String DEFAULT_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_PASSWORD = "BBBBBBBBBB";

    private static final Integer DEFAULT_FAVOURITES = 1;
    private static final Integer UPDATED_FAVOURITES = 2;

    @Autowired
    private AccountRepository accountRepository;



    @Autowired
    private AccountService accountMService;

    @Qualifier("jacksonHttpMessageConverter")
    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAccountMMockMvc;

    private Account accountM;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AccountResource accountMResource = new AccountResource(accountMService);
        this.restAccountMMockMvc = MockMvcBuilders.standaloneSetup(accountMResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Account createEntity(EntityManager em) {
        Account accountM = new Account()
            .name(DEFAULT_NAME)
            .surname(DEFAULT_SURNAME)
            .telephone(DEFAULT_TELEPHONE)
            .eMail(DEFAULT_E_MAIL)
            .password(DEFAULT_PASSWORD);
//            .favourites(null);
        return accountM;
    }

    @Before
    public void initTest() {
        accountM = createEntity(em);
    }

    @Test
    @Transactional
    public void createAccountM() throws Exception {
        int databaseSizeBeforeCreate = accountRepository.findAll().size();

        // Create the AccountM
        restAccountMMockMvc.perform(post("/api/account-ms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountM)))
            .andExpect(status().isCreated());

        // Validate the AccountM in the database
        List<Account> accountMList = accountRepository.findAll();
        assertThat(accountMList).hasSize(databaseSizeBeforeCreate + 1);
        Account testAccountM = accountMList.get(accountMList.size() - 1);
        assertThat(testAccountM.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testAccountM.getSurname()).isEqualTo(DEFAULT_SURNAME);
        assertThat(testAccountM.getTelephone()).isEqualTo(DEFAULT_TELEPHONE);
        assertThat(testAccountM.geteMail()).isEqualTo(DEFAULT_E_MAIL);
        assertThat(testAccountM.getPassword()).isEqualTo(DEFAULT_PASSWORD);
    }

    @Test
    @Transactional
    public void createAccountMWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = accountRepository.findAll().size();

        // Create the AccountM with an existing ID
        accountM.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAccountMMockMvc.perform(post("/api/account-ms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountM)))
            .andExpect(status().isBadRequest());

        // Validate the AccountM in the database
        List<Account> accountMList = accountRepository.findAll();
        assertThat(accountMList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllAccountMS() throws Exception {
        // Initialize the database
        accountRepository.saveAndFlush(accountM);

        // Get all the accountMList
        restAccountMMockMvc.perform(get("/api/account-ms?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(accountM.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].surname").value(hasItem(DEFAULT_SURNAME.toString())))
            .andExpect(jsonPath("$.[*].telephone").value(hasItem(DEFAULT_TELEPHONE.toString())))
            .andExpect(jsonPath("$.[*].eMail").value(hasItem(DEFAULT_E_MAIL.toString())))
            .andExpect(jsonPath("$.[*].password").value(hasItem(DEFAULT_PASSWORD.toString())))
            .andExpect(jsonPath("$.[*].favourites").value(hasItem(DEFAULT_FAVOURITES)));
    }


    @Test
    @Transactional
    public void getAccountM() throws Exception {
        // Initialize the database
        accountRepository.saveAndFlush(accountM);

        // Get the accountM
        restAccountMMockMvc.perform(get("/api/account-ms/{id}", accountM.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(accountM.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.surname").value(DEFAULT_SURNAME.toString()))
            .andExpect(jsonPath("$.telephone").value(DEFAULT_TELEPHONE.toString()))
            .andExpect(jsonPath("$.eMail").value(DEFAULT_E_MAIL.toString()))
            .andExpect(jsonPath("$.password").value(DEFAULT_PASSWORD.toString()))
            .andExpect(jsonPath("$.favourites").value(DEFAULT_FAVOURITES));
    }
    @Test
    @Transactional
    public void getNonExistingAccountM() throws Exception {
        // Get the accountM
        restAccountMMockMvc.perform(get("/api/account-ms/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAccountM() throws Exception {
        // Initialize the database
        accountMService.save(accountM);

        int databaseSizeBeforeUpdate = accountRepository.findAll().size();

        // Update the accountM
        Account updatedAccountM = accountRepository.findById(accountM.getId()).get();
        // Disconnect from session so that the updates on updatedAccountM are not directly saved in db
        em.detach(updatedAccountM);
        updatedAccountM
            .name(UPDATED_NAME)
            .surname(UPDATED_SURNAME)
            .telephone(UPDATED_TELEPHONE)
            .eMail(UPDATED_E_MAIL)
            .password(UPDATED_PASSWORD);
//            .favourites(null);

        restAccountMMockMvc.perform(put("/api/account-ms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedAccountM)))
            .andExpect(status().isOk());

        // Validate the AccountM in the database
        List<Account> accountMList = accountRepository.findAll();
        assertThat(accountMList).hasSize(databaseSizeBeforeUpdate);
        Account testAccountM = accountMList.get(accountMList.size() - 1);
        assertThat(testAccountM.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testAccountM.getSurname()).isEqualTo(UPDATED_SURNAME);
        assertThat(testAccountM.getTelephone()).isEqualTo(UPDATED_TELEPHONE);
        assertThat(testAccountM.geteMail()).isEqualTo(UPDATED_E_MAIL);
        assertThat(testAccountM.getPassword()).isEqualTo(UPDATED_PASSWORD);
    }

    @Test
    @Transactional
    public void updateNonExistingAccountM() throws Exception {
        int databaseSizeBeforeUpdate = accountRepository.findAll().size();

        // Create the AccountM

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restAccountMMockMvc.perform(put("/api/account-ms")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountM)))
            .andExpect(status().isBadRequest());

        // Validate the AccountM in the database
        List<Account> accountMList = accountRepository.findAll();
        assertThat(accountMList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAccountM() throws Exception {
        // Initialize the database
        accountMService.save(accountM);

        int databaseSizeBeforeDelete = accountRepository.findAll().size();

        // Get the accountM
        restAccountMMockMvc.perform(delete("/api/account-ms/{id}", accountM.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Account> accountMList = accountRepository.findAll();
        assertThat(accountMList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Account.class);
        Account accountM1 = new Account();
        accountM1.setId(1L);
        Account accountM2 = new Account();
        accountM2.setId(accountM1.getId());
        assertThat(accountM1).isEqualTo(accountM2);
        accountM2.setId(2L);
        assertThat(accountM1).isNotEqualTo(accountM2);
        accountM1.setId(null);
        assertThat(accountM1).isNotEqualTo(accountM2);
    }
}
