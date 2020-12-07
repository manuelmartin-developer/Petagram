package manuelmartin.petagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.view.View;
import java.util.Properties;
import android.os.Bundle;
import android.widget.Toast;

public class ContactoActivity extends AppCompatActivity {

    // Declaración de variables y objetos
    private EditText etNombre, etEmail, etMensaje;
    private Button btEnviarComentario;
    Session session;
    String correo, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        setSupportActionBar(findViewById(R.id.toolBar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        correo = "correo desde el que se envía";
        pass = "contraseña del correo";


        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etEmail);
        etMensaje = findViewById(R.id.etMensaje);
        btEnviarComentario = findViewById(R.id.btEnviarComentario);

        btEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");

                try{

                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, pass);
                        }
                    });


                     if(session!=null){

                       Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Petagram");
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(etEmail.getText().toString()));
                        message.setContent(etMensaje.getText().toString(), "text/html; charset=utf-8");

                        Transport.send(message);
                         Toast.makeText(ContactoActivity.this, "El comentario ha sido enviado", Toast.LENGTH_LONG).show();
                         etNombre.setText("");
                         etEmail.setText("");
                         etMensaje.setText("");
                    }else {
                         Toast.makeText(ContactoActivity.this, "El correo electrónico para envío se encuentra desactivado.", Toast.LENGTH_LONG).show();
                     }

                }catch (Exception e){
                    e.getMessage();
                }
            }
        });

    }



}