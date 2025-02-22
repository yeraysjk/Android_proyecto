package yeray.priede.proyecto_uf2_android;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class MusicPlayerFragment extends Fragment {
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el layout del fragmento
        View view = inflater.inflate(R.layout.fragment_music_player, container, false);

        // Inicializar el MediaPlayer
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.sample_music); // Asegúrate de tener un archivo de audio en res/raw

        // Configurar los botones
        Button playButton = view.findViewById(R.id.playButton);
        Button pauseButton = view.findViewById(R.id.pauseButton);
        Button stopButton = view.findViewById(R.id.stopButton);

        playButton.setOnClickListener(v -> mediaPlayer.start());
        pauseButton.setOnClickListener(v -> mediaPlayer.pause());
        stopButton.setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer.prepareAsync(); // Necesario para reiniciar el MediaPlayer
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
