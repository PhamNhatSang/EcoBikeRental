package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import common.exception.InvalidCodeException;
    /**
     * this is ViewBikeValidCodeTest
     * @author NhatSang
     * @version 1.0
     */
class ViewBikeValidCodeTest {
	private RentBikeController rentBikeController;
	@BeforeEach
	void setUp() throws Exception {
		rentBikeController=new RentBikeController();
	}
	
	@ParameterizedTest
	@CsvSource({
		"IT2240",
		"IT2241",
		"IT2238",
		"IT2233"
	})

	//@Test
	void test(String barCode) throws InvalidCodeException, SQLException {
		
		rentBikeController.viewBike(barCode);
		
	}

}
