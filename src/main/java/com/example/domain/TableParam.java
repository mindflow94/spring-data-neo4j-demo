package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created on 2022/3/8.
 *
 * @author MariaCarrie
 */
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class TableParam implements Serializable {
    private String tableName;

}
