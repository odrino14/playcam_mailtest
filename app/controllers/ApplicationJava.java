package controllers;

import org.apache.commons.mail.EmailAttachment;
import play.Play;
import play.api.libs.mailer.MailerClient;
import play.libs.mailer.Email;
import play.mvc.Controller;
import play.mvc.Result;


import javax.inject.Inject;
import java.io.File;

public class ApplicationJava extends Controller {

    private final MailerClient mailer;

    String id ="";

    @Inject
    public ApplicationJava(MailerClient mailer) {
        this.mailer = mailer;
    }

    public Result send() {
        String cid = "1234";
        final Email email = new Email()
                .setSubject("Simple email")
                .setFrom("Mister FROM <playcamp2018@gmx.de>")
                .addTo("Miss TO <audrando@yahoo.fr>")
                .setBodyText("du hast dich registried")
                .setBodyHtml("<html><body><p>An <b>html</b> message with cid <img src=\"cid:" + cid + "\"></p></body></html>");
        try {

            id = mailer.send(email);
            return ok("Email " + id + " sent!");
        }catch(Exception e){
            System.out.println("No Mail send! " + e.toString());
            throw e;
        }
    }
}
