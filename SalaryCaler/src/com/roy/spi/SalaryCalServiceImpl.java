package com.roy.spi;

public class SalaryCalServiceImpl implements SalaryCalService{

	@Override
	public Double cal(Double salary) {
		return salary * 1.4;
	}

}
