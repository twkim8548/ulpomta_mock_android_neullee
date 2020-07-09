package com.example.passion.src.SignIn.FindEmailInPw.SendEmail;

import com.example.passion.src.SignIn.FindEmailInPw.SendEmail.interfaces.SendEmailActivityView;
import com.example.passion.src.SignIn.FindEmailInPw.SendEmail.interfaces.SendEmailRetrofitInterface;
import com.example.passion.src.SignIn.FindEmailInPw.SendEmail.models.SendEmailBody;
import com.example.passion.src.SignIn.FindEmailInPw.SendEmail.models.SendEmailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.passion.src.ApplicationClass.getRetrofit;

public class SendEmailService {
    private final SendEmailActivityView mSendEmailActivityView;

    public SendEmailService(final SendEmailActivityView sendEmailActivityView) {
        this.mSendEmailActivityView = sendEmailActivityView;
    }

    //Post 로그인
    public void getFindEmailInPw(String email) {
        final SendEmailRetrofitInterface sendEmailRetrofitInterface = getRetrofit().create(SendEmailRetrofitInterface.class);
        sendEmailRetrofitInterface.getFindEmailInPw(new SendEmailBody(email)).enqueue(new Callback<SendEmailResponse>() {
            //성공시 도는 화면
            @Override
            public void onResponse(Call<SendEmailResponse> call, Response<SendEmailResponse> response) {
                final SendEmailResponse sendEmailResponse = response.body();
                if (sendEmailResponse == null) {//<설명> 응답 없음
                    mSendEmailActivityView.timeCheckFailure(null);
                    return;
                } else if (sendEmailResponse.isSuccess()) {//<설명> 계정 있음
                    mSendEmailActivityView.timeCheckSuccess(sendEmailResponse.getMessage());
                } else {//<설명> 계정 없음
                    mSendEmailActivityView.timeCheckFailure(sendEmailResponse.getMessage());
                }


            }

            //실패시 도는 화면
            @Override
            public void onFailure(Call<SendEmailResponse> call, Throwable t) {
                mSendEmailActivityView.timeCheckFailure(null);
            }
        });
    }

}
