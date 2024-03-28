import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WalletTest {
    private Wallet wallet;

    double amount;

    @BeforeEach
    void initClass(){
        wallet = new Wallet(100000,"Rupiah");
        System.out.println("make wallet objek");
    }

    @Test
    void testDepositAmountNormal(){
        amount = 1000;
        wallet.depositAmount(amount);
        Assertions.assertEquals(101000, wallet.getBalance());
        System.out.println("deposit amount more than 0");
    }

    @Test
    void testDepositAmount0(){
        amount = 0;
        wallet.depositAmount(amount);
        Assertions.assertEquals(100000, wallet.getBalance());
        System.out.println("deposit amount is 0");
    }
    @Test
    void testDepositAmountLessThan0(){
        amount = -3;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wallet.depositAmount(amount);;
        });
        System.out.println("deposit amount less than 0");
    }

    @Test
    void testWitdrawAmountNormal(){
        amount = 40000;
        wallet.withdrawAmount(amount);
        Assertions.assertEquals(60000,wallet.getBalance());
        System.out.println("Witdraw Amount More Than 0 Less Than Balance");
    }
    @Test
    void testWitdrawAmount0(){
        amount = 0;
        wallet.withdrawAmount(amount);
        Assertions.assertEquals(100000,wallet.getBalance());
        System.out.println("Witdraw Amount 0 ");
    }
    @Test
    void testWitdrawAmountLessThan0(){
        amount = -2;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wallet.withdrawAmount(amount);;
        });
        System.out.println("Witdraw Amount Less Than 0 ");
    }
    @Test
    void testWitdrawAmountMoreThanBalance(){
        amount = 200000;
        Assertions.assertFalse(wallet.withdrawAmount(amount));
        System.out.println("Witdraw  Amount More Than Balance");
    }
    @Test
    void testTransferFundsNormal(){
        Wallet recipient = new Wallet(10000,"Rupiah");
        wallet.transferFunds(recipient,10000);
        Assertions.assertEquals(20000,recipient.getBalance());
        System.out.println("Transfer Funds Amount Less Than Balance and same currency");
    }

    @Test
    void testTransferFundsAmountMoreThanBalance(){
        Wallet recipient = new Wallet(10000,"Rupiah");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wallet.transferFunds(recipient,200000);;
        });
        System.out.println("Transfer Funds Amount More Than Balance");
    }
    @Test
    void testTransferFundsDifferentCurrency(){
        Wallet recipient = new Wallet(10000,"Dolar");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            wallet.transferFunds(recipient,10000);;
        });
        System.out.println("Transfer Funds Different Currency");
    }

}
