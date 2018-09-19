package com.yogesh.imageeditsample;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.yogesh.bsmultipicker.BSMultiPicker;
import com.yogesh.bsmultipicker.utils.Utils;
import com.yogesh.imageediterlib.EditImageActivity;



public class MainActivity extends AppCompatActivity implements BSMultiPicker.OnSingleImageSelectedListener{

    Context mContext;
    ImageView image_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = this;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        image_view = (ImageView) findViewById(R.id.image_view);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BSMultiPicker singleSelectionPicker = new BSMultiPicker.Builder("com.yogesh.imageediter.fileprovider")
                        .setMaximumDisplayingImages(24) //Default: Integer.MAX_VALUE. Don't worry about performance :)
                        .showVideo(false) //for select video also Default only image picker shoe Default: false
                        .setSpanCount(3) //Default: 3. This is the number of columns
                        .setGridSpacing(Utils.dp2px(2)) //Default: 2dp. Remember to pass in a value in pixel.
                        .setPeekHeight(Utils.dp2px(360)) //Default: 360dp. This is the initial height of the dialog.
                        .build();
                singleSelectionPicker.show(getSupportFragmentManager(), "picker");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onSingleImageSelected(Uri uri) {
        Intent editImage = new Intent(this, EditImageActivity.class);
        editImage.putExtra(EditImageActivity.EXTRA_IMAGE_PATHS, uri.getPath());
        startActivityForResult(editImage, EditImageActivity.REQ_IMAGE_EDITOR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("MainActivity","onActivityResult resultCode ="+resultCode);
        Log.i("MainActivity","onActivityResult requestCode ="+requestCode);
       // if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case EditImageActivity.REQ_IMAGE_EDITOR:
                    if (data != null) {
                        Uri editedImageUri = data.getParcelableExtra(EditImageActivity.SELECTED_IMAGES);
                        Log.i("ClickFrag", "onActivityResult REQ_IMAGE_EDITOR editedImageUri =" + editedImageUri.getPath());
                        if (editedImageUri != null) {
                            image_view.setImageURI(editedImageUri);
                        }
                    }
                    break;
            }
        //}
    }
}
