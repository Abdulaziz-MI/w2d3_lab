import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount bankAccount;


    @BeforeEach
    public void setUp(){
        bankAccount = new BankAccount(
                "John",
                "Doe",
                LocalDate.of(1950,1,1),
                123123123,
                "standard");
    }


@Test
    public void canGetFirstName(){
    String actual = bankAccount.getFirstName();
    String expected = "John";
        assertEquals(expected, actual );
}@Test
    public void canSetFirstName(){
        bankAccount.setFirstName("Johnny");
    String actual = bankAccount.getFirstName();
    String expected = "Johnny";
        assertEquals(expected, actual );
}
@Test
    public void canGetLastName(){
    String actual = bankAccount.getLastName();
    String expected = "Doe";
        assertEquals(expected, actual );
}
    @Test
    public void canSetLastName(){
        bankAccount.setLastName("Doey");
        String actual = bankAccount.getLastName();
        String expected = "Doey";
        assertEquals(expected, actual );
    }

@Test
    public void canGetDOB(){
    String actual = String.valueOf(bankAccount.getDateOfBirth());
    String expected = "1950-01-01";
        assertEquals(expected, actual );
}
@Test
    public void canSetDOB(){
    bankAccount.setDateOfBirth(LocalDate.of(1900,1,1));
    String actual = String.valueOf(bankAccount.getDateOfBirth());
    String expected = "1900-01-01";
    assertEquals(expected, actual);
    }

    @Test
    public void canGetAccountNumber(){
    int actual = bankAccount.getAccountNumber();
    int expected = 123123123;
    assertThat(actual).isEqualTo(expected);}
    @Test
    public void canSetAccountNumber(){
    bankAccount.setAccountNumber(1111111111);
    int actual = bankAccount.getAccountNumber();
    int expected = 1111111111;
    assertThat(actual).isEqualTo(expected);}

    @Test
    public void canGetBalance(){
        float actual = bankAccount.getBalance();
        float expected = 0.00f;
        assertEquals(expected,actual);}
    @Test
    public void canSetBalance(){
        bankAccount.setBalance(200.00f);
        float actual = bankAccount.getBalance();
        float expected = 200.00f;
        assertEquals(expected,actual);}

    @Test
    public void canGetAccountType(){

        String actual =bankAccount.getAccountType();
        String expected = "standard";
        assertEquals(expected,actual);
    }
    @Test
    public void canSetAccountType(){
        bankAccount.setAccountType("premium");
        String actual =bankAccount.getAccountType();
        String expected = "premium";
        assertEquals(expected,actual);
    }

    @Test
    public void canDeposit(){
        bankAccount.deposit(200);
        float actual = bankAccount.getBalance();
        float expected = 200;
        assertEquals(expected,actual);
    }

    @Test
    public void canWithdraw(){
        bankAccount.setBalance(200);
        bankAccount.withdrawal(100);
        float actual = bankAccount.getBalance();
        float expected = 100;
        assertEquals(expected,actual);
    }

    @Test
    public void canAddInterestToStandard(){
        bankAccount.setBalance(100);
        bankAccount.setAccountType("standard");
        bankAccount.addInterest();
      float actual = bankAccount.getBalance();
      float expected = 101;
      assertEquals(expected, actual);}
    @Test
    public void canAddInterestToPremium(){
        bankAccount.setBalance(100);
        bankAccount.setAccountType("premium");
        bankAccount.addInterest();
      float actual = bankAccount.getBalance();
      float expected = 105;
      assertEquals(expected, actual);}
    @Test
    public void canAddInterestToPlatinum(){
        bankAccount.setBalance(100);
        bankAccount.setAccountType("platinum");
        bankAccount.addInterest();
      float actual = bankAccount.getBalance();
      float expected = 110;
      assertEquals(expected, actual);}
    @Test
    public void canAddOverdraft(){
        bankAccount.setBalance(100);
        bankAccount.setOverdraft(20);
        float actual = bankAccount.getOverdraft();
        float expected= 20.00f;
      assertEquals(expected, actual);}

    @Test
    public void canBalanceFallBelowOverdraft(){
        bankAccount.setBalance(100);
        bankAccount.setOverdraft(20);
        bankAccount.withdrawal(90);
        float actual = bankAccount.getBalance();
        float expected= 100.00f;
      assertEquals(expected, actual);}
@Test
    public void canOverdraftDisplayRejectedString(){
        bankAccount.setBalance(100);
        bankAccount.setOverdraft(20);
        String actual = bankAccount.withdrawal(90);
        String expected= "Cannot exceed overdraft limit";
      assertEquals(expected, actual);}
    @Test
    public void canOverdraftDisplayAcceptedString(){
        bankAccount.setBalance(100);
        bankAccount.setOverdraft(20);
        String actual = bankAccount.withdrawal(70);
        String expected= "Successful withdrawal";
      assertEquals(expected, actual);}


        }