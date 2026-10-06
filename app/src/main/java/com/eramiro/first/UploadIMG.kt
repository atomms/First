package com.eramiro.first

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class UploadIMG : AppCompatActivity() {

    private var imageUri: Uri? = null
    private var imageView: ImageView? = null

    private val pickImageLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK && result.data != null) {
                imageUri = result.data?.data
                imageView?.setImageURI(imageUri)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_img)

        imageView = findViewById(R.id.imageView)
        val selectButton: Button = findViewById(R.id.selectImageButton)
        val uploadButton: Button = findViewById(R.id.uploadImageButton)

        selectButton.setOnClickListener { openFileChooser() }
        uploadButton.setOnClickListener { uploadImage() }
    }

    private fun openFileChooser() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "image/*"
        }
        pickImageLauncher.launch(intent)
    }

    private fun uploadImage() {
        val uri = imageUri
        if (uri == null) {
            Toast.makeText(this, "Selecciona una imagen primero", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            val inputStream = contentResolver.openInputStream(uri)
            if (inputStream != null) {
                val bytes = inputStream.readBytes()
                inputStream.close()
                val base64Image = Base64.encodeToString(bytes, Base64.DEFAULT)
                sendToSupabase(base64Image)
            } else {
                Toast.makeText(this, "Error al leer la imagen", Toast.LENGTH_SHORT).show()
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Error al leer la imagen", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendToSupabase(base64Image: String) {
        val filename = "imagen_${System.currentTimeMillis()}.jpg"
        val url = "$SUPABASE_URL/storage/v1/object/$BUCKET_NAME/$filename"

        val imageBytes = Base64.decode(base64Image, Base64.DEFAULT)
        val body = imageBytes.toRequestBody("image/jpeg".toMediaTypeOrNull())

        val request = Request.Builder()
            .url(url)
            .header("Authorization", "Bearer $SUPABASE_API_KEY")
            .header("Content-Type", "image/jpeg")
            .put(body)
            .build()

        val client = OkHttpClient()

        Thread {
            try {
                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    Log.d("Supabase", "Imagen subida con éxito: $url")
                    runOnUiThread {
                        Toast.makeText(this, "Imagen subida con éxito", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Log.e("Supabase", "Error al subir imagen: ${response.message}")
                    runOnUiThread {
                        Toast.makeText(this, "Error al subir imagen", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
                runOnUiThread {
                    Toast.makeText(this, "Error de conexión", Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }

    companion object {
        private const val SUPABASE_URL = "https://etpupzmyqygpwwqioozs.supabase.co"
        private const val SUPABASE_API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImV0cHVwem15cXlncHd3cWlvb3pzIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTczOTQzODEyMCwiZXhwIjoyMDU1MDE0MTIwfQ.FAWKWdiVu7TJj9ZXBpkX_KPjYZRQBn_lS0XUUitBUgQ"
        private const val BUCKET_NAME = "Nicestart"
    }
}
