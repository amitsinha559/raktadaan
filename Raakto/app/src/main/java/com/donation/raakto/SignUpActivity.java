package com.donation.raakto;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class SignUpActivity extends Activity {

    EditText editName;
    EditText editEmail;
    EditText editPhoneNumber;
    EditText editAge;
    EditText editBloodGroup;
    EditText editPassword;
    EditText editConfirmPassword;
    EditText editCountry;
    EditText editState;
    EditText editCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void saveDetails() {
        editName = (EditText) findViewById(R.id.editTextName);
        String name = editName.getText().toString();

        editName = (EditText) findViewById(R.id.editTextEmail);
        String email = editEmail.getText().toString();

        editPhoneNumber = (EditText) findViewById(R.id.editTextPhoneNumber);
        String phoneNumber = editPhoneNumber.getText().toString();

        editAge = (EditText) findViewById(R.id.editTextAge);
        String age = editAge.getText().toString();

        editBloodGroup = (EditText) findViewById(R.id.editTextBloodGroup);
        String bloodGroup = editBloodGroup.getText().toString();

        editPassword = (EditText) findViewById(R.id.editTextPassword);
        String password = editPassword.getText().toString();

        editConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
        String confirmPassword = editConfirmPassword.getText().toString();

        editCountry = (EditText) findViewById(R.id.editTextCountry);
        String country = editCountry.getText().toString();

        editState = (EditText) findViewById(R.id.editTextState);
        String state = editState.getText().toString();

        editCity = (EditText) findViewById(R.id.editTextCity);
        String city = editCity.getText().toString();

        RaaktoService raaktoService = new RaaktoService(this);

        raaktoService.saveData(name, email, phoneNumber, age, bloodGroup, password, country, state, city);
    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
