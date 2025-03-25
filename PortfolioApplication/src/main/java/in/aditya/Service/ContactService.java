package in.aditya.Service;

import in.aditya.Entity.Contact;
import in.aditya.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;


    public void saveContact(Contact contact)
    {
        contactRepository.save(contact);
    }

}
