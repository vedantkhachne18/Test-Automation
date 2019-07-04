package com.genericFunction;

public interface DataBean {
	
	public interface SynchronizationHandle{
		
		int midwait=10;
	}

	public interface ExternalTestData{
		
		String strRadioName="Round trip";
		String strFromCity="mum";
		String strAutoFromCity="Mumbai, IN - Chatrapati Shivaji Airport (BOM)";
		String strToCity="del";
		String strAutoToCity="New Delhi, IN - Indira Gandhi Airport (DEL)";
		int intPlusDayFromCurrent=1;
		int intReturnTripPlusDayFromCurrent=5;
		String strDropdownOption="2";
		
	}
	
	
}
