package com.lwy.es.com.lwy.demo.entitys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {
    private String name;
    private String sex;
    private Integer age;
}
