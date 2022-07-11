package com.example.JPM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@EnableConfigurationProperties(value = YamlConfig.class)
@RestController
public class ValidateBankAccount {

    @Autowired
    private YamlConfig yamlConfig;


    @PostMapping(value = "/isValidAccount")
    @ResponseBody
    List<Result> insert(@RequestBody AccountDetails accDetails) {

        GetValidAccount isValidAcc = new GetValidAccount();
        List<Map<String, String>> all_source_info = yamlConfig.getSources();
        List<Result> result= new ArrayList<Result>();

        if (accDetails.sources.size() > 0) {
            for (int i = 0; i < accDetails.sources.size(); i++) {
                for (int j = 0; j < all_source_info.size(); j++) {

                    if (all_source_info.get(j).get("name").equals(accDetails.sources.get(i))) {
                        String name = all_source_info.get(j).get("name");
                        String url_info = all_source_info.get(j).get("url");
                        Boolean valid=isValidAcc.accountExists(url_info,accDetails.accountNumber);
                        Result responseValue= new Result(name,valid);
                        result.add(responseValue);

                    }
                }
            }}
        else
            {
                for (int i = 0; i < all_source_info.size(); i++) {
                    String name = all_source_info.get(i).get("name");
                    String url_info = all_source_info.get(i).get("url");
                    Boolean valid=isValidAcc.accountExists(url_info,accDetails.accountNumber);
                    Result responseValue= new Result(name,valid);
                    result.add(responseValue);

                }
            }



        return result;
    }

}