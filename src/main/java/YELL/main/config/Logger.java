package YELL.main.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class Logger {
        @Before("point_cut()")
        public void logging(JoinPoint point) {
            System.out.println("*****");
            System.out.println("Название метода: " + point.getSignature().toString());
//            System.out.println("Входные аргументы: ");
//            Arrays.asList(point.getArgs()).forEach(System.out::println);
//            System.out.println("*****");
        }
//TODO: Индивидуальные логгеры для каждого + выгрузка в файл
        @Pointcut("execution(* YELL.main.*.*.*(..))")
        public void point_cut() {
        }

    }

