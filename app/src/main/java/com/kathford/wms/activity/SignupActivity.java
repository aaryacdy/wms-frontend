package com.kathford.wms.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kathford.wms.R;
import com.kathford.wms.retrofit.RetrofitService;
import com.kathford.wms.retrofit.api.AdminApi;

import java.io.File;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class SignupActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText addressEditText;
    private EditText mobileNumberEditText;

    private RadioGroup genderRadioGroup;

    private Button signupButton;

    private Spinner countrySpinner;
    private String TAG = SignupActivity.class.getCanonicalName();

    private String selectedGenderValue;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initViews();
        buttonClickListener();

        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                selectedGenderValue = radioButton.getText().toString().trim();
            }
        });
    }

    private void initViews() {
        fullNameEditText = findViewById(R.id.fullNameEditText);
        addressEditText = findViewById(R.id.addressEdiText);
        mobileNumberEditText = findViewById(R.id.mobileEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        countrySpinner = findViewById(R.id.countrySpinner);
        signupButton = findViewById(R.id.singupButton);
    }


    private void buttonClickListener() {
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = fullNameEditText.getText().toString().trim();
                String address = addressEditText.getText().toString().trim();
                String mobileNumber = mobileNumberEditText.getText().toString().trim();
                String country = countrySpinner.getSelectedItem().toString();

                System.out.println(fullName + " fullName ");
                System.out.println(address + " address ");
                System.out.println(mobileNumber + " mobileNumber ");
                System.out.println(country + " country ");

                Log.i(TAG, country);

                int checkedRadioButtonId = genderRadioGroup.getCheckedRadioButtonId();
                RadioButton genderRadioButton = (RadioButton) findViewById(checkedRadioButtonId);
                String genderValue = genderRadioButton.getText().toString().trim();

//                Log.i(TAG, selectedGenderValue);
                if (fullName != null && !fullName.isEmpty()) {
                    if (fullName.length() >= 3) {
                        if (address != null && !address.isEmpty()) {
                            if (mobileNumber != null && !mobileNumber.isEmpty()) {
                                Toast.makeText(SignupActivity.this, "Form validation success", Toast.LENGTH_SHORT).show();

                                //now here we can call the api for further process so that we can save the dat
                                Retrofit r = new RetrofitService().getRetrofit();
                                AdminApi adminApi = r.create(AdminApi.class);

                                /*MultipartBody.Builder builder = new MultipartBody.Builder()
                                        .setType(MultipartBody.FORM)
                                        .addFormDataPart("name", "John Doe")
                                        .addFormDataPart("email", "johndoe@example.com")
                                        .addFormDataPart("message", "Hello, world!");*/

                                // Add file(s) to the request if needed
                                /*File file = new File("path/to/file");
                                RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                                builder.addFormDataPart("file", file.getName(), requestBody);
                                MultipartBody requestBody = builder.build();*/

                                // Create a Call object for the API endpoint with the form data
                                /*Call<ResponseBody> call = adminApi.saveOrUpdateAdmin(
                                        "John Doe",
                                        "johndoe",
                                        "password123",
                                        "johndoe@example.com",
                                        "123 Main St",
                                        "admin",
                                        "1234567",
                                        "9876543210"
                                );

                                // Asynchronously execute the API call
                                call.enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                        // Handle successful response
                                    }

                                    @Override
                                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                                        // Handle error
                                    }
                                });*/


                            } else {
                                mobileNumberEditText.setError("Mobile number field is empty");
                            }
                        } else {
                            addressEditText.setError("Address field is empty.");
                        }
                    } else {
                        fullNameEditText.setError("Invalid full name");
                    }
                } else {
                    fullNameEditText.setError("Full name field is empty.");
                }
            }
        });
    }
}
