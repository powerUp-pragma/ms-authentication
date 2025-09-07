package co.com.crediya.api.dto;

import java.math.BigInteger;

public record SaveUserDto( String nationalIdNumber, String firstName, String lastName, String phone,String username, String email, BigInteger salary) {
}
