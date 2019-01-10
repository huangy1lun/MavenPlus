package com.hyl.mybatisplus.common.mp;


import com.baomidou.mybatisplus.generator.AutoGenerator;

/**
 * MyBatisPlus代码生成器
 *
 * @author huangYl
 */
public class MyBatisPlusGenerator extends SuperGenerator {

    public static void main(String[] args) {
        /**
         * 调用数据库生成方法，有前序的表名第一个参数需要填写，没有传入""即可，下面为两个例子
         * new MyBatisPlusGenerator().generator("t_", "t_car");
         * new MyBatisPlusGenerator().generator("", "user");
         */
        new MyBatisPlusGenerator().generator("", "user");
    }

    /**
     * 代码生成
     * @param tablePrefix 数据库表前序
     * @param tableName 数据库表名
     */
    public void generator(String tablePrefix, String tableName) {
        // 代码生成器
        AutoGenerator mpg = getAutoGenerator(tablePrefix, tableName);
        mpg.execute();
        if (tableName == null) {
            System.err.println(" Generator Success !");
        } else {
            System.err.println(" TableName【 " + tableName + " 】" + "Generator Success !");
        }
    }





}
