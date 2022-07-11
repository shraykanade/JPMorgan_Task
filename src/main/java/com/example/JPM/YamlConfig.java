package com.example.JPM;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "application")
public class YamlConfig {

    private List<Map<String, String>> sources;

    public List<Map<String, String>> getSources() {
        return sources;
    }

    public void setSources(List<Map<String, String>> source_info) {
        this.sources = source_info;
    }
}






