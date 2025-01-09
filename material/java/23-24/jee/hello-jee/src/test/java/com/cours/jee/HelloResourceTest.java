package com.cours.jee;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.microshed.testing.SharedContainerConfig;
import org.microshed.testing.jaxrs.RESTClient;
import org.microshed.testing.jupiter.MicroShedTest;

import com.cours.jee.model.Message;
import com.cours.jee.rest.HelloResource;

@MicroShedTest
@SharedContainerConfig(AppDeploymentConfig.class)
public class HelloResourceTest {

    @RESTClient
    public static HelloResource helloResource;

    @Test
    public void testCreatePerson() {
        Message message = helloResource.ping();
        assertEquals("Rest API is running", message.getValue());
        assertEquals("fdsf", "dfsfdsfsdfsdf");
    }

}