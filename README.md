# AsyncExample
A simple ssynchronous email sender system.

Para usar o sistema como uma API, na classe desejada crie um ObjectEmail (Ex.: ObjectEmail object = new ObjectEmail()),
declare os dados necessários, sendo eles:

- **Nome de Usuário**(Ex.: Ramon Pereira)
- **Email Principal**(Ex.: ramonpg696@gmail.com) - Este será o e-mail usado para enviar os emails -.
- **Senha do Email Principal**}
- **Destinatário**(Ex.: emailDoMeuAmigo@gmail.com) - Este irá receber o e-mail enviado pelo Email Principal.

Após tudo feito, use:

ConcurrentAsyncEmail#***sendAsyncEmail***(objectEmail);

Caso queira acelerar o processo, após enviar o primeiro email, apenas altere o destinatário e envie um email novamente. Ex.:


        ObjectEmail objectEmail = new ObjectEmail();
        objectEmail.setEmail("Email"); 
        objectEmail.setEmailPassword("Senha");
        objectEmail.setUserName("Ramon Pereira");
        
        objectEmail.setRecipient("Destinatário1");

        ConcurrentAsyncEmail#sendAsyncEmail(objectEmail);
        
        objectEmail.setRecipient("Destinatário2");
        
        ConcurrentAsyncEmail#sendAsyncEmail(objectEmail);
        
        objectEmail.setRecipient("Destinatário3");
        
        [...]
