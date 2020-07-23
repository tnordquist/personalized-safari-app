package edu.cnm.deepdive.personalizedsafariapp.model.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.personalizedsafariapp.model.dao.GeneralDao;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.Accommodation;
import edu.cnm.deepdive.personalizedsafariapp.model.entity.General;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class GeneralRepository {

  private final Context context;
  private final PersonalizedSafariAppDatabase database;
  private final GeneralDao generalDao;

  public GeneralRepository(Context context) {
    this.context = context;
    database = PersonalizedSafariAppDatabase.getInstance();
    generalDao = database.getGeneralDao();
  }

  public LiveData<List<General>> getAll() {
    return generalDao.selectAll();
  }

  public Completable save(General general) {
    if (general.getId() == 0) {
      return Completable.fromSingle(generalDao.insert(general))
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(generalDao.update(general))
          .subscribeOn(Schedulers.io());
    }
  }

  public Completable delete(General general) {
    if (general.getId() == 0) {
      return Completable.fromAction(() -> {
      })
          .subscribeOn(Schedulers.io());
    } else {
      return Completable.fromSingle(generalDao.delete(general))
          .subscribeOn(Schedulers.io());
    }
  }


}

