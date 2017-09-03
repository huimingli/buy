package com.huiming.li.buymeapp;
import com.huiming.li.buy.activities.ProxyActivity;
import com.huiming.li.buy.delegate.LatteDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
