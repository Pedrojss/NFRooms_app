package es.uca.nfrooms.ui.ConsultarReserva;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ConsultarReservaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ConsultarReservaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Nueva Reserva");
    }

    public LiveData<String> getText() {
        return mText;
    }
}