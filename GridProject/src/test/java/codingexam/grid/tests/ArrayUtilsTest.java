package codingexam.grid.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import codingexam.utils.ArrayUtils;

public class ArrayUtilsTest {

    @Test
    public void emptyarrayWithNullInput() {
        assertThat(ArrayUtils.arrayFromString(null), equalTo(new int[0][0]));
    }

    @Test
    public void createsemptyarrayWithAnyNonNumericInput() {
        assertThat(ArrayUtils.arrayFromString("1 2 3 a 5"), equalTo(new int[0][0]));
    }

    @Test
    public void createsOneLinearrayWithOneLineOfStringData() {
        assertThat(ArrayUtils.arrayFromString("1  2   3  4 5"), equalTo(new int[][]{ { 1, 2, 3, 4, 5 } }));
    }

    @Test
    public void createsMultiLinearrayWithMultipleLinesOfStringData() {
        assertThat(ArrayUtils.arrayFromString("1  2   3  4 5\n6 7 8  9\t10"),
                equalTo(new int[][]{ { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 } }));
    }

    @Test
    public void lengthOfFirstLineDeterminesRowLengthAndExtraNumbersInLaterLinesAreDiscarded() {
        assertThat(ArrayUtils.arrayFromString("1 2 3\n6 7 8 9 10"),
                equalTo(new int[][]{ { 1, 2, 3 }, { 6, 7, 8 } }));
    }

    @Test
    public void lengthOfFirstLineDeterminesRowLengthAndMissingNumbersInLaterLinesAreZero() {
        assertThat(ArrayUtils.arrayFromString("1 2 3 4 5\n6 7 8   "),
                equalTo(new int[][]{ { 1, 2, 3, 4, 5 }, { 6, 7, 8, 0, 0 } }));
    }
}