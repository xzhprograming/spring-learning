package com.itheima.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * lombok 使用
 * @author xing
 * @create 2021-07-11 15:09
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private String address;
    private Integer age;
    private String hobbit;
    private String phone;
    private Type type;
    public static enum Type{
        WRAP, PROTEIN, VECGIES, CHEESE, SAUCE
    }

    public static void main(String[] args) {
        System.out.println(Person.Type.valueOf("WRAP"));
    }
}
