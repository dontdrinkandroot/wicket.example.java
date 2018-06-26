package net.dontdrinkandroot.example.ddrstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class Application
{
    public static void main(String args[])
    {
        SpringApplication.run(Application.class, args);
    }
}
