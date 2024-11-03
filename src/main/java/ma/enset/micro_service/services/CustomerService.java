package ma.enset.micro_service.services;

import ma.enset.micro_service.dtos.CustomerRequestDTO;
import ma.enset.micro_service.dtos.CustomerResponseDTO;
import ma.enset.micro_service.exceptions.CustomerNotFoundException;
import ma.enset.micro_service.exceptions.EmailAlreadyUsedException;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO request) throws EmailAlreadyUsedException;
    List<CustomerResponseDTO> listCustomers();
    CustomerResponseDTO getCustomerById(Long id) throws CustomerNotFoundException;
    CustomerResponseDTO update(CustomerRequestDTO requestDTO) throws CustomerNotFoundException, EmailAlreadyUsedException;
    void deleteCustomer(Long id) throws CustomerNotFoundException;
    List<CustomerResponseDTO> findCustomers(String keyWord);
}