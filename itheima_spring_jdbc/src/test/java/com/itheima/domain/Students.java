package com.itheima.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xing
 * @create 2021-05-12 21:47
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private int id;
    private int class_id;
    private String name;
    private String gender;
    private int score;
}
