package com.ticket.bookingsystem.models.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CustomerDTO  {

    private long id;
    @Pattern(regexp = "^[a-zA-Z\\-\\s]*$", message = "First name contains invalid characters")
    @Size(min = 2, max = 10, message = "First name must contain between 2 and 10 characters" )
    @NotBlank (message = "first name must not be blank")
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z\\-\\s]*$", message = "Surname contains invalid characters")
    @Size(min = 2, max = 20, message = "Surname must contain between 2 and 10 characters" )
    @NotBlank (message= "surname must not be blank")
    private String surname;
    @Past (message = "date of birth must be an existing date")
    private LocalDate dateOfBirth;
    @NotBlank(message = "Email is obligatory")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Email is not valid")
    private String email;
}
