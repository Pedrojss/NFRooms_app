package es.uca.nfrooms.ui.reserva;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReservaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ReservaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Esto es reserva crack!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}