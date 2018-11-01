package com.example.moaathalrajab.week9_firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.moaathalrajab.week9_firebasedemo.model.ChatMessage;
import com.example.moaathalrajab.week9_firebasedemo.model.ChatMsgAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String senderName="MoaathAlrajab";
    private ListView listView;

    private Button sendBtn;
    EditText editText;
    ChatMsgAdapter mChatMsgAdapter;
    List<ChatMessage> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        itemList=new ArrayList<>();



        sendBtn=(Button)findViewById(R.id.send_msg);
        editText=(EditText)findViewById(R.id.input_msg);


        listView=(ListView)findViewById(R.id.lstview);


        mChatMsgAdapter=new ChatMsgAdapter(this,R.layout.chat_msg_item,itemList);

        listView.setAdapter(mChatMsgAdapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });



    }


    public void fillWithNonsenseText() {
        itemList.add(new ChatMessage("Hello", "Ben"));
        itemList.add(new ChatMessage("Hello", "Noor"));
        itemList.add(new ChatMessage("This is an example about RecyclerView", "Ben"));
        itemList.add(new ChatMessage("Great news!", "Noor"));
        itemList.add(new ChatMessage("Enjoy reading!", "Ben"));
        itemList.add(new ChatMessage("You too", "Noor"));
        itemList.add(new ChatMessage("Hello", "Ben"));
        itemList.add(new ChatMessage("Hello", "Noor"));
        itemList.add(new ChatMessage("This is an example about RecyclerView", "Ben"));
        itemList.add(new ChatMessage("Great news!", "Noor"));
        itemList.add(new ChatMessage("Enjoy reading!", "Ben"));
        itemList.add(new ChatMessage("You too", "Noor"));
        itemList.add(new ChatMessage("Hello", "Ben"));
        itemList.add(new ChatMessage("Hello", "Noor"));
        itemList.add(new ChatMessage("This is an example about RecyclerView", "Ben"));
        itemList.add(new ChatMessage("Great news!", "Noor"));
        itemList.add(new ChatMessage("Enjoy reading!", "Ben"));
        itemList.add(new ChatMessage("You too", "Noor"));

    }
}
