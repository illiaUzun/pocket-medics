package YELL.main;


import YELL.main.domain.AccountMedic;
import YELL.main.domain.Categories;
import YELL.main.repository.AccountMedicRepository;
import YELL.main.rest.AccountMedicResource;
import YELL.main.rest.errors.ExceptionTranslator;
import YELL.main.service.AccountMedicService;
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
 * Test class for the AccountMedicResource REST controller.
 *
 * @see AccountMedicResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class AccountMedicResourceIntTest {

    private static final Integer DEFAULT_EXPERIENCE = 1;
    private static final Integer UPDATED_EXPERIENCE = 2;

    private static final String DEFAULT_ADRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADRESS = "BBBBBBBBBB";

    private static final String DEFAULT_INFO = "AAAAAAAAAA";
    private static final String UPDATED_INFO = "BBBBBBBBBB";

    private static final Boolean DEFAULT_VERIFICATION = false;
    private static final Boolean UPDATED_VERIFICATION = true;

    @Autowired
    private AccountMedicRepository accountMedicRepository;



    @Autowired
    private AccountMedicService accountMedicService;

    @Qualifier("jacksonHttpMessageConverter")
    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restAccountMedicMockMvc;

    private AccountMedic accountMedic;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AccountMedicResource accountMedicResource = new AccountMedicResource(accountMedicService);
        this.restAccountMedicMockMvc = MockMvcBuilders.standaloneSetup(accountMedicResource)
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
    public static AccountMedic createEntity(EntityManager em) {
        AccountMedic accountMedic = new AccountMedic()
            .category(Categories.ALLERGOLOGY)
            .experience(DEFAULT_EXPERIENCE)
            .adress(DEFAULT_ADRESS)
            .info(DEFAULT_INFO)
            .verification(DEFAULT_VERIFICATION);
        return accountMedic;
    }

    @Before
    public void initTest() {
        accountMedic = createEntity(em);
    }

    @Test
    @Transactional
    public void createAccountMedic() throws Exception {
        int databaseSizeBeforeCreate = accountMedicRepository.findAll().size();

        // Create the AccountMedic
        restAccountMedicMockMvc.perform(post("/api/account-medics")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountMedic)))
            .andExpect(status().isCreated());

        // Validate the AccountMedic in the database
        List<AccountMedic> accountMedicList = accountMedicRepository.findAll();
        assertThat(accountMedicList).hasSize(databaseSizeBeforeCreate + 1);
        AccountMedic testAccountMedic = accountMedicList.get(accountMedicList.size() - 1);
        assertThat(testAccountMedic.getCategory()).isEqualTo(Categories.ALLERGOLOGY);
        assertThat(testAccountMedic.getExperience()).isEqualTo(DEFAULT_EXPERIENCE);
        assertThat(testAccountMedic.getAdress()).isEqualTo(DEFAULT_ADRESS);
        assertThat(testAccountMedic.getInfo()).isEqualTo(DEFAULT_INFO);
        assertThat(testAccountMedic.isVerification()).isEqualTo(DEFAULT_VERIFICATION);
    }

    @Test
    @Transactional
    public void createAccountMedicWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = accountMedicRepository.findAll().size();

        // Create the AccountMedic with an existing ID
        accountMedic.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAccountMedicMockMvc.perform(post("/api/account-medics")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountMedic)))
            .andExpect(status().isBadRequest());

        // Validate the AccountMedic in the database
        List<AccountMedic> accountMedicList = accountMedicRepository.findAll();
        assertThat(accountMedicList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllAccountMedics() throws Exception {
        // Initialize the database
        accountMedicRepository.saveAndFlush(accountMedic);

        // Get all the accountMedicList
        restAccountMedicMockMvc.perform(get("/api/account-medics?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(accountMedic.getId().intValue())))
            .andExpect(jsonPath("$.[*].catagory").value(hasItem(Categories.ALLERGOLOGY)))
            .andExpect(jsonPath("$.[*].experience").value(hasItem(DEFAULT_EXPERIENCE)))
            .andExpect(jsonPath("$.[*].adress").value(hasItem(DEFAULT_ADRESS.toString())))
            .andExpect(jsonPath("$.[*].info").value(hasItem(DEFAULT_INFO.toString())))
            .andExpect(jsonPath("$.[*].verification").value(hasItem(DEFAULT_VERIFICATION.booleanValue())));
    }


    @Test
    @Transactional
    public void getAccountMedic() throws Exception {
        // Initialize the database
        accountMedicRepository.saveAndFlush(accountMedic);

        // Get the accountMedic
        restAccountMedicMockMvc.perform(get("/api/account-medics/{id}", accountMedic.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(accountMedic.getId().intValue()))
            .andExpect(jsonPath("$.catagory").value(Categories.ALLERGOLOGY))
            .andExpect(jsonPath("$.experience").value(DEFAULT_EXPERIENCE))
            .andExpect(jsonPath("$.adress").value(DEFAULT_ADRESS.toString()))
            .andExpect(jsonPath("$.info").value(DEFAULT_INFO.toString()))
            .andExpect(jsonPath("$.verification").value(DEFAULT_VERIFICATION.booleanValue()));
    }
    @Test
    @Transactional
    public void getNonExistingAccountMedic() throws Exception {
        // Get the accountMedic
        restAccountMedicMockMvc.perform(get("/api/account-medics/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAccountMedic() throws Exception {
        // Initialize the database
        accountMedicService.save(accountMedic);

        int databaseSizeBeforeUpdate = accountMedicRepository.findAll().size();

        // Update the accountMedic
        AccountMedic updatedAccountMedic = accountMedicRepository.findById(accountMedic.getId()).get();
        // Disconnect from session so that the updates on updatedAccountMedic are not directly saved in db
        em.detach(updatedAccountMedic);
        updatedAccountMedic
            .category(Categories.ALLERGOLOGY)
            .experience(UPDATED_EXPERIENCE)
            .adress(UPDATED_ADRESS)
            .info(UPDATED_INFO)
            .verification(UPDATED_VERIFICATION);

        restAccountMedicMockMvc.perform(put("/api/account-medics")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedAccountMedic)))
            .andExpect(status().isOk());

        // Validate the AccountMedic in the database
        List<AccountMedic> accountMedicList = accountMedicRepository.findAll();
        assertThat(accountMedicList).hasSize(databaseSizeBeforeUpdate);
        AccountMedic testAccountMedic = accountMedicList.get(accountMedicList.size() - 1);
        assertThat(testAccountMedic.getCategory()).isEqualTo(Categories.ALLERGOLOGY);
        assertThat(testAccountMedic.getExperience()).isEqualTo(UPDATED_EXPERIENCE);
        assertThat(testAccountMedic.getAdress()).isEqualTo(UPDATED_ADRESS);
        assertThat(testAccountMedic.getInfo()).isEqualTo(UPDATED_INFO);
        assertThat(testAccountMedic.isVerification()).isEqualTo(UPDATED_VERIFICATION);
    }

    @Test
    @Transactional
    public void updateNonExistingAccountMedic() throws Exception {
        int databaseSizeBeforeUpdate = accountMedicRepository.findAll().size();

        // Create the AccountMedic

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restAccountMedicMockMvc.perform(put("/api/account-medics")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountMedic)))
            .andExpect(status().isBadRequest());

        // Validate the AccountMedic in the database
        List<AccountMedic> accountMedicList = accountMedicRepository.findAll();
        assertThat(accountMedicList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAccountMedic() throws Exception {
        // Initialize the database
        accountMedicService.save(accountMedic);

        int databaseSizeBeforeDelete = accountMedicRepository.findAll().size();

        // Get the accountMedic
        restAccountMedicMockMvc.perform(delete("/api/account-medics/{id}", accountMedic.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<AccountMedic> accountMedicList = accountMedicRepository.findAll();
        assertThat(accountMedicList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AccountMedic.class);
        AccountMedic accountMedic1 = new AccountMedic();
        accountMedic1.setId(1L);
        AccountMedic accountMedic2 = new AccountMedic();
        accountMedic2.setId(accountMedic1.getId());
        assertThat(accountMedic1).isEqualTo(accountMedic2);
        accountMedic2.setId(2L);
        assertThat(accountMedic1).isNotEqualTo(accountMedic2);
        accountMedic1.setId(null);
        assertThat(accountMedic1).isNotEqualTo(accountMedic2);
    }
}
