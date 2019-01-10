package com.hyl.mybatisplus.common.mp;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器父类
 * 使用时修改TODO注释的地方为自己的需求即可
 *
 * @author huangYl
 */
public class SuperGenerator {

    /**
     * 全局配置
     */
    protected GlobalConfig getGlobalConfig() {
        return new GlobalConfig()
                // 输出目录
                .setOutputDir(getJavaPath())
                // 是否覆盖文件
                .setFileOverride(true)
                // 开启 activeRecord 模式
                .setActiveRecord(false)
                // XML 二级缓存
                .setEnableCache(false)
                // 生成XML 通用查询映射结果
                .setBaseResultMap(true)
                // 生成XML 通用查询结果列
                .setBaseColumnList(true)
                // 是否生成 kotlin 代码
                .setKotlin(false)
                // 是否生成成功后打开文件目录
                .setOpen(false)
                // 主键策略
                .setIdType(IdType.AUTO)
                // 是否开启swagger注解
                .setSwagger2(true)
                // TODO 修改自己的名字
                // 作者
                .setAuthor("huangYl")
                //自定义文件命名，注意 %s 会自动填充表实体属性！
                .setEntityName("%s")
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("I%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController");
    }

    /**
     * 包配置
     */
    protected PackageConfig getPackageConfig() {
        // TODO 修改输出包路径
        return new PackageConfig()
                // 父包名
                .setParent("com.hyl.mybatisplus")
                .setController("controller")
                .setEntity("entity")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl");
//                .setXml("mapper");
    }

    /**
     * 数据源配置
     */
    protected DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig()
                // 数据库类型
                .setDbType(DbType.MYSQL)
                .setTypeConvert(new MySqlTypeConvert() {
                    @Override
                    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                        final String bitType = "bit";
                        final String tinyintType = "tinyint";
                        final String dateType = "date";
                        final String timeType = "time";
                        final String datetimeType = "datetime";
                        // 数据库表和实体类的类型转换
                        if (bitType.equals(fieldType.toLowerCase())) {
                            return DbColumnType.BOOLEAN;
                        }
                        if (tinyintType.equals(fieldType.toLowerCase())) {
                            return DbColumnType.BOOLEAN;
                        }
                        if (dateType.equals(fieldType.toLowerCase())) {
                            return DbColumnType.DATE;
                        }
                        if (timeType.equals(fieldType.toLowerCase())) {
                            return DbColumnType.DATE;
                        }
                        if (datetimeType.equals(fieldType.toLowerCase())) {
                            return DbColumnType.DATE;
                        }
                        return super.processTypeConvert(globalConfig, fieldType);
                    }
                })
                // TODO 修改数据库连接
                .setDriverName("com.mysql.jdbc.Driver")
                .setUsername("root")
                .setPassword("meizhu")
                .setUrl("jdbc:mysql://127.0.0.1:3306/jpa?characterEncoding=utf8");
    }

    /**
     * 策略配置
     *
     * @param tablePrefix 数据库表前序
     * @param tableName   数据库表名
     * @return
     */
    protected StrategyConfig getStrategyConfig(String tablePrefix, String tableName) {
        List<TableFill> tableFillList = getTableFills();
        return new StrategyConfig()
                // 全局大写命名
                .setCapitalMode(true)
                // 设置数据库表前缀
                .setTablePrefix(tablePrefix)
                // 表名生成策略
                .setNaming(NamingStrategy.underline_to_camel)
                // 【实体】是否为lombok模型（默认 false
                .setEntityLombokModel(true)
                // 设计表名
                .setInclude(tableName)
                // 是否生成restController
                .setRestControllerStyle(true);
                // 需要生成的表
//                .setInclude(new String[]{"user"})
                // 自定义实体父类
//                .setSuperEntityClass("org.crown.framework.model.BaseModel")
                // 自定义实体，公共字段
//                .setSuperEntityColumns("id")
//                .setTableFillList(tableFillList)
                // 自定义 mapper 父类
//                .setSuperMapperClass("org.crown.framework.mapper.BaseMapper")
                // 自定义 controller 父类
//                .setSuperControllerClass("org.crown.framework.controller.SuperController")
                // 自定义 service 实现类父类
//                .setSuperServiceImplClass("org.crown.framework.service.impl.BaseServiceImpl")
                // 自定义 service 接口父类
//                .setSuperServiceClass("org.crown.framework.service.BaseService")
                //【实体】是否生成字段常量（默认 false）
//                .setEntityColumnConstant(false)
                //【实体】是否为构建者模型（默认 false）
//                .setEntityBuilderModel(false)
                // Boolean类型字段是否移除is前缀处理
//                .setEntityBooleanColumnRemoveIsPrefix(true)


    }


    /**
     * 获取TemplateConfig 自定义配置
     */
    protected TemplateConfig getTemplateConfig() {
        return new TemplateConfig().setXml(null);
    }

    /**
     * 获取InjectionConfig 自定义配置
     */
    protected InjectionConfig getInjectionConfig() {
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                this.setMap(map);
            }
        }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
                "/templates/mapper.xml.vm") {
            // TODO 自定义输出文件目录（将xml自定义输出到资源目录下）
            @Override
            public String outputFile(TableInfo tableInfo) {
                return getResourcePath() + "/mapper/user/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        }));
    }

    /**
     * 获取TableFill策略
     */
    protected List<TableFill> getTableFills() {
        // 自定义需要填充的字段
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("createTime", FieldFill.INSERT));
        tableFillList.add(new TableFill("updateTime", FieldFill.INSERT_UPDATE));
        tableFillList.add(new TableFill("createUid", FieldFill.INSERT));
        tableFillList.add(new TableFill("updateUid", FieldFill.INSERT_UPDATE));
        return tableFillList;
    }


    /**
     * 获取根目录
     */
    private String getRootPath() {
        String file = Objects.requireNonNull(SuperGenerator.class.getClassLoader().getResource("")).getFile();
        return new File(file).getParentFile().getParent();
    }

    /**
     * 获取JAVA目录
     */
    protected String getJavaPath() {
        return getRootPath() + "/src/main/java";
    }

    /**
     * 获取Resource目录
     */
    protected String getResourcePath() {
        return getRootPath() + "/src/main/resources";
    }

    /**
     * @param tablePrefix 数据库表前序
     * @param tableName   数据库表名
     */
    protected AutoGenerator getAutoGenerator(String tablePrefix, String tableName) {
        return new AutoGenerator()
                // 全局配置
                .setGlobalConfig(getGlobalConfig())
                // 数据源配置
                .setDataSource(getDataSourceConfig())
                // 策略配置
                .setStrategy(getStrategyConfig(tablePrefix, tableName))
                // 包配置
                .setPackageInfo(getPackageConfig())
                // 注入自定义配置，如果不指定路径输出XML文件，注释掉
                .setCfg(getInjectionConfig())
                .setTemplate(getTemplateConfig());
    }

}
