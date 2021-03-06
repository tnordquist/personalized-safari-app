package edu.cnm.deepdive.personalizedsafariapp.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * Encapsulates some piece of the accommodation information details that are useful for the traveler.
 */
@Entity
public class Accommodation {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "accommodation_id")
  private long id;

  @NonNull
  @ColumnInfo(collate = ColumnInfo.NOCASE)
  private String name = "";

  @NonNull
  @ColumnInfo(index = true)
  private Date start;

  @NonNull
  @ColumnInfo(index = true)
  private Date end;


  @ColumnInfo
  private Double longitude;


  @ColumnInfo
  private Double latitude;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public Date getStart() {
    return start;
  }

  public void setStart(@NonNull Date start) {
    this.start = start;
  }

  @NonNull
  public Date getEnd() {
    return end;
  }

  public void setEnd(@NonNull Date end) {
    this.end = end;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }
}
