package com.fyxi.urbeo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;

public class CreateChallengeActivity extends Activity {

    public final static String EXTRA_CHALLENGE = "com.fyxi.urbeo.CHALLENGE";

    private final static int SELECT_PICTURE = 1;
    private String selectedImagePath;
    private String fileManagerString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_challenge);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                Log.d("URI VAL", "selectedImageUri = " + selectedImageUri.toString());
                selectedImagePath = getPath(selectedImageUri);

                if(selectedImagePath!=null){
                    // IF LOCAL IMAGE, NO MATTER IF ITS DIRECTLY FROM GALLERY (EXCEPT PICASSA ALBUM),
                    // OR OI/ASTRO FILE MANAGER. EVEN DROPBOX IS SUPPORTED BY THIS BECAUSE DROPBOX DOWNLOAD THE IMAGE
                    // IN THIS FORM - file:///storage/emulated/0/Android/data/com.dropbox.android/...
                    System.out.println("local image");
                }
                else{
                    System.out.println("picasa image!");
                    loadPicasaImageFromGallery(selectedImageUri);
                }
            }
        }
    }

    // NEW METHOD FOR PICASA IMAGE LOAD
    private void loadPicasaImageFromGallery(final Uri uri) {
        String[] projection = {  MediaStore.MediaColumns.DATA, MediaStore.MediaColumns.DISPLAY_NAME };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(MediaStore.MediaColumns.DISPLAY_NAME);
            if (columnIndex != -1) {
                new Thread(new Runnable() {
                    // NEW THREAD BECAUSE NETWORK REQUEST WILL BE MADE THAT WILL BE A LONG PROCESS & BLOCK UI
                    // IF CALLED IN UI THREAD
                    public void run() {
                        try {
                            Bitmap bitmap = android.provider.MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                            // THIS IS THE BITMAP IMAGE WE ARE LOOKING FOR.
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }).start();
            }
        }
        cursor.close();
    }

    public String getPath(Uri uri) {
        String[] projection = {  MediaStore.MediaColumns.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if(cursor != null) {
            //HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            //THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            String filePath = cursor.getString(columnIndex);
            cursor.close();
            return filePath;
        }
        else
            return uri.getPath();               // FOR OI/ASTRO/Dropbox etc
    }

    public void createChallenge(View view) {
        getIntent();

        Intent intent = new Intent(this, CreateChallengeActivity.class);

        String[] content = new String[Challenge.BONUS + 1];
        content[Challenge.WHAT] = getEditContent(R.id.createWhatEdit);
        content[Challenge.WHERE] = getEditContent(R.id.createWhereEdit);
        content[Challenge.HOW] = getEditContent(R.id.createHowEdit);
        content[Challenge.BONUS] = getEditContent(R.id.createBonusEdit);

        intent.putExtra(EXTRA_CHALLENGE, content);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public String getEditContent(int myId) {
        EditText editText = (EditText) findViewById(myId);
        return editText.getText().toString();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_challenge, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_create_challenge, container, false);

            ((Button) rootView.findViewById(R.id.createUploadImage)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
                }
            });
            return rootView;
        }
    }
}
