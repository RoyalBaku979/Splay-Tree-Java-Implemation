package org.example;

import com.azure.identity.DeviceCodeCredential;
import com.azure.identity.DeviceCodeCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.requests.GraphServiceClient;
import okhttp3.Request;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 *
 */
public class App 
{
    private final static List<String> SCOPES = Arrays.asList("Mail.Read","User.Read");

    public static void main(String[] args) {
        try {
            test();
        }
        catch (RuntimeException r)
        {
            System.out.println(r);
        }
        catch (Exception ex)
        {
            System.out.println("Ex:"+ex);
        }
    }

    public static void test() throws ExecutionException, InterruptedException {
        final DeviceCodeCredential device = new DeviceCodeCredentialBuilder().
                clientId("57ee1672-0999-4e0a-a13c-5e537d77f8ec")
                .tenantId("ef923432-eee8-4245-a9ef-51072c0e8911")
                .challengeConsumer(challange -> System.out.println(challange.getMessage())).build();

        final TokenCredentialAuthProvider tokenCredentialAuthProvider = new TokenCredentialAuthProvider(SCOPES,device);

        GraphServiceClient<Request> graphClient = GraphServiceClient.builder().authenticationProvider(tokenCredentialAuthProvider).buildClient();
        System.out.println("Hello World(asyn)");
        graphClient.me().buildRequest().getAsync().thenAccept(user -> {
            System.out.println("Name:"+user.displayName+"(async)");
        }).get();

    }
