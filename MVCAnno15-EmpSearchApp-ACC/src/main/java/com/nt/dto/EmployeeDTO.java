package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private int empno;
    private String ename;
    private String job;
    private float sal;

}
