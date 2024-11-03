package ma.enset.micro_service.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.micro_service.dtos.CustomerRequestDTO;
import ma.enset.micro_service.dtos.CustomerResponseDTO;
import ma.enset.micro_service.exceptions.CustomerNotFoundException;
import ma.enset.micro_service.exceptions.EmailAlreadyUsedException;
import ma.enset.micro_service.services.CustomerService;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
public class CustomerGraphQLController {
    private CustomerService customerService;
    @QueryMapping
    public List<CustomerResponseDTO> listCustomers(){
        return customerService.listCustomers();
    }
    @QueryMapping
    public List<CustomerResponseDTO> searchCustomers(@Argument String keyword){
        return customerService.findCustomers("%"+keyword+"%");
    }
    @QueryMapping
    public CustomerResponseDTO getCustomerById(@Argument Long id) throws
            CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }
    @MutationMapping
    public CustomerResponseDTO saveNewCustomer(@Argument CustomerRequestDTO
                                                       request) throws EmailAlreadyUsedException {
        return customerService.save(request);
    }
    @MutationMapping
    public CustomerResponseDTO updateCustomer(@Argument CustomerRequestDTO
                                                      request) throws CustomerNotFoundException, EmailAlreadyUsedException {
        return customerService.update(request);
    }
    @MutationMapping
    public Boolean deleteCustomer(@Argument Long id) throws
            CustomerNotFoundException {
        customerService.deleteCustomer(id);
        return true;
    }
}