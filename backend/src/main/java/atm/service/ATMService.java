//package atm.service;
//
//import atm.chainofresponsibility.DispenseChain;
//import atm.chainofresponsibility.NoteDispenser100;
//import atm.chainofresponsibility.NoteDispenser20;
//import atm.chainofresponsibility.NoteDispenser50;
//import atm.entities.BankService;
//import atm.entities.Card;
//import atm.entities.CashDispenser;
//import atm.enums.OperationType;
//import atm.state.ATMState;
//import atm.state.IdleState;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.atomic.AtomicLong;
//
//@Service
//public class ATMService {
//
//    private final BankService bankService;
//    private final CashDispenser cashDispenser;
//    private static final AtomicLong transactionCounter = new AtomicLong(0);
//    private ATMState currentState;
//    private Card currentCard;
//
//    public ATMService() {
//        this.currentState = new IdleState();
//        this.bankService = new BankService();
//
//        // Setup the dispenser chain
//        DispenseChain c1 = new NoteDispenser100(10); // 10 x $100 notes
//        DispenseChain c2 = new NoteDispenser50(20); // 20 x $50 notes
//        DispenseChain c3 = new NoteDispenser20(30); // 30 x $20 notes
//        c1.setNextChain(c2);
//        c2.setNextChain(c3);
//
//        this.cashDispenser = new CashDispenser(c1);
//    }
//
//    // ---------------- State + Operations ----------------
//    public void changeState(ATMState newState) {
//        this.currentState = newState;
//    }
//
//    public void setCurrentCard(Card card) {
//        this.currentCard = card;
//    }
//
//    public String insertCard(String cardNumber) {
//        currentState.insertCard(this, cardNumber);
//        return "Card inserted successfully";
//    }
//
//    public String enterPin(String pin) {
//        boolean success = bankService.authenticate(currentCard, pin);
//        if (success) {
//            currentState.enterPin(this, pin);
//            return "PIN accepted";
//        }
//        return "Invalid PIN";
//    }
//
//    public String selectOperation(OperationType op, int... args) {
//        currentState.selectOperation(this, op, args);
//        return "Operation performed: " + op;
//    }
//
//    // ---------------- Banking Operations ----------------
//    public double checkBalance() {
//        return bankService.getBalance(currentCard);
//    }
//
//    public String withdrawCash(int amount) {
//        if (!cashDispenser.canDispenseCash(amount)) {
//            return "Insufficient cash available in the ATM.";
//        }
//
//        bankService.withdrawMoney(currentCard, amount);
//
//        try {
//            cashDispenser.dispenseCash(amount);
//            return "Withdrawal successful: $" + amount;
//        } catch (Exception e) {
//            bankService.depositMoney(currentCard, amount); // rollback
//            return "Cash dispensing failed. Amount reverted.";
//        }
//    }
//
//    public String depositCash(int amount) {
//        bankService.depositMoney(currentCard, amount);
//        return "Deposited: $" + amount;
//    }
//
//    // ---------------- Getters ----------------
//    public Card getCurrentCard() {
//        return currentCard;
//    }
//
//    public BankService getBankService() {
//        return bankService;
//    }
//
//    public long nextTransactionId() {
//        return transactionCounter.incrementAndGet();
//    }
//}
