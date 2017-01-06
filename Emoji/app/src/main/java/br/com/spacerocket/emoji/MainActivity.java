package br.com.spacerocket.emoji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;
import hani.momanii.supernova_emoji_library.Helper.EmojiconTextView;

public class MainActivity extends AppCompatActivity {

    //Our variables to represent the elements on xml file and enable emojIcons
    private EmojiconEditText emojiconEditText;
    private EmojiconTextView emojiconTextView;
    ImageView emojiImageView, submitButton;
    View rootView;
    EmojIconActions emojIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init the elements
        rootView = findViewById(R.id.activity_main);
        emojiconEditText = (EmojiconEditText) findViewById(R.id.emojiconEditText);
        emojiconTextView = (EmojiconTextView) findViewById(R.id.textView);
        submitButton = (ImageView) findViewById(R.id.submit_btn);
        emojiImageView = (ImageView) findViewById(R.id.emoji_btn);
        //init the emojicon icon
        emojIcon = new EmojIconActions(this, rootView, emojiconEditText, emojiImageView);
        emojIcon.ShowEmojIcon();
        emojIcon.setIconsIds(R.drawable.ic_action_keyboard, R.drawable.smiley);
        //listen the send button click
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change the text to emoji or text
                String text = emojiconEditText.getText().toString();
                emojiconTextView.setText(text);
            }
        });
    }
}
