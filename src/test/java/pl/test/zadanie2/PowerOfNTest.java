package pl.test.zadanie2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.test.zadanie2.exceptions.ValueIsBelowZero;
import pl.test.zadanie2.exceptions.ValueIsOutOfBigDecimalRange;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PowerOfNTest {
    private PowerOfN powerOfN;

    @Mock
    private Connection conn;

    @Mock
    private PreparedStatement stmt;

    @Mock
    private ResultSet rs;


    @Before
    public void init() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(conn.prepareStatement(any(String.class))).thenReturn(stmt);
        when(stmt.executeQuery()).thenReturn(rs);
        powerOfN = new PowerOfN(conn);
    }

    @Test
    public void shouldBeEqualsWhenPowerNIsCalculated() throws SQLException {
        when(rs.getBigDecimal(1)).thenReturn(new BigDecimal(720));
        when(rs.next()).thenReturn(true);
        assertEquals(powerOfN.getPowerOfN(any(Integer.class)), BigInteger.valueOf(720));
    }

    @Test
    public void shouldBeEqualsWhenPowerNIsTakenFromTable() throws SQLException {
        when(rs.next()).thenReturn(false);
        assertEquals(powerOfN.getPowerOfN(5), BigInteger.valueOf(120));
    }

    @Test
    public void shouldBeNotEqualsWhenPowerNIsWrong() throws SQLException {
        when(rs.next()).thenReturn(false);
        assertNotEquals(powerOfN.getPowerOfN(4), BigInteger.valueOf(120));
    }

    @Test (expected = ValueIsOutOfBigDecimalRange.class)
    public void shouldThrowValueIsOutOfBigDecimalRangeExceptionWhenValueIsGraterThan59() throws SQLException {
        powerOfN.getPowerOfN(60);
    }
    @Test (expected = ValueIsBelowZero.class)
    public void shouldThrowValueIsBelowZeroWhenValueIsNegative() throws SQLException {
        powerOfN.getPowerOfN(-2);
    }
}
