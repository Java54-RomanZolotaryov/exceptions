package telran.exceptions.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFloor;

class BallBrokenFloorTest {

	private static final int N_FLOORS = Integer.MAX_VALUE - 1;
	private static final int N_TEST_RUNS = 100;

	@Test
	void test() {
		BallBrokenFloor bbf = new BallBrokenFloor(N_FLOORS);
		for (int i = 0; i < N_TEST_RUNS; i++) {
			assertEquals(bbf.getBrokenFloor(), getMinBrokenFloor(bbf));
		}
	}

	private int getMinBrokenFloor(BallBrokenFloor bbf) {
		int left = 1;
		int right = bbf.getnFloors();
		while (left <= right) {
			int middle = left + (right - left) / 2;
			try {
				bbf.checkFloor(middle);
				left = middle + 1;
			} catch (Exception e) {
				right = middle - 1;
			}
		}
		return left;
	}
}
