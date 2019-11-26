package com.example.ctbvideodeom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.coolpush.ctbusinesslibcore.CTGlobalAdConfig;
import com.coolpush.ctbusinesslibcore.utils.ToastUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int REQUEST_CODE_PERMISSION = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        View openMotivateBtn = findViewById(R.id.btn_open_motivate_video);
        openMotivateBtn.setOnClickListener(this);

        if (needRequestPermission()) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_CODE_PERMISSION);
        }
        CTGlobalAdConfig.requestRealNetworkIp();
    }

    @Override
    public void onClick(View v) {
        if (needRequestPermission()) {
            ToastUtils.showToast("请申请必要权限");
            return;
        }
        Intent intent = new Intent("ct_intent_MOTIVATE_VIDEO");
        v.getContext().startActivity(intent);
    }

    private boolean needRequestPermission() {
        return ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED;
    }
}
