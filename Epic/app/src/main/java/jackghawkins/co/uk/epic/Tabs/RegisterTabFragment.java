package jackghawkins.co.uk.epic.Tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import jackghawkins.co.uk.epic.R;

public class RegisterTabFragment extends Fragment {

    EditText email;
    EditText password;
    EditText confirmPassword;
    Button register;
    float v = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_fragment,container,false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.password);
        confirmPassword = root.findViewById(R.id.confirm_password);
        register = root.findViewById(R.id.signup_button);

        email.setTranslationX(800);
        password.setTranslationX(800);
        confirmPassword.setTranslationX(800);
        register.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        confirmPassword.setAlpha(v);
        register.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(400).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(600).start();
        confirmPassword.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(800).start();
        register.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1000).start();

        return root;
    }
}
