package com.ticket.bookingsystem.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
public class CustomerDTO {
    private long id;
    @NotBlank (message = "first name must not be blank")
    private String firstName;
    @NotBlank (message= "surname must not be blank")
    private String surname;
    @NotNull (message= "date of birth is required")
    private Date dateOfBirth;
    private String email;
}
