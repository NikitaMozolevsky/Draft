package by.mozolevskij.pharmacy.example.spring;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class LifeCycle {

    /**
     *
     *
     *
     * */

    /**1**/
    @Configuration
    @PropertySource("classpath:database.properties")
    public class DevConfig {

        @Bean
        public static PropertySourcesPlaceholderConfigurer configurer() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }

    @Value("${url}")
    private String url;


    /**2**/
    /**Имеет 3 метода*
     * Генерирует рандомные Prototype бины
     */
    public class ColorFactory implements FactoryBean<Color> {
        @Override /**Получение бина рандомного цвета*/
        public Color getObject() throws Exception {
            Random random = new Random();
            Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            return color;
        }

        @Override
        public Class<?> getObjectType() {
            return Color.class;
        }

        @Override
        public boolean isSingleton() {
            return false;
        }
    }

    /**3**/
    public interface BeanPostProcessor {
        //Before
        Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

        //After
        Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
    }
    /**4**/
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface InjectRandomInt {
        int min() default 0;
        int max() default 10;
    }

    /*@Component*/
    public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

        private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(InjectRandomIntBeanPostProcessor.class);

        /**5**/
        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

            LOGGER.info("postProcessBeforeInitialization::beanName = {}, beanClass = {}", beanName, bean.getClass().getSimpleName());

            Field[] fields = bean.getClass().getDeclaredFields();

            for (Field field : fields) {
                if (field.isAnnotationPresent(InjectRandomInt.class)) {
                    field.setAccessible(true);
                    InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                    ReflectionUtils.setField(field, bean, getRandomIntInRange(annotation.min(), annotation.max()));
                }
            }

            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            return bean;
        }
        /**6**/
        private int getRandomIntInRange(int min, int max) {
            return min + (int)(Math.random() * ((max - min) + 1));
        }
    }

    /**7**/
    /*@Component*/
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public class MyBean {

        @InjectRandomInt
        private int value1;

        @InjectRandomInt(min = 100, max = 200)
        private int value2;

        private int value3;

        @Override
        public String toString() {
            return "MyBean{" +
                    "value1=" + value1 +
                    ", value2=" + value2 +
                    ", value3=" + value3 +
                    '}';
        }
    }

    /**8**/
    /*@Component*/
    public class Application {

        private static final Logger logger = (Logger) LoggerFactory.getLogger(Application.class);

        @Autowired
        private DateTimeService dateTimeService;

        public static void main(String[] args) {

            //обработка пакета
            var ctx = new AnnotationConfigApplicationContext();
            ctx.scan("com.zetcode");
            ctx.refresh();

            //обработка класса
            var ctx1 = new AnnotationConfigApplicationContext(Application.class);

            var bean = ctx.getBean(Application.class);
            bean.run();

            ctx.close();
        }

        public void run() {

            logger.info("Current time: {}", dateTimeService.getTime());
            logger.info("Current date: {}", dateTimeService.getDate());
            logger.info("Current datetime: {}", dateTimeService.getDateTime());
        }

        @Service
        public class DateTimeService {

            public LocalDate getDate() {

                return LocalDate.now();
            }

            public LocalTime getTime() {

                return LocalTime.now();
            }

            public LocalDateTime getDateTime() {

                return LocalDateTime.now();
            }
        }
    }

}
