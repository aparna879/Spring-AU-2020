package com.springau.springassAOP;

import me.xethh.utils.dateManipulation.BaseTimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone;
import java.io.File;

/**
 * Application spring
 *
 */

@SpringBootApplication
public class AppSpring
{
    public static void systemInit(){
        File file = new File("./target/test-app/logs/");
        file.mkdirs();
        System.setProperty("base.log.path",file.toString());
    }
    public static void main(String[] args )
    {
        systemInit();
        TimeZone.setDefault(BaseTimeZone.Hongkong.timeZone());
        SpringApplication.run(AppSpring.class, args);
    }
}
