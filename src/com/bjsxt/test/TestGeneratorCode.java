package com.bjsxt.test;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * Mybatis Plus代码生成器
 *
 */
public class TestGeneratorCode {
    public static void main(String[] args) {
        //创建代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //是否覆盖同名文件？默认false
        globalConfig.setFileOverride(false);
        //是否需要ActiveRecord支持
        globalConfig.setActiveRecord(true);
        //是否开启二级缓存
        globalConfig.setEnableCache(false);
        //是否在xml映射文件定义resultMap标签
        globalConfig.setBaseResultMap(true);
        //是否在xml映射文件中定义字段列表-----sql标签
        globalConfig.setBaseColumnList(false);
        //从系统环境中获取当前项目的根目录
        String rootDir = System.getProperty("user.dir");
        //设置生成的代码输出位置
        globalConfig.setOutputDir(rootDir+"/src");
        //设置主键生成策略----Auto就是主键自增
        globalConfig.setIdType(IdType.AUTO);

        //数据库的配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/ting?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2D8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");

        //生成的代码输出配置----生成的代码输出到哪个包下
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.bjsxt")    //设置父包
                .setMapper("mapper")            //生成的mapper接口保存的包名
                .setService("service")          //生成的服务代码保存的包名
                .setController("controller")    //生成的控制器代码保存的包名
                .setEntity("entity")            //生成的实体类保存的包名
                .setXml("mapper");              //生成的xml映射文件保存的包名

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)        //是否设置全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)       //设置表名和类名的映射关系
                .setTablePrefix("t_")       //设置表名的前缀，生成代码的时候，对应类名会过滤掉前缀
                .setInclude("t_admin","t_admin_role",      //指定要生成代码的表格名称
                        "t_company","t_host","t_host_power",
                        "t_married_person","t_menu",
                        "t_order","t_planner","t_role","t_role_menu");
        //将定义好的配置信息传递到自动生成器中
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.setStrategy(strategyConfig);

        //生成代码
        autoGenerator.execute();


    }
}