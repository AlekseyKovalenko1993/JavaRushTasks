package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {
    private SimpleConnector connector;
    private SecurityChecker checker = new SecurityCheckerImpl();

    public SecurityProxyConnector(String url) {
        connector = new SimpleConnector(url);
    }

    @Override
    public void connect() {
        if(checker.performSecurityCheck())
            connector.connect();
    }
}
