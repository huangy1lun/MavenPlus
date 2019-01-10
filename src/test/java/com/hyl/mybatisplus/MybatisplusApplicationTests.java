package com.hyl.mybatisplus;

import com.hyl.mybatisplus.common.mp.SuperGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MybatisplusApplicationTests {

    @Test
    public void contextLoads() throws FileNotFoundException {
        String file = Objects.requireNonNull(SuperGenerator.class.getClassLoader().getResource("")).getFile();
        System.out.println(new File(file).getParentFile().getParent());

        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()) path = new File("");
        System.out.println("path:"+path.getAbsolutePath());

    }

}

