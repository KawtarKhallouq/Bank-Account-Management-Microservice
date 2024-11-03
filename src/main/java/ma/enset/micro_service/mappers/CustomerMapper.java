package ma.enset.micro_service.mappers;

import ma.enset.micro_service.dtos.CustomerRequestDTO;
import ma.enset.micro_service.dtos.CustomerResponseDTO;
import ma.enset.micro_service.entities.Customer;
import org.springframework.stereotype.Service;
import org .modelmapper.ModelMapper;

@Service
public class CustomerMapper {
    private  ModelMapper modelMapper=new ModelMapper();
    public CustomerResponseDTO from(Customer customer){
        return modelMapper.map(customer,CustomerResponseDTO.class);
    }
    public Customer from(CustomerRequestDTO customerRequestDTO){
        return modelMapper.map(customerRequestDTO,Customer.class);
    }
}
