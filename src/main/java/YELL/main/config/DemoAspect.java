package YELL.main.config;

import YELL.main.Entities.Medic;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
@ComponentScan(basePackages = {"YELL.main"})
public class DemoAspect {

    @Before("point_cut() && args(medic)")
    public void addUser(JoinPoint point, Medic medic) {
        FileManager fileWritingLogs = new FileManager("Logs.txt");
        fileWritingLogs.addToFile("The next user added:" +
                "\nName: " + medic.getFirstName() +
                "\nLast Name: " + medic.getLastName() +
                "\nAddress:" + medic.getAddress() +
                "\nCategory:" + medic.getCategory() +
                "\n:Years of Experience " + medic.getYearsOfExperience());
    }

    //Нужен для определения среза точек
    @Pointcut("execution(* YELL.main.Controllers.MedicsTableController.addUser(..))")
    public void point_cut(){
    }

}
