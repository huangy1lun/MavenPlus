package com.hyl.mybatisplus.common.mp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * TODO
 *
 * @author huangYl
 * @date 2019/1/9 下午3:45
 **/
public class Generator {

    public static void main(String[] args) {

        // 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false) // 是否支持AR模式
              .setAuthor("huangYl") // 作者
              .setOutputDir("/Users/huangy1lun/Public/javaCode/java_project/mybatisplus/src/main/java") // 生成路径
              .setFileOverride(true)  // 文件覆盖
              .setIdType(IdType.AUTO) // 主键策略
              .setBaseResultMap(true)
              .setBaseColumnList(true)
              .setOpen(false)
              .setSwagger2(true);
        // .setEntityName("%sEntity");
        // .setMapperName("%sDao")
        // .setXmlName("%sDao")
        // .setServiceName("MP%sService")
        // .setServiceImplName("%sServiceDiy")
        // .setControllerName("%sAction")
        //setEnableCache(false)// XML 二级缓存

        // 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://localhost:3306/jpa?characterEncoding=utf8")
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("meizhu");

        // 包配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent("com.hyl.mp")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");


        // 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setSuperEntityColumns("id")
                .setControllerMappingHyphenStyle(true)
                .setTablePrefix("t_")
                .setInclude("t_car");
        // Boolean类型字段是否移除is前缀处理
        // .setEntityBooleanColumnRemoveIsPrefix(true)
        // .setRestControllerStyle(true)
        // .setControllerMappingHyphenStyle(true)

//        stConfig.setCapitalMode(true) //全局大写命名
//                .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
//                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
//                .setTablePrefix("tbl_")
//                .setInclude("tbl_employee");  // 生成的表


        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();

        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6. 执行
        ag.execute();
    }
}
