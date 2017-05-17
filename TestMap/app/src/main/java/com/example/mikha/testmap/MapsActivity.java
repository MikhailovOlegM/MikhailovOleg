package com.example.mikha.testmap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.location.Address;
import android.location.Geocoder;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

@RequiresApi(api = VERSION_CODES.LOLLIPOP)
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
    View.OnClickListener {

  private GoogleMap mMap;
  private LatLngBounds LIMIT_OF_SITY = new LatLngBounds(new LatLng(46.400, 30.530),
      new LatLng(46.550, 30.850));
  private LatLng coordinate;
  private UiSettings uiSettings;
  private Button sendAddress;
  private Button btnAccount;
  private Geocoder geocoder;
  private Locale ruLocale = new Locale.Builder().setLanguage("ru").setScript("Cyrl").build();
  private String userAddress;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    sendAddress = (Button) findViewById(R.id.btnSendAddress);
    // sendAddress.setOnClickListener(this);
    btnAccount = (Button) findViewById(R.id.btnAccount);

    geocoder = new Geocoder(this, ruLocale);

    setContentView(R.layout.activity_maps);
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);

  }


  /**
   * Manipulates the map once available.
   * This callback is triggered when the map is ready to be used.
   * This is where we can add markers or lines, add listeners or move the camera. In this case,
   * we just add a marker near Sydney, Australia.
   * If Google Play services is not installed on the device, the user will be prompted to install
   * it inside the SupportMapFragment. This method will only be triggered once the user has
   * installed Google Play services and returned to the app.
   */
  @Override
  public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
    uiSettings = mMap.getUiSettings();
    uiSettings.setMapToolbarEnabled(false); //hide google icons
    // Default marker from center Odessa
    LatLng odessa = new LatLng(46.465, 30.717);
    mMap.addMarker(new MarkerOptions()
        .position(odessa)
        .title("Odessa marker")
        .icon(BitmapDescriptorFactory.defaultMarker(
            BitmapDescriptorFactory.HUE_AZURE))
        .draggable(true)); //move marker

    mMap.setOnMarkerDragListener(new OnMarkerDragListener() {
      @Override
      public void onMarkerDragStart(Marker marker) {
      }

      @Override
      public void onMarkerDrag(Marker marker) {
      }

      @Override

      public void onMarkerDragEnd(Marker marker) {
        coordinate = marker.getPosition();
        userAddress = sendGeo(coordinate, marker);
        System.out.println(userAddress);
      }
    });

    //Animate orientation camera
    CameraPosition cameraPosition = new CameraPosition.Builder()
        .target(odessa)
        .zoom(12)
        .bearing(0)
        .tilt(50)
        .build();
    mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    // Camera move limit
    mMap.setLatLngBoundsForCameraTarget(LIMIT_OF_SITY);


  }

  private String sendGeo(LatLng point, Marker marker) {

    List<Address> addresses = new ArrayList<>();
    try {
      addresses = geocoder.getFromLocation(point.latitude, point.longitude, 1);
    } catch (IOException e) {
      e.printStackTrace();
    }

    android.location.Address address = addresses.get(0);
    StringBuilder sb = null;
    if (address != null) {
      sb = new StringBuilder();
      for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
        if (i == 1) {
          continue;
        }
        sb.append(address.getAddressLine(i) + "\n");
      }
      Toast.makeText(MapsActivity.this, sb.toString(), Toast.LENGTH_LONG).show();//message on screen
    }

    assert sb != null;
    return address.getAddressLine(0);
  }


  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btnSendAddress:
        System.out.println(userAddress);
        //todo send address from server
        break;
      case R.id.btnAccount:
        //todo user account
        break;
      case R.id.btnPreferences:
        //todo preferences btn
        break;
    }


  }

}
