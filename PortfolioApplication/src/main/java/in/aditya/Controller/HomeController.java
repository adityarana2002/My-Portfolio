package in.aditya.Controller;

import in.aditya.Entity.Contact;
import in.aditya.Service.ContactService;
import in.aditya.Service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// This is controller class that we made and design through it ...
@Controller
public class HomeController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private EmailService emailService;

    @GetMapping({"/", "", "/home"})
    public String showHomePage(Model model) {
        model.addAttribute("title", "home");
        return "master";
    }

    @GetMapping("/projects")
    public String showProjectsPage(Model model) {
        model.addAttribute("title", "projects");
        return "master";
    }

    @GetMapping("/resume")
    public String showResumePage(Model model) {
        model.addAttribute("title", "resume");
        return "master";
    }

    @GetMapping("/contact")
    public String showContactPage(Model model) {
        model.addAttribute("title", "contact");
        model.addAttribute("contact", new Contact());
        return "master";
    }

    @PostMapping("/contact")
    public String submitContactForm(@ModelAttribute Contact contact) {
        contactService.saveContact(contact);
        try {
            emailService.sendContactEmail(contact);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/contact?success=true";
    }

}
