package atm.controllers;

import atm.enums.OperationType;
import atm.service.ATMSystem;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atm")
public class ATMController {

    private final ATMSystem atmSystem = ATMSystem.getInstance();

    // Insert Card
    @PostMapping("/insert-card")
    public String insertCard(@RequestParam String cardNumber) {
        atmSystem.insertCard(cardNumber);
        return "Card inserted: " + cardNumber;
    }

    // Enter PIN
    @PostMapping("/enter-pin")
    public String enterPin(@RequestParam String pin) {
        atmSystem.enterPin(pin);
        return "PIN entered";
    }

    // Select Operation
    @PostMapping("/operation")
    public String performOperation(@RequestParam OperationType operation,
                                   @RequestParam(required = false) Integer amount) {
        try {
            if (amount != null) {
                atmSystem.selectOperation(operation, amount);
                return "Operation " + operation + " completed with amount $" + amount;
            } else {
                atmSystem.selectOperation(operation);
                return "Operation " + operation + " completed";
            }
        } catch (Exception e) {
            return "❌ Operation failed: " + e.getMessage();
        }
    }
}
