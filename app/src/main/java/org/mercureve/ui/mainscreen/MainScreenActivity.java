package org.mercureve.ui.mainscreen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mercureve.ApplicationConstants;
import org.mercureve.R;
import org.mercureve.domain.AuthorizedCharacter;
import org.mercureve.domain.Location;
import org.mercureve.exception.AuthTokenExpiredException;
import org.mercureve.util.InjectorUtils;
import org.mercureve.util.SessionContext;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainScreenActivity extends AppCompatActivity implements MainScreenController.Display {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.textView)
    TextView textView;

    @Inject
    MainScreenController controller;

    private AuthorizedCharacter character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        InjectorUtils.getInjector().inject(this);
        controller.setDisplay(this);

        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        if (Intent.ACTION_MAIN.equals(intent.getAction())) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ApplicationConstants.EVE_LOGIN_AUTH_CODE_URL));
            startActivity(browserIntent);
        }

        if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Uri uri = intent.getData();
            controller.authenticate(uri.getQueryParameter("code"));
            character = controller.getCharacter();
            textView.setText(character.toString());
        }
    }

    @OnClick(R.id.fab)
    void onFabClick(View view) {
        Location location = controller.getLocation(character.getCharacterId().toString());
        textView.setText(location.toString());
    }
}
