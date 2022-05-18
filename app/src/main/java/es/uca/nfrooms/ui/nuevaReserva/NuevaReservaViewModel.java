package es.uca.nfrooms.ui.nuevaReserva;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NuevaReservaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NuevaReservaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Nueva Reserva");
    }

    public LiveData<String> getText() {
        return mText;
    }
}