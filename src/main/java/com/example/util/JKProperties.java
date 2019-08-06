package com.example.util;

import org.springframework.beans.factory.annotation.Value;

public class JKProperties {
    @Value("${com.example.title}")
    private String title;
    @Value("${com.example.description}")
    private String description;
}
