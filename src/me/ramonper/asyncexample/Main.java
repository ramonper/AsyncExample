package me.ramonper.asyncexample;

import me.ramonper.asyncexample.concurrent.ConcurrentAsyncEmail;
import me.ramonper.asyncexample.obj.ObjectEmail;
import org.apache.commons.mail.EmailException;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] strings){
        ObjectEmail objectEmail = new ObjectEmail();
        objectEmail.setEmail("Email"); //main email
        objectEmail.setEmailPassword("Senha"); //password
        objectEmail.setUserName("Ramon Pereira"); //email owner name


        objectEmail.setRecipient("Destinatário");

        ConcurrentAsyncEmail.sendAsyncEmail(objectEmail); // Envia o email
        //send the e-mail

        objectEmail.setRecipient("ramonpg696@gmail.com"); // Muda para um outro destinatário
        // change to other e-mail

        ConcurrentAsyncEmail.sendAsyncEmail(objectEmail); // Envia outro email, para o novo destinatário.
        // send another email, for new recipient
    }
}
