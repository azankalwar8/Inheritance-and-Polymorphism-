public class SavingsAccount extends BankAccount {
    public SavingsAccount(int id) {
        super(id);
    }

    public void display() {
        System.out.println("SavingAccount ID :" + id);
    }
}

class Test {
    public static void main(String[] args) {
        BankAccount ba = new SavingsAccount(1);
        BankAccount sa = ba;
        sa.display();
    }
}
