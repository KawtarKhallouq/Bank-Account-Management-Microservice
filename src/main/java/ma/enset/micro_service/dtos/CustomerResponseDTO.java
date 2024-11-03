package ma.enset.micro_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
