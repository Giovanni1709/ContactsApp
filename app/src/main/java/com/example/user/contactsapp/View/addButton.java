package com.example.user.contactsapp.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.user.contactsapp.R;

/**
 * Created by giova on 04-Apr-18.
 */

public class addButton extends AppCompatButton {

    public addButton(Context context) {
        super(context);
    }

    public addButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public addButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setBackground(this.getContext().getDrawable(R.drawable.white));

        Paint blue= new Paint();
        blue.setColor(Color.BLUE);

        Paint white = new Paint();
        white.setColor(Color.WHITE);

        Paint transparent = new Paint();
        transparent.setColor(Color.TRANSPARENT);

        int middley= getHeight()/2;
        int middlex = getWidth() / 2;


        canvas.drawCircle(middlex,middley,getHeight()/2,blue);
        canvas.drawRect(middlex-getWidth()/3,middley-getHeight()/10,middlex+getWidth()/3,middley+getHeight()/10,white);
        canvas.drawRect(middlex-getWidth()/10,middley+getHeight()/3,middlex+getWidth()/10,middley-getHeight()/3,white);
    }
}
