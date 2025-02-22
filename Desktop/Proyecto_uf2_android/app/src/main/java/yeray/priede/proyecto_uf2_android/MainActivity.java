package yeray.priede.proyecto_uf2_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener los botones desde el layout
        Button playMusicButton = findViewById(R.id.playMusicButton);
        Button startTrackingButton = findViewById(R.id.startTrackingButton);

        // Configurar el listener para el botón de reproductor de música
        playMusicButton.setOnClickListener(v -> openMusicPlayer());

        // Configurar el listener para el botón de seguimiento de recorrido
        startTrackingButton.setOnClickListener(v -> openTracking());
    }

    // Método para abrir el fragmento de reproducción de música
    public void openMusicPlayer() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new MusicPlayerFragment())
                .commit();
    }

    // Método para abrir la actividad de seguimiento
    public void openTracking() {
        Intent intent = new Intent(this, TrackingActivity.class);
        startActivity(intent);
    }
}
