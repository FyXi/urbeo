package com.fyxi.urbeo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;

public class CreateChallengeActivity extends Activity {

    public final static String EXTRA_CHALLENGE = "com.fyxi.urbeo.CHALLENGE";

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
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_create_challenge, container, false);
            return rootView;
        }
    }
}
