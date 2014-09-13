package com.fyxi.urbeo;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.os.Build;
import android.widget.Toast;

import java.util.ArrayList;



public class Urbeo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urbeo);
//        if (savedInstanceState == null) {
//            getFragmentManager().beginTransaction()
//                    .add(R.id.container, new PlaceholderFragment())
//                    .commit();
//        }

        ArrayList challenges = getChallenges();
        final ListView lv1 = (ListView) findViewById(R.id.custom_list);
        lv1.setAdapter(new CustomListAdapter(this, challenges));

        lv1.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                Challenge challenge = (Challenge) o;
                Toast.makeText(Urbeo.this, "Selected :" + " " + challenge, Toast.LENGTH_LONG).show();
            }
        });

    }

    private ArrayList getChallenges() {
        ArrayList challenges = new ArrayList();
        Challenge challenge = new Challenge();
        challenge.setHeadline("Dance of Democracy");
        challenge.setReporterName("Pankaj Gupta");
        challenge.setDate("May 26, 2013, 13:35");
        //challenge.setImageSource("")
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("Major Naxal attacks in the past");
        challenge.setReporterName("Pankaj Gupta");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("BCCI suspends Gurunath pending inquiry ");
        challenge.setReporterName("Rajiv Chandan");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("Life convict can`t claim freedom after 14 yrs: SC");
        challenge.setReporterName("Pankaj Gupta");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("Indian Army refuses to share info on soldiers mutilated at LoC");
        challenge.setReporterName("Pankaj Gupta");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("French soldier stabbed; link to Woolwich attack being probed");
        challenge.setReporterName("Sudeep Nanda");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("Major Naxal attacks in the past");
        challenge.setReporterName("Pankaj Gupta");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("BCCI suspends Gurunath pending inquiry ");
        challenge.setReporterName("Rajiv Chandan");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("Life convict can`t claim freedom after 14 yrs: SC");
        challenge.setReporterName("Pankaj Gupta");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("Indian Army refuses to share info on soldiers mutilated at LoC");
        challenge.setReporterName("Pankaj Gupta");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("French soldier stabbed; link to Woolwich attack being probed");
        challenge.setReporterName("Sudeep Nanda");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("Major Naxal attacks in the past");
        challenge.setReporterName("Pankaj Gupta");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("BCCI suspends Gurunath pending inquiry ");
        challenge.setReporterName("Rajiv Chandan");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("Life convict can`t claim freedom after 14 yrs: SC");
        challenge.setReporterName("Pankaj Gupta");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("Indian Army refuses to share info on soldiers mutilated at LoC");
        challenge.setReporterName("Pankaj Gupta");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        challenge = new Challenge();
        challenge.setHeadline("French soldier stabbed; link to Woolwich attack being probed");
        challenge.setReporterName("Sudeep Nanda");
        challenge.setDate("May 26, 2013, 13:35");
        challenges.add(challenge);

        return challenges;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.urbeo, menu);
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
            View rootView = inflater.inflate(R.layout.list_row_layout, container, false);
            return rootView;
        }
    }
}
