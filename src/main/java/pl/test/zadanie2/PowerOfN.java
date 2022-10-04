/*
dana jest metoda BigInteger getPowerOfN(int n)
ktora ma policzyc silnie z liczby N
uwaga: jesli taka silnia byla juz liczona - nie obliczamy jej ponownie, wynik powinien byc cacheowalny.
 */

package pl.test.zadanie2;

import java.math.BigInteger;
import java.sql.*;

public class PowerOfN {
    private final Statement stm;

    public PowerOfN(Statement statement) {
        stm = statement;
    }

    public BigInteger getPowerOfN(int n) throws SQLException {
        BigInteger result;
        String select = "select powerN from power_n where n = " + n + ";";
        ResultSet resultSet = stm.executeQuery(select);
        if (!resultSet.next()) {
            result = powerOfN(n);
            String insert = "insert into power_n values(" + n + ", " + result + ");";
            stm.executeUpdate(insert);
            return result;
        }
        return resultSet.getBigDecimal(1).toBigInteger();
    }

    private BigInteger powerOfN(int n) {
        if (n <= 1) {
            return new BigInteger(String.valueOf(1));
        }
        return new BigInteger(String.valueOf(n)).multiply(powerOfN(n - 1));
    }
}
