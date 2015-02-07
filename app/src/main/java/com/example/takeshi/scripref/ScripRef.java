package com.example.takeshi.scripref;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ScripRef extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrip_ref);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrip_ref, menu);
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

    public void shareRef(View view) {
        EditText editBook = (EditText) findViewById(R.id.editBook);
        EditText editChapter = (EditText) findViewById(R.id.editChapter);
        EditText editVerse = (EditText) findViewById(R.id.editVerse);


        Intent intent = new Intent(getBaseContext(), DisplayPage.class);
        intent.putExtra("Book", editBook.getText().toString());
        intent.putExtra("Chapter", editChapter.getText().toString());
        intent.putExtra("Verse", editVerse.getText().toString());

        if (isValid(intent)) {
            startActivity(intent);
        } else {
            Toast error = Toast.makeText
                    (getBaseContext(), "Please fill every field.", Toast.LENGTH_SHORT);
            error.show();
        }
    }

    private boolean isValid(Intent intent) {
        if (intent.getStringExtra("Book").equals("") || intent.getStringExtra("Chapter").equals("")
                || intent.getStringExtra("Verse").equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
