package com.example.comemierdas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.io.File;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    public final String[] EXTERNAL_PERMS = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    public final int EXTERNAL_REQUEST = 50;
    private int numArchivos = 0;
    private int numCarpetas = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }


    public void onClick(View v) {
        selectCarpeta();
    }


    public void selectCarpeta() {
        if (requestForPermission()) {
            File carpeta = new File("/storage/self/primary/WhatsApp/Media/");
            if (carpeta.exists() && carpeta.isDirectory()) {
              RecorrerCarpetas escaneo = new RecorrerCarpetas(carpeta,this);
                escaneo.run();
            }
        }
    }




    //----------------------------- permisos --------------------------------

    public boolean requestForPermission() {

        boolean isPermissionOn = true;
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            if (!canAccessExternalSd()) {
                isPermissionOn = false;
                requestPermissions(EXTERNAL_PERMS, EXTERNAL_REQUEST);
            }
        }

        return isPermissionOn;
    }

    public boolean canAccessExternalSd() {
        return (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE));

    }

    //-----------------------------------------------------------------------


}
