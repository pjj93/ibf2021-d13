package ibf2021.d13.workshop13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ibf2021.d13.workshop13.Util.Contacts;

@Controller
public class AddressBookController {
    private static final Logger logger = LoggerFactory.getLogger(AddressBookController.class);
    
    @Autowired
    private ApplicationArguments applicationArguments;
    
    @GetMapping(path = {"/", "/contact"})
    public String showForm (Model model) {
        Contact contact = new Contact();
        model.addAttribute("contacts", contact);
        return "form";
    }

    @GetMapping("/contact/{id}")
    public String getContact(Model model, @PathVariable(value="id") String id) {
        logger.info("contactId > " + id);
        Contacts ct = new Contacts();
        ct.getContactById(model, id, applicationArguments);
        return "showContact";
    }
    
    @PostMapping("/contact")
    public String contactSubmit(@ModelAttribute Contact contact, Model model) {
        logger.info("Name > " + contact.getName());
        logger.info("Email > " + contact.getEmail());
        logger.info("Phone Number > " + contact.getPhoneNumber());
        Contacts ct = new Contacts();
        ct.saveContact(contact, model, applicationArguments);
        return "showContact";
    }
}