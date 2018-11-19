package com.example.moaathalrajab.week9_firebasedemo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.moaathalrajab.week9_firebasedemo.model.ChatMessage;
import com.example.moaathalrajab.week9_firebasedemo.model.ChatMsgAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String senderName="MoaathAlrajab";
    private ListView listView;

    FirebaseDatabase database ;
    DatabaseReference myRef ;

    private Button sendBtn;
    EditText editText;
    ChatMsgAdapter mChatMsgAdapter;
    List<ChatMessage> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         database = FirebaseDatabase.getInstance();
         myRef = database.getReference("chats");

        itemList=new ArrayList<>();



        sendBtn=(Button)findViewById(R.id.send_msg);
        editText=(EditText)findViewById(R.id.input_msg);


        listView=(ListView)findViewById(R.id.lstview);


        mChatMsgAdapter=new ChatMsgAdapter(this,R.layout.chat_msg_item,itemList);

        listView.setAdapter(mChatMsgAdapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=editText.getText().toString();
                myRef.push().setValue(new ChatMessage(str,senderName));
                editText.setText("");


            }
        });


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ChatMessage msg= dataSnapshot.getValue(ChatMessage.class);
                mChatMsgAdapter.add(msg);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }


}
