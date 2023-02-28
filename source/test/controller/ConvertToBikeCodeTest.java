package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
    /**
     * this is  ConvertToBikeCodeTest 
     * @author NhatSang
     * @version 1.0
     */
class ConvertToBikeCodeTest {
    private RentBikeController rentBikeController;
	@BeforeEach
	void setUp() throws Exception {
		rentBikeController=new RentBikeController();
	}
	@ParameterizedTest
	@CsvSource({
		"IT2238, asds,false",
		"IT2240, bike8,true",
		"IT2241, bik6,false"
	})

	//@Test
	void test(String barcode, String expectedBikeCode,boolean isTrue) {
		String actualBikeCode = rentBikeController.convertToBikeCode(barcode);
		assertEquals(expectedBikeCode.equals(actualBikeCode),isTrue);
	}

}
