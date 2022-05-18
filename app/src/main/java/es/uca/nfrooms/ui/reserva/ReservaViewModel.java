package es.uca.nfrooms.ui.reserva;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ReservaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ReservaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aqui podrás ver tus reservas o crear una!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}