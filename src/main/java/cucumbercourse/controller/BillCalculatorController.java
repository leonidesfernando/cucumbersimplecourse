package cucumbercourse.controller;

import cucumbercourse.helper.BillCalculationHelper;
import cucumbercourse.model.BillAmount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/calculator")
public class BillCalculatorController {

    @GetMapping("/finalBill")
    public String addBookView(Model model) {
        model.addAttribute("bill", new BillAmount());
        return "calculate-bill";
    }

    @PostMapping("/finalBill")
    public RedirectView calculate(@ModelAttribute("bill") BillAmount billAmount, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/calculator/finalBill", true);
        BillAmount finalBill = new BillAmount(billAmount.getBillAmount(), billAmount.getTaxRate(),
                BillCalculationHelper.calculateBillCustomer(billAmount.getBillAmount(), billAmount.getTaxRate()));
        redirectAttributes.addFlashAttribute("billCalculated", finalBill);
        return redirectView;
    }
}
