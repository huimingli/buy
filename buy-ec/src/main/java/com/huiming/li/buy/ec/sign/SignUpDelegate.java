package com.huiming.li.buy.ec.sign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.huiming.li.buy.delegate.LatteDelegate;
import com.huiming.li.buy.ec.R;
import com.huiming.li.buy.ec.R2;
import com.huiming.li.buy.net.RestClient;
import com.huiming.li.buy.net.callback.ISuccess;
import com.huiming.li.buy.utils.log.LatteLogger;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author huimingli
 * @date 2017-09-05 09:47:50
 * @description
 */

public class SignUpDelegate extends LatteDelegate {

    @BindView(R2.id.edit_signup_name)
    TextInputEditText tv_name = null;

    @BindView(R2.id.edit_signup_email)
    TextInputEditText tv_email = null;

    @BindView(R2.id.edit_signup_phone)
    TextInputEditText tv_phone = null;

    @BindView(R2.id.edit_signup_password)
    TextInputEditText tv_password = null;

    @BindView(R2.id.edit_signup_confirmpassword)
    TextInputEditText tv_confirmPassword = null;

    private ISignListener signListener = null;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ISignListener){
            signListener = (ISignListener) activity;
        }
    }

    @OnClick(R2.id.btn_signup)
    void onClickSignup(){
        if (checkForm()){
            RestClient.builder()
                    .url("http://106.15.178.177/RestServer/api/user_profile.php")
                    .params("name", tv_name.getText().toString())
                    .params("email", tv_email.getText().toString())
                    .params("phone", tv_phone.getText().toString())
                    .params("password", tv_password.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatteLogger.json("USER_PROFILE", response);

                            SignHandler.onSignUp(response,signListener);
                        }
                    })
                    .build()
                    .post();
        }
    }

    @OnClick(R2.id.tv_signin)
    void onClickLink() {
        start(new SignInDelegate());
    }

    private boolean checkForm(){
        final String name = tv_name.getText().toString();
        final String email = tv_email.getText().toString();
        final String phone = tv_phone.getText().toString();
        final String password = tv_password.getText().toString();
        final String confirmPassword = tv_confirmPassword.getText().toString();
        boolean isPass = true;
        if (name.isEmpty()){
            tv_name.setError("请输入姓名");
            isPass = false;
        } else {
            tv_name.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            tv_email.setError("邮箱格式错误");
            isPass = false;
        } else {
            tv_email.setError(null);
        }

        if (phone.isEmpty() || phone.length() != 11){
            tv_phone.setError("手机号码错误");
            isPass = false;
        } else {
            tv_phone.setError(null);
        }

        if (password.isEmpty() || password.length() <6){
            tv_password.setError("请输入至少6位的密码");
            isPass = false;
        } else {
            tv_password.setError(null);
        }

        if (confirmPassword.isEmpty() || confirmPassword.length() <6 || !confirmPassword.equals(password)){
            tv_confirmPassword.setError("密码验证错误");
            isPass = false;
        } else {
            tv_confirmPassword.setError(null);
        }
        return isPass;
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_signup;
    }

    @Override
    public void onBindView(@Nullable Bundle saveInstanceState, View rootView) {


    }
}
