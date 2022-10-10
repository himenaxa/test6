/*
dana jest metoda BigInteger getPowerOfN(int n)
ktora ma policzyc silnie z liczby N
uwaga: jesli taka silnia byla juz liczona - nie obliczamy jej ponownie, wynik powinien byc cacheowalny.
 */

package pl.test.zadanie2;

import pl.test.zadanie2.exceptions.ValueIsBelowZero;
import pl.test.zadanie2.exceptions.ValueIsOutOfBigDecimalRange;

import java.math.BigInteger;
import java.sql.*;

public class PowerOfN {
    Connection conn;

    public PowerOfN(Connection conn) {
        this.conn = conn;
    }

    public BigInteger getPowerOfN(int n) throws SQLException {
        if (n > 59) {
            throw new ValueIsOutOfBigDecimalRange();
        }
        BigInteger result;
        PreparedStatement stmt = conn.prepareStatement("select powerN from power_n where n = ?;");
        stmt.setInt(1, n);
        ResultSet resultSet = stmt.executeQuery();
        if (!resultSet.next()) {
            result = powerOfN(n);
            String insert = "insert into power_n values(" + n + ", " + result + ");";
            stmt.executeUpdate(insert);
            return result;
        }
        return resultSet.getBigDecimal(1).toBigInteger();
    }

    private BigInteger powerOfN(int n) {
        if (n < 0) {
            throw new ValueIsBelowZero();
        } else if (n <= 1) {
            return new BigInteger(String.valueOf(1));
        }
        return new BigInteger(String.valueOf(n)).multiply(powerOfN(n - 1));
    }
}
