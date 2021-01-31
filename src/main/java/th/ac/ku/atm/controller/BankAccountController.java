package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import th.ac.ku.atm.model.BankAccount;
import th.ac.ku.atm.service.BankAccountService;

@Controller
@RequestMapping("/bankaccount")
public class BankAccountController {
    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {this.bankAccountService = bankAccountService;}

    @GetMapping
    public String getBankAccoutPage(Model model) {
        model.addAttribute("allBankaccout",bankAccountService.getBankAccount());
        return  "bankaccount";
    }

    @PostMapping
    public String openAccount(@ModelAttribute BankAccount bankAccount,Model model) {
        bankAccountService.openAccount(bankAccount);
        model.addAttribute("allBankAccount",bankAccountService.getBankAccount());
        return "redirect:bankaccount";
    }

    @GetMapping("/edit/{id}")
    public String getEditBankAccountPage(@PathVariable int id, Model model) {
        BankAccount account = bankAccountService.getBankAccount(id);
        model.addAttribute("bankAccount", account);
        return "bankaccount-edit";
    }

    @PostMapping("/edit/{id}")
    public String editAccount(@PathVariable int id,
                              @ModelAttribute BankAccount bankAccount,
                              Model model) {

        bankAccountService.editBankAccount(bankAccount);
        model.addAttribute("bankaccounts",bankAccountService.getBankAccount());
        return "redirect:/bankaccount";
    }

//    @PostMapping("/deposit/{id}")
//    public String depositAccount(@PathVariable int id, int amount,
//                              Model model) {
//
//        bankAccountService.depositBankAccount(id, amount);
//        model.addAttribute("bankaccounts",bankAccountService.getBankAccount());
//        return "redirect:/bankaccount";
//    }
//
//    @PostMapping("/withdraw/{id}")
//    public String withdrawAccount(@PathVariable int id, int amount,
//                                 Model model) {
//
//        bankAccountService.withdrawBankAccount(id, amount);
//        model.addAttribute("bankaccounts",bankAccountService.getBankAccount());
//        return "redirect:/bankaccount";
//    }

    @PostMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id) {
        BankAccount bankAccount = bankAccountService.getBankAccount(id);
        bankAccountService.deleteBankAccount(bankAccount);
        return "redirect:/bankaccount";
    }


}
