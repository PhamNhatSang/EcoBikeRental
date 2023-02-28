package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import common.exception.InvalidCodeException;
    /**
     * this is ViewBikeInvalidCodeTest
     * @author dell
     * @version 1.0
     */
class ViewBikeInvalidCodeTest {
	private RentBikeController rentBikeController;
	@BeforeEach
	void setUp() throws Exception {
		rentBikeController=new RentBikeController();
	}
	
	@ParameterizedTest
	@CsvSource({
		"vsavsav",
		"sdsd dsd ",
		"IT2241ccs",
		"ssdsada"
	})

	//@Test
	void test(String barCode) {
		assertThrows(InvalidCodeException.class, () -> {
			rentBikeController.viewBike(barCode);
		});
	}

}
