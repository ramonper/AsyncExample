package me.ramonper.asyncexample.concurrent;

import me.ramonper.asyncexample.obj.ObjectEmail;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentAsyncEmail {

    //now, created a pool of threads.
    private final ExecutorService threadPool = Executors.newFixedThreadPool(3);

    //the async function
    public void sendAsyncEmail(ObjectEmail obj) {
        System.out.println("Processing the task...");
        try {
            Future<String> future = threadPool.submit(obj);
            while (!future.isDone()) {
                //Warning that it has not yet been completed
                System.out.println("The task is still in process");
                Thread.sleep(1); //Wait a millisecond
            }

            SimpleEmail se = formEmail(obj);

            String result = future.get();
            System.out.println("The task is completed successfully. Result found: Send email " + obj.getUserName() + " -> " + result);

            assert se != null;
            se.send();
        } catch (InterruptedException | ExecutionException | EmailException err) {
            err.printStackTrace();
        }
    }

    private SimpleEmail formEmail(ObjectEmail obj){
        String email = obj.getEmail();
        String password = obj.getEmailPassword();

        SimpleEmail se = new SimpleEmail();
        se.setHostName("smtp.gmail.com");
        se.setSmtpPort(465);
        se.setAuthenticator(new DefaultAuthenticator(email, password));
        se.setSSLOnConnect(true);

        try {
            se.setFrom(obj.getEmail());
            se.setSubject("Você recebeu um email!");
            se.setMsg("Você recebeu um email por " + obj.getUserName() + " (" + obj.getEmail() + ")." +
                    "\n" +
                    "Data de entrega: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + ".");
            se.addTo(obj.getEmail());
        } catch (EmailException e) {
            return null;
        }
        return se;
    }
    
}
