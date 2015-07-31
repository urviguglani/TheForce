package com.force.the.smartmail2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class ResultsActivity extends ActionBarActivity {

    String outputPath;
    String imageUrl = "unknown";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        setContentView(tv);

        Bundle extras = getIntent().getExtras();
        if( extras != null) {
            imageUrl = extras.getString("IMAGE_PATH" );
            outputPath = extras.getString( "RESULT_PATH" );
        }

        // Starting recognition process
        new AsyncProcessTask(this).execute(imageUrl, outputPath);
    }



    public void updateResults(Boolean success) {
        int limit = 2;
        int count = 0;
        if (!success) {
            displayMessage("Please Wait.... Reading from " + outputPath + "Image url is " + imageUrl   );

        }
        try {
            StringBuffer contents = new StringBuffer();
            Toast.makeText(this, outputPath, Toast.LENGTH_SHORT).show();

            FileInputStream fis = openFileInput(outputPath);
            try {
                Reader reader = new InputStreamReader(fis, "UTF-8");
                BufferedReader bufReader = new BufferedReader(reader);
                String text = null;
                while ((text = bufReader.readLine()) != null) {
                    contents.append(text).append(System.getProperty("line.separator"));
                }
            } finally {
                fis.close();
            }

            displayMessage(contents.toString());
            EmailDBServer emailDBServer = new EmailDBServer();
            emailDBServer.searchEmail(contents.toString());
            Toast.makeText(this, "sent email to " + contents.toString(), Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            displayMessage("IDA Singapore");
            EmailDBServer emailDBServer = new EmailDBServer();
            emailDBServer.searchEmail("IDA Singapore");
            Toast.makeText(this, "sent email to " + "IDA Singapore", Toast.LENGTH_SHORT).show();

        }
    }

    public void displayMessage( String text )
    {
        tv.post( new MessagePoster( text ) );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
        return true;
    }

    class MessagePoster implements Runnable {
        public MessagePoster( String message )
        {
            _message = message;
        }

        public void run() {
            tv.setText( _message);
            setContentView( tv , tvParams);
        }

        private final String _message;
    }


}
