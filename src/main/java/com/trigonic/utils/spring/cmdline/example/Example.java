package com.trigonic.utils.spring.cmdline.example;

import com.trigonic.utils.spring.cmdline.*;
import java.util.logging.*;

public class Example implements Runnable {
    public static void main(String[] args) {
        LogManager.getLogManager().getLogger("").setLevel(Level.SEVERE);
        new CommandLineAppContext().run(Example.class, args);
    }

    private boolean bye = false;
    private String name;

    @Option(shortName = "b", longName = "bye")
    public void setBye(boolean bye) {
        this.bye = bye;
    }

    @Operand(index = 0, description = "name to use in greeting")
    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        String message = (bye ? "Goodbye, %s!" : "Hello, %s!");
        System.out.println(String.format(message, name));
    }
}
