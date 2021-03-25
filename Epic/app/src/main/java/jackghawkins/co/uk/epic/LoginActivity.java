package jackghawkins.co.uk.epic;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import jackghawkins.co.uk.epic.Adapters.LoginAdapter;

public class LoginActivity extends AppCompatActivity {

    //https://www.youtube.com/watch?v=ayKMfVt2Sg4 working on this


    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton fb,google;
    float v = 0;

    /**
     * Code for creating a new account
     *         try {
     *             Amplify.addPlugin(new AWSCognitoAuthPlugin());
     *             Amplify.configure(getApplicationContext());
     *             Log.i("MyAmplifyApp", "Initialized Amplify");
     *         } catch (AmplifyException error) {
     *             Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
     *         }
     *
     *         Amplify.Auth.fetchAuthSession(
     *                 result -> Log.i("AmplifyQuickstart", result.toString()),
     *                 error -> Log.e("AmplifyQuickstart", error.toString())
     *         );
     *
     *         AuthSignUpOptions options = AuthSignUpOptions.builder()
     *                 .userAttribute(AuthUserAttributeKey.email(), "my@email.com")
     *                 .build();
     *         Amplify.Auth.signUp("my@email.com", "Test12354!", options,
     *                 result -> Log.i("AuthQuickStart", "Result: " + result.toString()),
     *                 error -> Log.e("AuthQuickStart", "Sign up failed", error)
     *         );
     *         Amplify.Auth.confirmSignUp(
     *                 "username",
     *                 "the code you received via email",
     *                 result -> Log.i("AuthQuickstart", result.isSignUpComplete() ? "Confirm signUp succeeded" : "Confirm sign up not complete"),
     *                 error -> Log.e("AuthQuickstart", error.toString())
     *         );
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        fb = findViewById(R.id.fa_facebook);
        google = findViewById(R.id.fa_google);

        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Login");
        tabLayout.getTabAt(1).setText("Signup");


        fb.setTranslationY(300);
        google.setTranslationY(300);

        fb.setAlpha(v);
        google.setAlpha(v);

        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();



    }





}