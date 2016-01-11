package com.sgulab.busmaps.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.sgulab.busmaps.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapFragment extends BaseFragment implements OnMapReadyCallback {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        // Add a marker in Sydney, Australia, and move the camera.
        LatLng choBT = new LatLng(10.7725563,106.6958022);
        map.addMarker(new MarkerOptions().position(choBT).title("Cho Ben Thanh"));
        map.moveCamera(CameraUpdateFactory.newLatLng(choBT));
        addLine(map);
    }

    private void addLine(GoogleMap map) {
        ArrayList<LatLng> points = new ArrayList<>();
        PolylineOptions polyLineOptions = null;
        // traversing through routes
        polyLineOptions = new PolylineOptions();

        points.add(new LatLng(10.7690913,106.6949875));
        points.add(new LatLng(10.7689727,106.6928257));

        polyLineOptions.addAll(points);
        polyLineOptions.width(5);
        polyLineOptions.color(Color.parseColor("#FF0044"));

        map.addPolyline(polyLineOptions);
    }
}
