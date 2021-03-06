package edu.cnm.deepdive.personalizedsafariapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Accommodation;

import edu.cnm.deepdive.personalizedsafariapp.model.service.AccommodationRepository;
import java.util.Date;
import java.util.List;

/**
 * This AccommodationViewModel class stores and manages UI-related data in a lifecycle
 * conscious way.
 */
public class AccommodationViewModel extends AndroidViewModel {

  private final AccommodationRepository accommodationRepository;
  private final MutableLiveData<Accommodation> dailyAccommodation;
  private final MutableLiveData<Throwable> throwable;

  /**
   * The constructor to initialize objects in the AccommodationViewModel.
   * @param application
   */
  public AccommodationViewModel(@NonNull Application application) {
    super(application);
    accommodationRepository = new AccommodationRepository(application);
    dailyAccommodation = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
  }


  public LiveData<List<Accommodation>> getAccommodations () {
    return accommodationRepository.getAll();
  }

  public LiveData<Accommodation> getDailyAccommodation() {
    return dailyAccommodation;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void setDate(Date date) {
    accommodationRepository.get(date)
        .subscribe(
            (accommodation) -> dailyAccommodation.postValue(accommodation),
            (throwable) -> this.throwable.postValue(throwable),
            () -> dailyAccommodation.postValue(null)
        );
  }
}

