import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount bankAccount;


    @BeforeEach
    public void setUp(){
        bankAccount = new BankAccount();
    }


@Test
    public void canSetAndGetFirstName(){
    bankAccount.setFirstName("John");
    String actual = bankAccount.getFirstName();
    String expected = "John";
        assertEquals(expected, actual );
}

@Test
    public void canSetAndGetLastName(){
    bankAccount.setLastName("Doe");
    String actual = bankAccount.getLastName();
    String expected = "Doe";
        assertEquals(expected, actual );
}@Test
    public void canSetAndGetDOB(){
    bankAccount.setDateOfBirth(LocalDate.of(1950,1,1));
    String actual = String.valueOf(bankAccount.getDateOfBirth());
    String expected = "1950-01-01";
assertEquals(expected, actual);
    }

    @Test
    public void canSetAndGetAccountNumber(){
    bankAccount.setAccountNumber(123123123);
    int actual = bankAccount.getAccountNumber();
    int expected = 123123123;
    assertThat(actual).isEqualTo(expected);}

    @Test
    public void canSetAndGetBalance(){
        bankAccount.setBalance(200);
        float actual = bankAccount.getBalance();
        float expected = 200;
        assertEquals(expected,actual);
    }

    @Test
    public void canSetAndGetAccountType(){
        bankAccount.setAccountType("standard");
        String actual =bankAccount.getAccountType();
        String expected = "standard";
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
    public void canAddInterest(){
        bankAccount.setBalance(100);
        bankAccount.setAccountType("standard");
        bankAccount.addInterest();
      float actual = bankAccount.getBalance();
      float expected = 101;
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