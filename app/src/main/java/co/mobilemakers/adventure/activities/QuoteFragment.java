package co.mobilemakers.adventure.activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import co.mobilemakers.adventure.R;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private final static String USERNAME_PREFERENCE = "username_preference";

    TextView mTextViewQuote;
    TextView mTextViewUserIntro;

    public QuoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_quote, container, false);
        wireUpViews(rootView);
        displayUserIntro();
        displayRandomQuote();
        return rootView;
    }

    private void displayUserIntro() {
        String username = getUsername();
        String user_intro = String.format(getString(R.string.user_intro), username);
        mTextViewUserIntro.setText(user_intro);
    }

    private String getUsername() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        return sharedPreferences.getString(USERNAME_PREFERENCE, getString(R.string.default_username));
    }

    private void wireUpViews(View rootView) {
        mTextViewQuote = (TextView)rootView.findViewById(R.id.text_view_quote);
        mTextViewUserIntro = (TextView)rootView.findViewById(R.id.text_view_user_intro);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_fragment_quote, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Boolean handled = false;

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_refresh_quote:
                displayRandomQuote();
                handled = true;
                break;
            case R.id.action_share:
                shareQuote();
                handled = true;
                break;
        }
        if (!handled) {
            handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    private void displayRandomQuote() {

        mTextViewQuote.setText("esto era quote");
    }

    private void shareQuote() {
        String quote = mTextViewQuote.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, quote);

        startActivity(intent);
    }
}
