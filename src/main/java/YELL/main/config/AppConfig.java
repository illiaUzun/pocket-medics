package YELL.main.config;

//import YELL.main.Controllers.FavoritesController;
//import YELL.main.Services.FavoritesService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"YELL.main"})
public class AppConfig {
    //ControllerBeans
//    @Bean
//    public CommentController commentController() {
//        return new CommentController(commentService());
//    }
//
//    @Bean
//    public FavoritesController favoritesController() {
//        return new FavoritesController(favoritesService());
//    }
//
//    @Bean
//    public MedicsTableController medicsTableController() {
//        return new MedicsTableController(listService());
//    }
//
//    @Bean
//    public ProfilesController profilesController() {
//        return new ProfilesController(profilesService());
//    }
//
//    //ServiceBeans
//    @Bean
//    public CommentService commentService() {
//        return new CommentService();
//    }
//
//    @Bean
//    public FavoritesService favoritesService() {
//        return new FavoritesService();
//    }
//
//    @Bean
//    public ListService listService() {
//        return new ListService();
//    }
//
//    @Bean
//    public ProfilesService profilesService() {
//        return new ProfilesService();
//    }

    //RepositoriesBeans
//    @Bean
//    public AccountRepository accountRepository(){
//        return new AccountRepository();
//    }
}
