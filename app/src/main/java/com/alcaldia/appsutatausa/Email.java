package com.alcaldia.appsutatausa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;
import java.util.regex.Pattern;

public class Email extends AppCompatActivity {

    EditText nombre, correo,telefono, mensaje;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedinstanceState){
        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_email);

        Intent intent = getIntent();
        nombre = findViewById(R.id.nombreyApellido);
        correo = findViewById(R.id.email);
        telefono=findViewById(R.id.telefono);
        mensaje=findViewById(R.id.mensaje);

        String sNombre = nombre.getText().toString();
        String sCorreo = correo.getText().toString();
        String sTelefono = telefono.getText().toString();
        String sMensaje = mensaje.getText().toString();

        btnSend = findViewById(R.id.boton_EnviarForm);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(correo.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"El campo de Email es obligatorio",Toast.LENGTH_LONG).show();
                }else if(mensaje.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"El campo de Mensaje es obligatorio",Toast.LENGTH_LONG).show();
                }else if(isValidEmailId(correo.getText().toString().trim())){
                    //Toast.makeText(getApplicationContext(), "Valid Email Address.", Toast.LENGTH_SHORT).show();
                    final String username="appsoportetic@gmail.com";
                    final String password="appAsutatausa1557";
                    String messageToSend= sNombre +"/n"+sCorreo +"/n"+sTelefono +"/n" +"/n"+sMensaje;
                    Properties props = new Properties();
                    props.put("mail.smtp.auth","true");
                    props.put("mail.smtp.starttls.enable","true");
                    props.put("mail.smtp.host","smtp.gmail.com");
                    props.put("mail.smtp.port","587");
                    Session session=Session.getInstance(props,
                            new javax.mail.Authenticator(){
                                @Override
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username,password);
                                }
                            });
                    try{
                        Message message= new MimeMessage(session);
                        message.setFrom(new InternetAddress(username));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
                        message.setSubject("Mensaje de usuario desde App Sutatausa");
                        message.setText("Nombre: "+nombre.getText().toString()+"\n"
                                +"Correo: "+correo.getText().toString()+"\n"
                                +"Telefono: "+telefono.getText().toString()+"\n"+"\n"
                                +"Mensaje:"+"\n"+mensaje.getText().toString());
                        Transport.send(message);
                        Toast.makeText(getApplicationContext(),"mensaje enviado satisfactoriamente",Toast.LENGTH_LONG).show();

                        finish();

                    }catch (MessagingException e){
                        throw new RuntimeException(e);
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Direccion de correo invalida.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    private boolean isValidEmailId(String email){
        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }

}
