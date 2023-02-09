package com.example.implicitintentsreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;
    private static final int CAMERA_REQUEST= 1888;

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);


        imageView = (ImageView) this.findViewById(R.id.image);

        Button photoButton = (Button) this.findViewById(R.id.button_picture);

        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }

        });
    }

    private void SetContentView(int activity_main) {
    }

    public void openWebsite(View view) {
        // Get the URL text.
        String url = mWebsiteEditText.getText().toString();

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void openLocation(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        String loc = mLocationEditText.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser();
    }
}
