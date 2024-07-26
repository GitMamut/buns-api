package com.mintfrost.buns.api;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mintfrost.buns.api.response.Hello;

@RestController
public class HelloController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public Hello hello(@RequestParam(value = "name", defaultValue = "traveller") String name) {
        String hostName;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostName = "unknown";
        }
        return new Hello(counter.getAndIncrement(),
                String.format("Hello %s, how are you doing?", name),
                hostName,
                new Date());
    }

}
