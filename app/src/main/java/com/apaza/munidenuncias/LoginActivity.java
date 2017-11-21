package com.apaza.munidenuncias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.apaza.munidenuncias.Clases.ApiServiceGenerator;
import com.apaza.munidenuncias.Clases.ResponseMessage;
import com.apaza.munidenuncias.Interfaces.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText edtusername;
    private EditText edtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtusername = (EditText) findViewById(R.id.editTextusername);
        edtpassword = (EditText) findViewById(R.id.editTextpassword);

    }


    public void callLogin(View view) {

        String username = edtusername.getText().toString();
        String password = edtpassword.getText().toString();

        ApiService servicio = ApiServiceGenerator.createService(ApiService.class);
        Call<ResponseMessage> call = null;

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Usuario y Contraseña son campos requeridos", Toast.LENGTH_SHORT).show();
            return;
        }else{
            call = servicio.createAuth(username,password);

           // Intent a = new Intent(this, MainActivity.class);
           // startActivity(a);
        }
        final Intent a = new Intent(this, MainActivity.class);
        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        ResponseMessage responseMessage = response.body();
                        Log.d(TAG, "responseMessage: " + responseMessage);

                       // Toast.makeText(LoginActivity.this, responseMessage.getMessage(), Toast.LENGTH_LONG).show();
                        Toast.makeText(LoginActivity.this, "Usuario válido, ingresando...", Toast.LENGTH_LONG).show();
                        startActivity(a);
                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Credenciales incorrectas");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (Throwable x) {
                    }
                }
            }


            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });



    }

    public void callRegisterUsuario(View view){

        String username = edtusername.getText().toString();
        String password = edtpassword.getText().toString();

        ApiService servicio1 = ApiServiceGenerator.createService(ApiService.class);
        Call<ResponseMessage> call = null;

        call = servicio1.createUsuario(username,password);

        call.enqueue(new Callback<ResponseMessage>() {
            @Override
            public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        ResponseMessage responseMessage = response.body();
                        Log.d(TAG, "responseMessage: " + responseMessage);

                        Toast.makeText(LoginActivity.this, responseMessage.getMessage(), Toast.LENGTH_LONG).show();


                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (Throwable x) {
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseMessage> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }
}
