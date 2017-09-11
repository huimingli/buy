package com.huiming.li.buymeapp;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.huiming.li.buy.activities.ProxyActivity;
import com.huiming.li.buy.delegate.LatteDelegate;
import com.huiming.li.buy.ec.launcher.LauncherDelegate;
import com.huiming.li.buy.ec.launcher.LauncherScrollDelegate;
import com.huiming.li.buy.ec.sign.ISignListener;
import com.huiming.li.buy.ec.sign.SignUpDelegate;

public class ExampleActivity extends ProxyActivity implements ISignListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new SignUpDelegate();
    }

    @Override
    public void onSignInSuccess() {

    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_LONG).show();

    }
}
