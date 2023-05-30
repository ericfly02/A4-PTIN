package com.example.appptin;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.appptin.gestor.GestorActivity;
import com.example.appptin.medico.MedicoActivity;
import com.example.appptin.paciente.Patient;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;



public class login extends AppCompatActivity {
    EditText inputcorreu, input_contrassenya;

    // Declarar variables globales
    GoogleSignInClient googleSignInClient;
    private String oauthToken;

    private PopupWindow popupWindow;

    public static String getSession_token() {
        return session_token;
    }

    private static String session_token;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Inicializar el cliente de inicio de sesión de Google
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
    }

    public void login(View view) throws JSONException {

        // get user and password
        inputcorreu = (EditText) findViewById(R.id.email);
        input_contrassenya = (EditText) findViewById(R.id.password);
        String _correu = (inputcorreu.getText()).toString();
        String _contrassenya = (input_contrassenya.getText()).toString();

        // Encriptar contrassenya (comentat fins que els de la api implementing els tokens)
        /*
        Map<String, Object> message = new HashMap<>();
        message.put("password",_contrassenya);
        message.put("exp", new Date(System.currentTimeMillis()+300000));
        message.put("iss","appA4");

        String secret = "jwt1234-piramide-quadrada-gas-salvatge-iceberg-piña-Meren";

        String token = Jwts.builder()
                .setClaims(message)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        */
        // Aqui fem la consulta amb la API a la base de dades per veure si existeix el usuari

        if(_correu != "admin@1234" && _contrassenya != "1234"){
            login(_correu, _contrassenya);
        }
        //!_correu.contains("@")
        else if(_correu.isEmpty() || _correu != "admin@1234"){
            showerror(inputcorreu, "El correu es incorrecte o està buit");
        }

        else if(_contrassenya.isEmpty() || _contrassenya != "1234"){
            showerror(input_contrassenya, "La contrassenya està buida o es incorrecta");
        }
        else {
            Toast.makeText(this, "Call Registration Method", Toast.LENGTH_SHORT).show();
        }
    }

    public void showerror(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }

    public void loginWithGoogle(View view) {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private static final int RC_SIGN_IN = 9001;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Resultado del inicio de sesión de Google
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Inicio de sesión exitoso
                GoogleSignInAccount account = task.getResult(ApiException.class);

                // Obtener el token de OAuth 2.0
                String oauthToken = account.getIdToken();

                // Guardar el token en una variable
                // Puedes usar una variable global o una SharedPreferences
                // En este ejemplo, se guarda en una variable global llamada oauthToken
                this.oauthToken = oauthToken;

                // Aquí se puede obtener el nombre, correo electrónico y otros datos del usuario de la cuenta de Google
                // y utilizarlos para el inicio de sesión en la aplicación
                SharedPreferences preferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("email", account.getEmail());
                editor.apply();

                // Guardamos en variables el correo y el password para acceder a la base de datos
                String email = preferences.getString("email", "");

                login(email, oauthToken);

                // Cambiamos de actividad
                // Aquí se puede obtener el nombre, correo electrónico y otros datos del usuario de la cuenta de Google
                // y utilizarlos para el inicio de sesión en la aplicación
                //Intent intent = new Intent(this, Welcome_popup.class); // Reemplaza NuevaActividad con el nombre de la actividad a la que quieres ir
                //startActivity(intent);

            } catch (ApiException e) {
                // Inicio de sesión fallido
                Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean login(String email, String password) throws JSONException {

        boolean exists = false;
        RequestQueue queue = Volley.newRequestQueue(this);
        Resources r = getResources();
        String apiUrl = r.getString(R.string.api_base_url);
        String url = apiUrl + "/api/login";
        System.out.println(url);
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("user_email", email);
            jsonBody.put("user_password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //boolean exists = response.getBoolean("exists");
                            System.out.println("MENSAJE: " + response);
                            String given_name = response.getString("user_given_name");
                            //String email = response.getString("user_email");
                            String password = response.isNull("password") ? null : response.getString("password");
                            String result = response.getString("result");
                            String role = response.getString("user_role");
                            session_token = response.getString("user_token");

                            // Utiliza los valores extraídos según sea necesario
                            if (result.equals("ok")) {
                                System.out.println("L'usuari existeix");
                                if (role.equals("patient")){

                                    //Acabamos de llenar el SharedPreferences
                                    getUserInfo(session_token);

                                    Patient patient = new Patient(
                                            session_token,
                                            null,
                                            given_name,
                                            null,
                                            null,
                                            null,
                                            null,
                                            null);
                                    navigateToMainActivity(patient);

                                }
                                else if (role.equals("doctor")){
                                    navigateToMetgeActivity();
                                }
                                else if (role.equals("manager")){
                                    navigateToGestorActivity();
                                }

                            } else {
                                System.out.println("L'usuari NO existeix");
                                //Fer Pop-Up o algo per notificar l'usuari
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Error al realizar la solicitud
                        error.printStackTrace();
                        Log.w("Error login", "ATENCION: Ha habido un error, se procedera a cargar una sesion de prueba");
                        Patient patient = new Patient(
                                "45hgghhbhkkK9*^¨cDDG",
                                "Manolo de los Palotes",
                                "Manolin",
                                "manolo@gmail.com",
                                "608745633",
                                "Villalgordo",
                                "Calle para siempre 6",
                                null);
                        navigateToMainActivity(patient);
                    }
                });
        queue.add(jsonObjectRequest);
        return exists;
    }

    private void navigateToMainActivity(Patient patient) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("patient", patient);
        startActivity(intent);
        finish(); // Esto cerrará la actividad actual (LoginActivity, por ejemplo)
    }

    private void navigateToMetgeActivity() {
        Intent intent = new Intent(this, MedicoActivity.class);
        startActivity(intent);
        finish(); // Esto cerrará la actividad actual (LoginActivity, por ejemplo)
    }

    private void navigateToGestorActivity() {
        Intent intent = new Intent(this, GestorActivity.class);
        startActivity(intent);
        finish(); // Esto cerrará la actividad actual (LoginActivity, por ejemplo)
    }

    private void getUserInfo(String session_token) {
        RequestQueue queue = Volley.newRequestQueue(this);
        Resources r = getResources();
        String apiUrl = r.getString(R.string.api_base_url);
        String url = apiUrl + "/api/user_info";
        System.out.println(url);
        System.out.println(session_token);
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("token", session_token);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, jsonBody, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //boolean exists = response.getBoolean("exists");
                            System.out.println("MENSAJE: " + response);
                            String result = response.getString("result");

                            // Utiliza los valores extraídos según sea necesario
                            if (result.equals("ok")) {
                                System.out.println("L'usuari existeix");
                                // Obtiene las SharedPreferences
                                SharedPreferences sharedPreferences = getSharedPreferences("UserPref", Context.MODE_PRIVATE);

                                // Edita las SharedPreferences
                                SharedPreferences.Editor editor = sharedPreferences.edit();


                                editor.putString("session_token", session_token);
                                editor.putString("user_full_name", response.getString("user_full_name"));
                                editor.putString("user_given_name", response.getString("user_given_name"));
                                editor.putString("user_email", response.getString("user_email"));
                                editor.putString("user_phone", response.getString("user_phone"));
                                editor.putString("user_city", response.getString("user_city"));
                                editor.putString("user_address", response.getString("user_address"));
                                editor.putString("user_picture", response.getString("user_picture"));

                                // Aplica los cambios
                                System.out.println("EL TOKEN ES --> " + session_token);
                                editor.apply();

                            }
                            else {
                                System.out.println("Error");
                            }
                        }
                        catch (JSONException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Error al realizar la solicitud
                        error.printStackTrace();
                        Log.w("Error login", "ATENCION: Ha habido un error, se procedera a cargar una sesion de prueba");
                        Patient patient = new Patient(
                                "45hgghhbhkkK9*^¨cDDG",
                                "Manolo de los Palotes",
                                "Manolin",
                                "manolo@gmail.com",
                                "608745633",
                                "Villalgordo",
                                "Calle para siempre 6",
                                null);
                        navigateToMainActivity(patient);
                    }
                });
        queue.add(jsonObjectRequest);
    }


}