package com.demo.dto.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {
	
	@Email
    private String email;
    
    @Size(min = 8, message = "Şifre en az 8 karakterli olmalıdır")
    @Pattern(
    	    regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$",
    	    message = "Şifre en az 8 karakterli, bir büyük harf, bir sayı ve bir özel karakter içermelidir"
    	)
    private String password;
    
    private String fullName;
}
