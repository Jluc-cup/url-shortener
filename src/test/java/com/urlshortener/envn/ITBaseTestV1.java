package com.urlshortener.envn;

import com.urlshortener.UrlShortenerApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {UrlShortenerApplication.class})
@AutoConfigureMockMvc
@ActiveProfiles("it-test")
public class ITBaseTestV1 {





}
