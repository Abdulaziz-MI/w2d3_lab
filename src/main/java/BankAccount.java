import java.time.LocalDate;

public class BankAccount {
    private String accountType;
private String firstName;
private String lastName;
private LocalDate dateOfBirth;

private int accountNumber;

private float balance;

private float overdraft;

    public BankAccount(String first, String last, LocalDate dob, int accountNum, String accountType) {
        this.firstName = first;
        this.lastName = last;
        this.dateOfBirth = dob;
        this.accountNumber = accountNum;
        this.accountType = accountType;
        this.balance = 0.00f;
        this.overdraft = -0.00f;
    }

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public LocalDate getDateOfBirth() {return dateOfBirth;}

    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public int getAccountNumber() {return accountNumber;}

    public void setAccountNumber(int accountNumber) {this.accountNumber = accountNumber;}

    public float getBalance() {return balance;}

    public void setBalance(float balance) {this.balance = balance;}

    public float getOverdraft() {return overdraft;}

    public void setOverdraft(float overdraft) {this.overdraft = overdraft;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void addInterest() {
        float interestAmount = 0;
        if (this.accountType.equalsIgnoreCase("standard")) {
            interestAmount = this.getBalance() * ((float) 1 / 100);
        }
        if (this.accountType.equalsIgnoreCase("premium")) {
            interestAmount = this.getBalance() * ((float) 5 / 100);
        }
        if (this.accountType.equalsIgnoreCase("platinum")) {
            interestAmount = this.getBalance() * ((float) 10 / 100);
        }

        this.balance +=interestAmount;
        this.setBalance(this.balance);
    }


    public void deposit(float amount)
    { balance +=amount;}



    public String withdrawal(float amount) {
    String msg;
        if (this.balance - amount > this.overdraft) {
            this.balance -= amount;
            return msg = "Successful withdrawal";
        }
        return msg = "Cannot exceed overdraft limit";
    }

}





