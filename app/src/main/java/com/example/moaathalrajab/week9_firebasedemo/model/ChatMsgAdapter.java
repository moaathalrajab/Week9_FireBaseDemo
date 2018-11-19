package com.example.moaathalrajab.week9_firebasedemo.model;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.moaathalrajab.week9_firebasedemo.R;

import java.util.List;



/**
 * Created by m_alrajab on 4/5/17.
 */

public class ChatMsgAdapter extends ArrayAdapter<ChatMessage> {
    public ChatMsgAdapter( Context context,  int resource,  List<ChatMessage> objects) {
        super(context, resource, objects);
    }


    public View getView(int position,  View convertView, ViewGroup parent) {

        if(convertView==null)
            convertView= ((Activity)getContext()).getLayoutInflater().inflate(
                    R.layout.chat_msg_item,parent,false);

        TextView msgBody=(TextView)convertView.findViewById(R.id.cht_itm_body);
        TextView username=(TextView)convertView.findViewById(R.id.cht_itm_username);

        ChatMessage  message=getItem(position);

        if(message!=null) {
            msgBody.setText(message.getMsg());
            username.setText(message.getUsername());
        }

        return convertView;
    }
}
