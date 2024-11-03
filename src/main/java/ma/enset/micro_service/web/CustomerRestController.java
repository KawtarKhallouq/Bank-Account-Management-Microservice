package ma.enset.micro_service.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.micro_service.dtos.CustomerRequestDTO;
import ma.enset.micro_service.dtos.CustomerResponseDTO;
import ma.enset.micro_service.exceptions.CustomerNotFoundException;
import ma.enset.micro_service.exceptions.EmailAlreadyUsedException;
import ma.enset.micro_service.services.CustomerService;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@Slf4j
@AllArgsConstructor
public class CustomerRestController {
    private CustomerService customerService;
    @GetMapping("/customers")
    public List<CustomerResponseDTO> listCustomers(){
        return customerService.listCustomers();
    }
    @GetMapping("/customers/search")
    public List<CustomerResponseDTO> searchCustomers(@RequestParam(name = "keyword", defaultValue = "") String keyword){
        return customerService.findCustomers("%"+keyword+"%");
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        try {
            CustomerResponseDTO customerById = customerService.getCustomerById(id);
            return ResponseEntity.ok(customerById);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
        }
    }
    @PostMapping("/customers")
    public ResponseEntity<?> saveNewCustomer(@RequestBody CustomerRequestDTO request){
        try {
            CustomerResponseDTO customerResponseDTO = customerService.save(request);
            return ResponseEntity.ok(customerResponseDTO);
        } catch (EmailAlreadyUsedException e) {
            return ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage())); }
    }
    @PutMapping("/customers/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerRequestDTO request, @PathVariable Long id){
        try {
            CustomerResponseDTO customerResponseDTO = customerService.update(request);
            return ResponseEntity.ok(customerResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
        }
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ErrorMessage(e.getMessage()));
        }
    }
}