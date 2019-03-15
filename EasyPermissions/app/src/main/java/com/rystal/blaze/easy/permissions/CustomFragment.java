package com.rystal.blaze.easy.permissions;

import android.Manifest;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.rystal.blaze.easy.permission.EasyPermissions;
import com.rystal.blaze.easy.permission.PermissionCallbacks;
import java.util.List;

/**
 * demo.mvp.com.myapplication
 * Time: 2019/3/12 16:19
 * Description:
 */
public class CustomFragment extends Fragment implements PermissionCallbacks {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("CustomFragment");
        textView.setTextSize(36);
        return textView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*EasyPermissions.requestPermissions(this,
                11,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION},
                this
        );*/
        EasyPermissions.requestPermissions(this,
                11,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION},
                this,
                new Example()
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(getActivity(), requestCode, permissions, grantResults);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> requestPerms, @NonNull List<String> perms) {
        for (String per : perms) {
            Log.e("CustomFragment", "onPermissionsGranted --> requestCode = " + requestCode + "-- perms = " + per);
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> requestPerms, @NonNull List<String> perms) {
        for (String per : perms) {
            Log.e("CustomFragment", "onPermissionsDenied --> requestCode = " + requestCode + "-- perms = " + per);
        }

    }

    @Override
    public void onPermissionsDeniedNeverAskAgain(int requestCode, @NonNull List<String> requestPerms, @NonNull List<String> perms) {
        for (String per : perms) {
            Log.e("CustomFragment", "onPermissionsDeniedNeverAskAgain --> requestCode = " + requestCode + "-- perms = " + per);
        }
    }
}
