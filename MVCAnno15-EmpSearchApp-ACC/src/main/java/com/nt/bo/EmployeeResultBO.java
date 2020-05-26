package com.nt.bo;

import lombok.Data;

@Data
public class EmployeeResultBO extends EmployeeBO {
	private int deptno;
	private int mgr;

}
