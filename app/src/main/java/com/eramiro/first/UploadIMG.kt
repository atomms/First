package com.eramiro.first;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.*;

public class UploadIMG extends AppCompatActivity {

    private static final String SUPABASE_URL = "https://etpupzmyqygpwwqioozs.supabase.co"; // Reemplaza con tu URL
    private static final String SUPABASE_API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImV0cHVwem15cXlncHd3cWlvb3pzIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTczOTQzODEyMCwiZXhwIjoyMDU1MDE0MTIwfQ.FAWKWdiVu7TJj9ZXBpkX_KPjYZRQBn_lS0XUUitBUgQ"; // Reemplaza con tu clave API
    private static final String BUCKET_NAME = "Nicestart"; // Nombre del bucket en Supabase

    private Uri imageUri;
    private ImageView imageView;

    private final ActivityResultLauncher<Intent> pickImageLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    imageUri = result.getData().getData();
                    imageView.setImageURI(imageUri);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_img);

        imageView = findViewById(R.id.imageView);
        Button selectButton = findViewById(R.id.selectImageButton);
        Button uploadButton = findViewById(R.id.uploadImageButton);

        selectButton.setOnClickListener(v -> openFileChooser());
        uploadButton.setOnClickListener(v -> uploadImage());
    }

    private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        pickImageLauncher.launch(intent);
    }

    private void uploadImage() {
        if (imageUri == null) {
            Toast.makeText(this, "Selecciona una imagen primero", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            InputStream inputStream = getContentResolver().openInputStream(imageUri);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            String base64Image = Base64.encodeToString(bytes, Base64.DEFAULT);
            sendToSupabase(base64Image);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error al leer la imagen", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendToSupabase(String base64Image) {
        String filename = "imagen_" + System.currentTimeMillis() + ".jpg";
        String url = SUPABASE_URL + "/storage/v1/object/" + BUCKET_NAME + "/" + filename;

        RequestBody body = RequestBody.create(
                Base64.decode(base64Image, Base64.DEFAULT),
                MediaType.parse("image/jpeg")
        );

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + SUPABASE_API_KEY)
                .header("Content-Type", "image/jpeg")
                .put(body)
                .build();

        OkHttpClient client = new OkHttpClient();

        new Thread(() -> {
            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    Log.d("Supabase", "Imagen subida con éxito: " + url);
                    runOnUiThread(() -> Toast.makeText(this, "Imagen subida con éxito", Toast.LENGTH_SHORT).show());
                } else {
                    Log.e("Supabase", "Error al subir imagen: " + response.message());
                    runOnUiThread(() -> Toast.makeText(this, "Error al subir imagen", Toast.LENGTH_SHORT).show());
                }
            } catch (IOException e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(this, "Error de conexión", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }
}
