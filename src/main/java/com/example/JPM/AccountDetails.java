package com.example.JPM;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.List;


public class AccountDetails  {

    @NotNull
    @NotBlank
    String accountNumber;
    List<String> sources;
    public AccountDetails(String accountNumber,List<String> sources) {
        this.accountNumber = accountNumber;
        this.sources = sources;


    }

}