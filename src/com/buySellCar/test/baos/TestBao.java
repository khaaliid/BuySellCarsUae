package com.buySellCar.test.baos;

import com.buySellCar.test.daos.TestDao;
import com.buySellCar.test.dtos.TestDto;

public class TestBao {

	public TestDto getTestData() {
		// TODO Auto-generated method stub
		return new TestDao().getTestData();
	}

}
