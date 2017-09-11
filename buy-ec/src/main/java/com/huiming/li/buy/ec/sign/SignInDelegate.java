package com.huiming.li.buy.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import com.huiming.li.buy.delegate.BaseDelegate;
import com.huiming.li.buy.ec.R;
import com.huiming.li.buy.ec.R2;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author huimingli
 * @date 2017-09-05 21:10:44
 * @description
 */

public class SignInDelegate extends BaseDelegate {

    @BindView(R2.id.edit_signin_email)
    TextInputEditText tv_email = null;

    @BindView(R2.id.edit_signin_password)
    TextInputEditText tv_password = null;

    @OnClick(R2.id.btn_signin)
    void onClickSignin(){
        if (checkForm()){

        }
    }
    @OnClick(R2.id.icon_signin_in_wechat)
    void onClickWechat(){

    }

    @OnClick(R2.id.tv_signup)
    void onClickLink() {
        start(new SignUpDelegate());
    }

    private boolean checkForm(){
        final String email = tv_email.getText().toString();
        final String password = tv_password.getText().toString();
        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            tv_email.setError("邮箱格式错误");
            isPass = false;
        } else {
            tv_email.setError(null);
        }

        if (password.isEmpty() || password.length() <6){
            tv_password.setError("请输入至少6位的密码");
            isPass = false;
        } else {
            tv_password.setError(null);
        }

        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_signin;
    }

    @Override
    public void onBindView(@Nullable Bundle saveInstanceState, View rootView) {

    }
}
