package com.greenkrueger.demo;

import com.greenkrueger.demo.client.exceptions.ClientCreationException;
import com.greenkrueger.demo.client.models.Client;
import com.greenkrueger.demo.client.repos.ClientRepo;
import com.greenkrueger.demo.client.services.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;

import java.util.Optional;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT + ".enabled=false"
})
@ExtendWith(SpringExtension.class)
public class ClientServerTest {

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepo clientRepo;

    @Test
    public void getClientTest01() throws ClientCreationException {
        Client mockClient = new Client("Demari","Green","d@gmail.com");
        mockClient.setId(1l);
        BDDMockito.doReturn(Optional.of(mockClient)).when(clientRepo).findById(1l);
        Client actualClient = clientService.getById(1l);
        Assertions.assertEquals(mockClient, actualClient);
    }
}
