package edu.iu.wkusper.guitar.Security;

import edu.iu.wkusper.guitar.model.Customer;
import edu.iu.wkusper.guitar.repository.CustomerRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailSecurityService implements
        UserDetailsService {
    CustomerRepository customerRepository;

    public UserDetailSecurityService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Customer customer=
                    customerRepository.findByUsername(username);
            if(customer == null){
                throw new UsernameNotFoundException("");
            }
            return User
                    .withUsername(username)
                    .password(customer.password())
                    .build();
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
